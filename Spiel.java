package QuizDuell;

import java.io.IOException;
import java.util.ArrayList;

public class Spiel extends Thread {
    private Spieler spieler1;
    private Spieler spieler2;
    private ArrayList<Frage> fragen;

    public Spiel(Spieler s1, Spieler s2, ArrayList<Frage> fragen) {
        this.fragen = new ArrayList<>();

        this.fragen = fragen;
        this.spieler1 = s1;
        this.spieler2 = s2;

        this.start();

    }

    public void run() {

        int punkteS1 = 0;
        int punkteS2 = 0;

        for (Frage frage : fragen) {
            try{
                
            
            this.spieler1.getSocket().write(frage.getFrage());
            String antwortS1 = this.spieler1.getSocket().readLine();
            if (frage.istRichtig(Integer.parseInt(antwortS1))) {
                punkteS1++;
                this.spieler1.getSocket().write("richtig");
            } else {

                int a = frage.getLoesung();
                this.spieler1.getSocket().write("leider falsch, richtig ist : " + a);

            }

            // sende Frage an Spieler 2

            /*
             * this.spieler2.getSocket().write(frage.getFrage());
             * String antwortS2 = this.spieler2.getSocket().readLine();
             * if (antwortS2.equals(Integer.toString(frage.getLoesung()))) {
             * punkteS2++;
             * this.spieler2.getSocket().write("richtig");
             * } else {
             * 
             * int a = frage.getLoesung();
             * this.spieler2.getSocket().write("leider falsch, richtig ist : " + a);
             * 
             * }
             */

        

        if (punkteS1 > punkteS2) {

            
                this.spieler1.getSocket().write("Sieg");
                this.spieler2.getSocket().write("Niederlage");
            
            this.spieler1.erhoeheAnzahlSiege();
        } else if (punkteS1 < punkteS2) {

            
                this.spieler1.getSocket().write("Niederlage");
                this.spieler2.getSocket().write("Sieg");
                this.spieler2.erhoeheAnzahlSiege();
            

        } else {
            
                this.spieler1.getSocket().write("Unentschieden");
                this.spieler2.getSocket().write("Unentschieden");
           

        }

    } catch (IOException e){
        e.printStackTrace();
    }

    }

}
}
