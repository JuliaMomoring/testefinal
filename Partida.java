package dell2;

import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
    private Time time1;
    private Time time2;
    private int pontosTime1;
    private int pontosTime2;
    private Scanner scanner;

    public Partida(Time time1, Time time2) {
        this.time1 = time1;
        this.time2 = time2;
        this.pontosTime1 = 50;
        this.pontosTime2 = 50;
        this.scanner = new Scanner(System.in);
    }

    public Time getTime1() {
        return time1;
    }

    public Time getTime2() {
        return time2;
    }

    public ArrayList<Time> getVencedores() {
        ArrayList<Time> vencedores = new ArrayList<>();
        if (pontosTime1 > pontosTime2) {
            vencedores.add(time1);
        } else if (pontosTime2 > pontosTime1) {
            vencedores.add(time2);
        } else {
            // Empate - Grusht
            if (realizarGrusht()) {
                vencedores.add(time1);
            } else {
                vencedores.add(time2);
            }
        }
        return vencedores;
    }

    private boolean realizarGrusht() {
        // Simula o grusht
        return Math.random() < 0.5;
    }

    public void administrar() {
        while (true) {
            exibirPainel();
            System.out.println("");
            System.out.println("===Aperte um botão para marcar pontos==");
            System.out.println("[1]: Blot para o Time 1");
            System.out.println("[2]: Blot para o Time 2");
            System.out.println("[3]: Plif para o Time 1");
            System.out.println("[4]: Plif para o Time 2");
            System.out.println("[5]: Penalidade para o Time 1");
            System.out.println("[6]: Penalidade para o Time 2");
            System.out.println("[7]: Encerrar partida");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (escolha) {
                case 1:
                    pontosTime1 += 5;
                    time1.adicionarBlots(5);
                    break;
                case 2:
                    pontosTime2 += 5;
                    time2.adicionarBlots(5);
                    break;
                case 3:
                    pontosTime2 += 1;
                    time1.adicionarPlifs(1);
                    break;
                case 4:
                    pontosTime1 += 1;
                    time2.adicionarPlifs(1);
                    break;
                case 5:
                    pontosTime1 -= 10;
                    time1.removerAdvrunghs(10);
                    break;
                case 6:
                    pontosTime2 -= 10;
                    time2.removerAdvrunghs(10);
                    break;
                case 7:
                    System.out.println("===Partida encerrada===");
                    return; // Encerrar a partida
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    private void exibirPainel() {
        System.out.println("Partida: " + time1.getNome() + " vs " + time2.getNome());
        System.out.println("Pontuação: " + time1.getNome() + " - " + pontosTime1 + " | " + time2.getNome() + " - " + pontosTime2);
    }
}
