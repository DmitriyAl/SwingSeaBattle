package model.abstractClassesAndInterfaces;

import model.otherClasses.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy on 10.01.2016.
 */
public abstract class AbstractGame implements IGame, Runnable {
    protected AbstractPlayer firstPlayer;
    protected AbstractPlayer secondPlayer;
    protected Field firstField;
    protected Field secondField;
    protected List<FirstPlayerFieldObserver> firstPlayerFieldObservers;
    protected List<SecondPlayerFieldObserver> secondPlayerFieldObservers;
    protected List<StatisticObserver> statisticObservers;
    protected boolean isTheEnd;
    public static final Logger log = LoggerFactory.getLogger(AbstractGame.class);

    public AbstractGame() {
    }

    public AbstractGame(AbstractPlayer firstPlayer, AbstractPlayer secondPlayer, Field firstField, Field secondField, List<FirstPlayerFieldObserver> firstPlayerFieldObservers, List<SecondPlayerFieldObserver> secondPlayerFieldObservers) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.firstField = firstField;
        this.secondField = secondField;
        this.firstPlayerFieldObservers = firstPlayerFieldObservers;
        this.secondPlayerFieldObservers = secondPlayerFieldObservers;
    }

    @Override
    public void run() {
        startShooting();
    }

    protected abstract void startShooting();

    public IPlayer getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(AbstractPlayer firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public IPlayer getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(AbstractPlayer secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public Field getFirstField() {
        return firstField;
    }

    public void setFirstField(Field firstField) {
        this.firstField = firstField;
    }

    public Field getSecondField() {
        return secondField;
    }

    public void setSecondField(Field secondField) {
        this.secondField = secondField;
    }

    public List<FirstPlayerFieldObserver> getFirstPlayerFieldObservers() {
        return firstPlayerFieldObservers;
    }

    public void setFirstPlayerFieldObservers(List<FirstPlayerFieldObserver> firstPlayerFieldObservers) {
        this.firstPlayerFieldObservers = firstPlayerFieldObservers;
    }

    public List<SecondPlayerFieldObserver> getSecondPlayerFieldObservers() {
        return secondPlayerFieldObservers;
    }

    public void setSecondPlayerFieldObservers(List<SecondPlayerFieldObserver> secondPlayerFieldObservers) {
        this.secondPlayerFieldObservers = secondPlayerFieldObservers;
    }

    public void notifyFirstPlayerFieldListeners(){
        for (FirstPlayerFieldObserver firstPlayerFieldObserver : firstPlayerFieldObservers) {
            firstPlayerFieldObserver.updateFirstPlayerField();
        }
    }

    public void notifySecondPlayerFieldListeners(){
        for (SecondPlayerFieldObserver secondPlayerFieldObserver : secondPlayerFieldObservers) {
            secondPlayerFieldObserver.updateSecondPlayerField();
        }
    }

    public void notifyStatisticListeners(){
        for (StatisticObserver statisticObserver : statisticObservers) {
            statisticObserver.updateStatistic();
        }
    }

    @Override
    public String toString() {
        return "AbstractGame{" +
                "firstPlayer=" + firstPlayer +
                ", secondPlayer=" + secondPlayer +
                ", firstField=" + firstField +
                ", secondField=" + secondField +
                ", firstPlayerFieldObservers=" + firstPlayerFieldObservers +
                ", secondPlayerFieldObservers=" + secondPlayerFieldObservers +
                ", isTheEnd=" + isTheEnd +
                '}';
    }
}
