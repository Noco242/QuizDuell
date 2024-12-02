package QuizDuell;

public class Spieler {
   private String name;
   private String passwort;
   private Socket socket;
   private int anzahlSiege;

   public Spieler(String name, String passwort) {

      this.name = name;
      this.passwort = passwort;
      this.anzahlSiege = 0;

   }

   public Spieler() {

   }

   public void erhoeheAnzahlSiege() {
      this.anzahlSiege = this.anzahlSiege + 1;
   }

   public boolean pruefePasswort(String passwort) {

      return this.passwort.equals(passwort);
   }

   public void setSocket(Socket socket) {
      this.socket = socket;
   }

   public String getName() {
      return this.name;
   }

   public String getPasswort() {
      return this.passwort;
   }

   public Socket getSocket(){
      return this.socket;
   }
}
