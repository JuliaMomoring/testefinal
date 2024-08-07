package dell2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CadastroTimes cadastro = new CadastroTimes();
        cadastro.cadastrarTimes();
        
        ArrayList<Time> times = cadastro.getTimes();
        
        // Cria e inicia o campeonato
        Fase fase = new Fase(times);
        fase.iniciar();

        // Exibe o resultado final
        Final finalCampeonato = new Final(times);
        finalCampeonato.exibirResultado();
    }
}
