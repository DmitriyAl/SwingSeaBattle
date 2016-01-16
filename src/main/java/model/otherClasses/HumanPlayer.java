package model.otherClasses;

import model.abstractClassesAndInterfaces.AbstractPlayer;
import model.abstractClassesAndInterfaces.GuessMaking;
import model.abstractClassesAndInterfaces.ShipPlacing;

/**
 * Created by Dmitriy on 10.01.2016.
 */
public class HumanPlayer extends AbstractPlayer {
    public HumanPlayer() {
    }

    public HumanPlayer(ShipPlacing shipPlacing, GuessMaking guessMaking, Field field) {
        super(shipPlacing, guessMaking, field);
    }

    public void placeShips() {
        shipPlacing.placeShips(field);
    }

    public boolean makeShot(Field field) {
        return new EasyComputerGuessMaking().makeShot(field);
    }
}
