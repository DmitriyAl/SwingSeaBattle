package model.abstractClassesAndInterfaces;

import model.otherClasses.Field;

/**
 * Created by Dmitriy on 10.01.2016.
 */
public interface IPlayer {
    void placeShips();

    boolean makeShot(Field field);
}
