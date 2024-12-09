import utils.Client;

public class ShopClient extends Client {

    public ShopClient(String pServerIP, int pPort){
        super(pServerIP, pPort);
    }

    @Override
    public void processMessage(String pMessage) {

    }

    public void groesseFarbeWählen(String pGroesse, String pFarbe){
        this.send("TShirt:" + pGroesse + ":" + pFarbe);
    }

    public void bestaetigen(String pAntwort){
        this.send("Bitte bestätigen:" + pAntwort);
    }
}
