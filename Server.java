package QuizDuell;

import java.util.ArrayList;

public class Server {
    private ServerSocket serverSocket;
    private ArrayList<Frage> fragenPool;
    private ArrayList<Spieler> registrierteSpieler;
    private int port;

    public Server(int port) {
        this.port = port;

        this.fragenPool = new ArrayList<>();
        this.registrierteSpieler = new ArrayList<>();

        try {
            this.serverSocket = new ServerSocket(port);
        } catch (Exception e) {
            System.out.println("ERROR");
        }

    }

    public void runServer() {

    }

    public Spieler registrieren(String name, String passwort) {

        
        Spieler snew = new Spieler(name, passwort);
        this.registrierteSpieler.add(snew);



        return snew;
    }

    public Spieler anmelden(String name, String passwort) {
        Spieler s = suche(name);
        if (s != null) {
            if (s.pruefePasswort(passwort) == false) {
                s = null;
            }
        }

        return s;
    }

    private Spieler suche(String name) {
        Spieler s = null;
        for (Spieler spieler : registrierteSpieler) {
            if (spieler.getName().equals(name)) {
                s = spieler;
            } else {

            }
        }

        return s;
    }

    private ArrayList<Frage> generiereFragen() {

        return null;
    }

    private Spiel erzeugeSpiel(Spieler s1, Spieler s2) {

        return null;
    }

    public int pruefePasswortsicherheit(String passwort) {

        return 0;
    }
}
