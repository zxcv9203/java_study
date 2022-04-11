package designpattern.factorymethod;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();

        client.print(new WhiteShipFactory(), "whiteship", "yonhcheol@mail.com");
        client.print(new BlackShipFactory(), "blackship", "yongcheo@mail.com");

    }

    private void print(ShipFactory shipFactory, String name, String email) {
        System.out.println(shipFactory.orderShip(name, email));
    }
}
