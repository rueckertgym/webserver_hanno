import utils.Client;

import javax.swing.*;

public class ShopClient extends Client {

    public ShopClient(String pServerIP){
        super(pServerIP, 7);
    }

    @Override
    public void processMessage(String pMessage) {
        JOptionPane.showMessageDialog(null,"Server sendet:\n" + pMessage);
    }

    public void groesseFarbeWählen(String pGroesse, String pFarbe){
        this.send("TShirt:" + pGroesse + ":" + pFarbe);
    }

    public void bestaetigen(String pAntwort){
        this.send("BESTAETIGUNG:" + pAntwort);
    }

    public void abmelden(){
        this.send("ABMELDEN:");
    }
}
