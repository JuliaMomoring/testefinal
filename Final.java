package dell2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Final {
    private ArrayList<Time> times;

    public Final(ArrayList<Time> times) {
        this.times = times;
    }

    public void exibirResultado() {
        Collections.sort(times, new Comparator<Time>() {
            @Override
            public int compare(Time t1, Time t2) {
                return Integer.compare(t2.getPontuacaoTotal(), t1.getPontuacaoTotal());
            }
        });

        System.out.println("===Placar final===");
        for (Time time : times) {
            System.out.println(time.getNome() + " - Blots: " + time.getBlots() + ", Plifs: " + time.getPlifs() + ", Advrunghs: " + time.getAdvrunghs() + ", Pontuação Total: " + time.getPontuacaoTotal());
        }
        
        System.out.println(" ");

        System.out.println("Grito de guerra do time campeão: " +"==="+ times.get(0).getGritoGuerra()+"===");
    }
}

