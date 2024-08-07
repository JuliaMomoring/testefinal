package dell2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Fase {
    private ArrayList<Partida> partidas;
    private Scanner scanner;

    public Fase(ArrayList<Time> times) {
        this.partidas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        criarPartidas(times);
    }

    private void criarPartidas(ArrayList<Time> times) {
        Collections.shuffle(times); // Embaralha os times para criar duplas aleatórias

        for (int i = 0; i < times.size(); i += 2) {
            partidas.add(new Partida(times.get(i), times.get(i + 1)));
        }
    }

    public void iniciar() {
        while (!partidas.isEmpty()) {
            exibirPartidasDisponiveis();
            int escolha = obterEscolha();

            if (escolha < 1 || escolha > partidas.size()) {
                System.out.println("Escolha inválida. Tente novamente.");
                continue;
            }

            Partida partida = partidas.get(escolha - 1);
            partida.administrar();
            partidas.remove(partida);
        }
    }

    private void exibirPartidasDisponiveis() {
        System.out.println("Escolha uma partida para administrar:");
        for (int i = 0; i < partidas.size(); i++) {
            Partida partida = partidas.get(i);
            System.out.println((i + 1) + " |" + partida.getTime1().getNome() + " vs " + partida.getTime2().getNome()+"|");
        }
    }

    private int obterEscolha() {
        int escolha = -1;
        while (escolha < 1) {
            try {
                System.out.print("Digite o número da partida: ");
                escolha = scanner.nextInt();
                scanner.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next(); 
            }
        }
        return escolha;
    }
}
