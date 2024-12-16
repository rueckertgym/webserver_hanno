import utils.List;
import utils.Server;

import java.util.Scanner;

public class ShopServer extends Server {

    public List<Einhornfurzkissen> bestellungen = new List<>();

    public ShopServer(int pPortnummer) {
        super(pPortnummer);
    }

    public void processNewConnection(String pClientIP, int pClientPort){
        this.send(pClientIP, pClientPort, "Willkommen! Wählen Sie eine Größe und eine Farbe für Ihr T- Shirt.");
    }
    public void processMessage(String pClientIP, int pClientPort, String pMessage){
            Scanner sc = new Scanner(System.in);
            String nachrichtTeil[] = pMessage.split(":");
            if(nachrichtTeil[0].compareTo("TShirt") == 0){
                this.send(pClientIP,pClientPort, ("Die Größe ist " + nachrichtTeil[1] + " und die Farbe ist " + nachrichtTeil[2] + " und es kostet 19,99€. Bitte bestätigen Sie die Bestellung."));
                //bestellungen.append(new Einhornfurzkissen(nachrichtTeil[1], nachrichtTeil[2]));
            } else if(nachrichtTeil[0].equals("BESTAETIGUNG")){
                if(nachrichtTeil[1].equals("JA")){
                    this.send(pClientIP, pClientPort, "Vielen Dank für Ihre Bestellung.");
                    this.closeConnection(pClientIP, pClientPort);
                } else if(nachrichtTeil[1].equals("NEIN")){
                    this.closeConnection(pClientIP, pClientPort);
                } else {
                    this.send(pClientIP, pClientPort, "Bitte geben Sie JA oder NEIN ein.");
                }
            } else if(nachrichtTeil[0].equals("ABMELDEN")){
                closeConnection(pClientIP, pClientPort);
            } else {
                this.send(pClientIP, pClientPort, "Bitte korrigieren Sie Ihre Eingabe.");
            }
    }

    public List<Einhornfurzkissen> getListeBestellung(){
        return bestellungen;
    }

    public void processClosingConnection(String pClientIP, int pClientPort) {
    }

}
