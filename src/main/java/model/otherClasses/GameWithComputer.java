package model.otherClasses;

import model.abstractClassesAndInterfaces.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Dmitriy on 10.01.2016.
 */
public class GameWithComputer extends AbstractGame {

    public GameWithComputer() {
        super();
    }

    public GameWithComputer(IPlayer firstPlayer, IPlayer secondPlayer, Field firstField, Field secondField, List<FirstPlayerFieldObserver> firstPlayerFieldObservers, List<SecondPlayerFieldObserver> secondPlayerFieldObservers) {
        super(firstPlayer, secondPlayer, firstField, secondField, firstPlayerFieldObservers, secondPlayerFieldObservers);
    }

    public void start(int fieldSize) {
        firstField.setFieldSize(fieldSize);
        secondField.setFieldSize(fieldSize);
        firstField.init();
        secondField.init();
        ((AbstractPlayer) firstPlayer).setShipPlacing(new AutomaticShipPlacing());
        firstPlayer.placeShips();
        secondPlayer.placeShips();
        notifyFirstPlayerFieldListeners();
        notifySecondPlayerFieldListeners();
        while (!isTheEnd) {
            boolean isSuccessfulShot;
            do {
                isSuccessfulShot = firstPlayer.makeShot();
                notifySecondPlayerFieldListeners();
                isTheEnd = firstField.isUndestroyedFieldExist();
                if (isTheEnd) {
                    break;
                }
            } while (isSuccessfulShot);
            if (isTheEnd) {
                break;
            }
            do {
                isSuccessfulShot = secondPlayer.makeShot();
                notifyFirstPlayerFieldListeners();
                isTheEnd = secondField.isUndestroyedFieldExist();
                if (isTheEnd) {
                    break;
                }
            } while (isSuccessfulShot);
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
