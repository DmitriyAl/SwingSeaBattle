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
public class GameWithComputer extends AbstractGame {

    public GameWithComputer() {
        super();
    }

    public GameWithComputer(AbstractPlayer firstPlayer, AbstractPlayer secondPlayer, Field firstField, Field secondField, List<FirstPlayerFieldObserver> firstPlayerFieldObservers, List<SecondPlayerFieldObserver> secondPlayerFieldObservers) {
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
        firstPlayer.setShipPlacing(new AutomaticShipPlacing());
        firstPlayer.placeShips();
        secondPlayer.placeShips();
        notifyFirstPlayerFieldListeners();
        notifySecondPlayerFieldListeners();
    }

    private void restartOrExit() {
        log.info("exit");
        System.exit(0);
    }

    private void gameProcess() {
        Thread shooting = new Thread(this);
        shooting.start();
        try {
            shooting.join();
        } catch (InterruptedException e) {
            log.error("main thread was interrupted");
        }
    }

    @Override
    protected void startShooting() {
        while (!isTheEnd) {
            boolean isSuccessfulShot;
            if (firstPlayer.isMyshot()) {
                do {
                    isSuccessfulShot = firstPlayer.makeShot(secondField);
                    notifySecondPlayerFieldListeners();
                    log.info("First player shooting");
                    pause(500);
                } while (isSuccessfulShot);
                firstPlayer.setIsMyshot(false);
                secondPlayer.setIsMyshot(true);
                secondField.showFields(secondField.getGameField());
            }
            if (isTheEnd) {
                break;
            }
            if (secondPlayer.isMyshot()) {
                do {
                    isSuccessfulShot = secondPlayer.makeShot(firstField);
                    notifyFirstPlayerFieldListeners();
                    log.info("Second player shooting");
                    pause(500);
                } while (isSuccessfulShot);
                firstPlayer.setIsMyshot(true);
                secondPlayer.setIsMyshot(false);
                firstField.showFields(firstField.getGameField());
            }
        }
    }

    private void pause(int ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
