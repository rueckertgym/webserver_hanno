import utils.List;
import utils.Server;

public class ShopServer extends Server {

    public List<Bestellung> bestellungen;

    public void processNewConnection(String pClientIP, int pClientPort){
        this.send(pClientIP, pClientPort, "Willkommen! Wählen Sie eine Größe und eine Farbe für Ihr T- Shirt.");
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {

    }

    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {

    }

    public void processNewConnection(String pClientIP, int pPort, String pMessage){
        String nachrichtTeil[] = pMessage.split(":");
        if(nachrichtTeil[0].compareTo("TShirt") == 0){
            this.send(pClientIP,pPort, ("Die Größe ist " + nachrichtTeil[1] + " und die Farbe ist " + nachrichtTeil[2] + " und es kostet 19,99€. Bitte bestätigen Sie die Bestellung."));
        }
    }

}
