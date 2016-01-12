package model.otherClasses;

import model.abstractClassesAndInterfaces.AbstractPlayer;
import model.abstractClassesAndInterfaces.GuessMaking;
import model.abstractClassesAndInterfaces.ShipPlacing;

/**
 * Created by Dmitriy on 11.01.2016.
 */
public class ComputerPlayer extends AbstractPlayer {
    public ComputerPlayer(ShipPlacing shipPlacing, GuessMaking guessMaking, Field field) {
        super(shipPlacing, guessMaking, field);
    }

    public void placeShips() {

    }

    public boolean makeShot() {
        return false;
    }
}
