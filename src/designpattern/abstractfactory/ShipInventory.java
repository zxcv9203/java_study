package designpattern.abstractfactory;

import designpattern.factorymethod.Ship;
import designpattern.factorymethod.ShipFactory;

public class ShipInventory {
    public static void main(String[] args) {
        ShipFactory shipFactory = new WhiteShipFactory(new WhiteShipPartsProFactory());
        Ship ship = shipFactory.createShip();
        System.out.println(ship.getAnchor().getClass());
        System.out.println(ship.getAnchor());
    }
}
