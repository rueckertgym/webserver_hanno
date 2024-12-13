public class Main {

    public static void main(String[] args){
        ShopServer shopServer = new ShopServer(7);
        //ShopClient shopClient = new ShopClient("127.0.0.1", 7);
        ShopClient shopClient = new ShopClient("10.56.17.208", 7);
        shopClient.groesseFarbeWählen("M", "B");
        shopClient.bestaetigen("JA");
        //shopClient.abmelden();
    }
}
