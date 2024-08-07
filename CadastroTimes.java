package dell2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CadastroTimes {
    private ArrayList<Time> times;

    public CadastroTimes() {
        times = new ArrayList<>();
    }

    public void cadastrarTimes() {
        Scanner scanner = new Scanner(System.in);
        int numTimes = 0;

        while (numTimes < 8 || numTimes > 16 || numTimes % 2 != 0) {
            try {
                System.out.print("Digite o número de times (entre 8 e 16, e deve ser par): ");
                numTimes = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
                if (numTimes < 8 || numTimes > 16 || numTimes % 2 != 0) {
                    System.out.println("Número inválido. Deve ser um número par entre 8 e 16.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next(); // Limpar o buffer do scanner
            }
        }

        for (int i = 0; i < numTimes; i++) {
            System.out.println("Cadastro do time " + (i + 1) + ":");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Grito de guerra: ");
            String gritoGuerra = scanner.nextLine();
            int anoFundacao = 0;

            while (anoFundacao <= 0) {
                try {
                    System.out.print("Ano de fundação: ");
                    anoFundacao = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    if (anoFundacao <= 0) {
                        System.out.println("Ano inválido. Deve ser um número positivo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite um ano válido.");
                    scanner.next(); // Limpar o buffer do scanner
                }
            }

            Time time = new Time(nome, gritoGuerra, anoFundacao);
            times.add(time);
        }

        // scanner.close(); // Evite fechar o Scanner se você ainda precisar dele
    }

    public ArrayList<Time> getTimes() {
        return times;
    }
}
