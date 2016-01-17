package model.otherClasses;

import model.abstractClassesAndInterfaces.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 10.01.2016.
 */
public class Game extends AbstractGame {

    public Game() {
        super();
    }

    public Game(AbstractPlayer firstPlayer, AbstractPlayer secondPlayer, Field firstField, Field secondField, List<FirstPlayerFieldObserver> firstPlayerFieldObservers, List<SecondPlayerFieldObserver> secondPlayerFieldObservers) {
        super(firstPlayer, secondPlayer, firstField, secondField, firstPlayerFieldObservers, secondPlayerFieldObservers);
    }


    public void start(int fieldSize) {
        gameSetUp(fieldSize);
        gameProcess();
        restartOrExit();
    }

    private void gameSetUp(int fieldSize) {
        firstField.setFieldSize(fieldSize);
        secondField.setFieldSize(fieldSize);
        firstField.init();
        secondField.init();
        boolean isFirstPlayerMakeFirstShot = new Random().nextBoolean();
        firstPlayer.setIsMyshot(isFirstPlayerMakeFirstShot);
        secondPlayer.setIsMyshot(!isFirstPlayerMakeFirstShot);
        firstPlayer.placeShips();
        secondPlayer.placeShips();
        notifyFirstPlayerFieldListeners();
        notifySecondPlayerFieldListeners();
    }

    private void restartOrExit() {
        firstField.showFields(firstField.getGameField());
        System.out.println("\n\n\n");
        secondField.showFields(firstField.getGameField());
        log.info("exit");
        System.exit(0);
    }

//    private void gameProcess() {
//        Thread shooting = new Thread(this);
//        shooting.start();
//        try {
//            shooting.join();
//        } catch (InterruptedException e) {
//            log.error("main thread was interrupted");
//        }
//    }

    private void gameProcess() {
        startShooting();
    }

    @Override
    protected void startShooting() {
        while (!isTheEnd) {
            boolean isSuccessfulShot;
            if (firstPlayer.isMyshot()) {
                do {
                    System.out.println("first player make shot");
                    isSuccessfulShot = firstPlayer.makeShot(secondField);
                    System.out.println("second player's field");
                    secondField.showFields(secondField.getGameField());
                    System.out.println("\n");
                    secondField.showFields(secondField.getFieldWithShips());
                    notifySecondPlayerFieldListeners();
                } while (isSuccessfulShot);
                firstPlayer.setIsMyshot(false);
                secondPlayer.setIsMyshot(true);
            }
            isTheEnd = isTheEnd();
            if (secondPlayer.isMyshot()) {
                do {
                    System.out.println("second player make shot");
                    isSuccessfulShot = secondPlayer.makeShot(firstField);
                    System.out.println("first player's field");
                    firstField.showFields(secondField.getGameField());
                    System.out.println("\n");
                    firstField.showFields(secondField.getFieldWithShips());
                    notifyFirstPlayerFieldListeners();
                } while (isSuccessfulShot);
                firstPlayer.setIsMyshot(true);
                secondPlayer.setIsMyshot(false);
            }
            isTheEnd = isTheEnd();
        }
    }

    private boolean isTheEnd() {
        return (firstField.isAllShipDestroyed() || secondField.isAllShipDestroyed());
    }

    public void save() {

    }

    public void load() {

    }

    public void restart() {

    }

    public void addListener() {

    }

    public void showStatistic() {

    }
}
