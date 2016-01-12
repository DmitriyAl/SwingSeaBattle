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

    public void start() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});
        IGame gameWithComputer = context.getBean("gameWithComputer", IGame.class);
    }

    public void save() {

    }

    public void load() {

    }

    public void restart() {

    }

    public void notifyListeners() {

    }

    public void addListener() {

    }

    public void showStatistic() {

    }
}
