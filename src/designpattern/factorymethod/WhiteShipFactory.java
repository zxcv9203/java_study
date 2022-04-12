package designpattern.factorymethod;

public class WhiteShipFactory extends DefaultShipFactory{
    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
