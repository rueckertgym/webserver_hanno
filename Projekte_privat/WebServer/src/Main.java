import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        ShopServer shopServer = new ShopServer(11);
        System.out.println("Bitte deine IP eingeben.");
        Scanner sc = new Scanner(System.in);
        String clientIP = sc.next();
        ShopClient shopClient = new ShopClient("127.0.0.1");
        shopServer.processNewConnection(clientIP, 11);
        System.out.println(shopServer.isConnectedTo(clientIP, 11));
        while(true){
            if(shopServer.isConnectedTo(clientIP, 11)){
                System.out.println("Bitte Farbe auswählen");
                String farbe = sc.next();
                if(farbe.compareTo("ABMELDEN") == 0){
                    shopClient.abmelden();
                    break;
                }
                System.out.println("Bitte Größe auswählen");
                String größe = sc.next();
                if(farbe.compareTo("ABMELDEN") == 0){
                    shopClient.abmelden();
                    break;
                }
                shopClient.groesseFarbeWählen(größe, farbe);
                String bestätigung = sc.next();
                if(bestätigung.compareTo("ABMELDEN") == 0){
                    shopClient.abmelden();
                    break;
                } else {
                    shopClient.bestaetigen(bestätigung);
                }

            }
        }
    }
}