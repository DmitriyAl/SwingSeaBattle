package model.otherClasses;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 15.01.2016.
 */
public class FieldTest {
    @Test
    public void checkShotTest() {
        ShipFactory factory = new ShipFactory();
        Field field = new Field(10, factory);
        field.init();
        new AutomaticShipPlacing().placeShips(field);
        Assert.assertEquals(10, field.getShips().size());
        for (int i = 0; i < field.getFieldSize(); i++) {
            for (int j = 0; j < field.getFieldSize(); j++) {
                field.checkShot(new Point(i, j));
            }
        }
        Assert.assertEquals(0, field.getShips().size());
    }

    @Test
    public void checkManualShotToManualField() {
        List<Point> decks = new ArrayList<>();
        Point[] decsForProgram = new Point[4];
        ShipFactory factory = new ShipFactory();
        for (int i = 0; i < 4; i++) {
            Point deck = new Point(0, i, PointType.UNHITTED_DECK);
            decks.add(deck);
            decsForProgram[i] = deck;
        }
        Ship ship = new Ship("4-decks ship", 4, decks, decsForProgram, true);
        List<Ship> ships = new ArrayList<>();
        ships.add(ship);
        Field field = new Field(10, factory);
        field.init();
        field.setShips(ships);
        field.placeShips(decks);
        field.showFields(field.getFieldWithShips());
        Assert.assertEquals(1, field.getShips().size());
        for (int i = 0; i < 4; i++) {
            field.checkShot(new Point(0, i));
        }
        field.showFields(field.getFieldWithShips());
    }
}
