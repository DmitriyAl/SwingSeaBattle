package model.otherClasses;

import model.abstractClassesAndInterfaces.AbstractGame;
import model.abstractClassesAndInterfaces.IGame;
import model.abstractClassesAndInterfaces.IPlayer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dmitriy on 10.01.2016.
 */
public class GameWithComputer extends AbstractGame {

    public GameWithComputer() {
        super();
    }

    public GameWithComputer(IPlayer firstPlayer, IPlayer secondPlayer, Field firstField, Field secondField) {
        super(firstPlayer, secondPlayer, firstField, secondField);
    }

    public void start() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});
        IGame gameWithComputer = context.getBean("gameWithComputer", IGame.class);
        IPlayer firstPlayer = context.getBean("firstPlayer", IPlayer.class);
        IPlayer secondPlayer = context.getBean("secondComputerPlayer", IPlayer.class);

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
