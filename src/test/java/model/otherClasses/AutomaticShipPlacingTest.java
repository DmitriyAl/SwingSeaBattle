package model.otherClasses;

import model.abstractClassesAndInterfaces.AbstractPlayer;
import model.abstractClassesAndInterfaces.IPlayer;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Dmitriy on 14.01.2016.
 */
public class AutomaticShipPlacingTest {
    @Test
    public void shipPlacingFor10x10Field() {
        Field field = new Field(new ShipFactory());
        field.setFieldSize(10);
        field.init();
        AbstractPlayer player = new HumanPlayer(new AutomaticShipPlacing(), new ManualGuessMaking(), field);
        player.placeShips();
        Assert.assertEquals(10, field.getShips().size());
    }
}
