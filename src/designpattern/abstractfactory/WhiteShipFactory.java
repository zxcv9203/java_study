package designpattern.abstractfactory;

import designpattern.factorymethod.DefaultShipFactory;
import designpattern.factorymethod.Ship;
import designpattern.factorymethod.ShipFactory;
import designpattern.factorymethod.WhiteShip;

// client
public class WhiteShipFactory extends DefaultShipFactory {

    private ShipPartsFactory shipPartsFactory;

    public WhiteShipFactory(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }
    @Override
    public Ship createShip() {
        Ship ship = new WhiteShip();
        ship.setAnchor(shipPartsFactory.createAnchor());
        ship.setWheel(shipPartsFactory.createWheel());
        return ship;
    }
}
