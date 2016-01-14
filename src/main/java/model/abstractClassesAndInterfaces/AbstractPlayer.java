package model.abstractClassesAndInterfaces;

import model.otherClasses.Field;

/**
 * Created by Dmitriy on 10.01.2016.
 */
public abstract class AbstractPlayer implements IPlayer {
    protected ShipPlacing shipPlacing;
    protected GuessMaking guessMaking;
    protected Field field;
    protected volatile boolean isMyShot;

    public AbstractPlayer() {
    }

    public AbstractPlayer(ShipPlacing shipPlacing, GuessMaking guessMaking, Field field) {
        this.shipPlacing = shipPlacing;
        this.guessMaking = guessMaking;
        this.field = field;
    }

    public ShipPlacing getShipPlacing() {
        return shipPlacing;
    }

    public void setShipPlacing(ShipPlacing shipPlacing) {
        this.shipPlacing = shipPlacing;
    }

    public GuessMaking getGuessMaking() {
        return guessMaking;
    }

    public void setGuessMaking(GuessMaking guessMaking) {
        this.guessMaking = guessMaking;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public boolean isMyshot() {
        return isMyShot;
    }

    public void setIsMyshot(boolean isMyshot) {
        this.isMyShot = isMyshot;
    }

    @Override
    public String toString() {
        return "AbstractPlayer{" +
                "shipPlacing=" + shipPlacing +
                ", guessMaking=" + guessMaking +
                ", field=" + field +
                '}';
    }
}
