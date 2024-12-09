public class Main {

    public static void main(String[] args){
        ShopServer shopServer = new ShopServer(17);
        ShopClient shopClient = new ShopClient("127.0.0.1", 7);
    }
}
