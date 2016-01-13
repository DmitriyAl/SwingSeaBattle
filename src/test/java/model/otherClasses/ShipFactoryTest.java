package model.otherClasses;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Dmitriy on 13.01.2016.
 */
public class ShipFactoryTest {
    ShipFactory factory;

    @Before
    public void before() {
        factory = new ShipFactory();
    }

    @Test
    public void createFleetFor10x10Field() {
        List<Ship> fleet = factory.createFleet(10);
        Assert.assertEquals(10, fleet.size());
    }

    @Test
    public void firstShipAttributeFor10x10Field() {
        List<Ship> fleet = factory.createFleet(10);
        Ship firstShip = fleet.get(0);
        Assert.assertEquals("4-deck ship", firstShip.getName());
        Assert.assertEquals(4, firstShip.getLength());
        Assert.assertEquals("java.util.ArrayList", firstShip.getCoordinates().getClass().getCanonicalName());
        Assert.assertNotNull(firstShip.getCoordinatesForProgram());
        Assert.assertEquals(4, firstShip.getCoordinatesForProgram().length);
    }
}
