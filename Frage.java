package QuizDuell;

public class Frage {
    private String frage;
    private String[] antworten;
    private int loesung;

    public Frage(String frage, String[] antworten, int loesung) {
        this.frage = frage;
        this.antworten = antworten;
        this.loesung = loesung;
    }

    public boolean istRichtig(int antwort){

        return false; 
    }

    public String getFrageMitAntworten(){

        return "";
    }
}
