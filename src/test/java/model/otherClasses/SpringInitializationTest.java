package model.otherClasses;

import model.abstractClassesAndInterfaces.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Dmitriy on 12.01.2016.
 */
public class SpringInitializationTest {
    ApplicationContext context = null;

    @Before
    public void Before() {
        context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});
    }

    @Test
    public void PlayerReferenceInGameAndPersonBeanEquivalence() {
        IGame gameWithComputer = context.getBean("gameWithComputer", IGame.class);
        IPlayer firstPlayer = context.getBean("firstPlayer", IPlayer.class);
        IPlayer secondComputerPlayer = context.getBean("secondComputerPlayer", IPlayer.class);
        Assert.assertEquals(true, ((AbstractGame) gameWithComputer).getFirstPlayer() == firstPlayer);
        Assert.assertEquals(true, ((AbstractGame) gameWithComputer).getSecondPlayer() == secondComputerPlayer);
    }

    @Test
    public void PlayerFieldReferenceInGameAndFieldReferenceEquivalence() {
        IGame gameWithComputer = context.getBean("gameWithComputer", IGame.class);
        Field firstPlayerField = context.getBean("firstPlayerField", Field.class);
        Field secondPlayerField = context.getBean("secondPlayerField", Field.class);
        Assert.assertEquals(true, ((AbstractGame) gameWithComputer).getFirstField() == firstPlayerField);
        Assert.assertEquals(true, ((AbstractGame) gameWithComputer).getSecondField() == secondPlayerField);
    }

    @Test
    public void PlayerFieldReferenceAndFieldBeanEquivalence() {
        IPlayer firstPlayer = context.getBean("firstPlayer", IPlayer.class);
        IPlayer secondComputerPlayer = context.getBean("secondComputerPlayer", IPlayer.class);
        Field firstPlayerField = context.getBean("firstPlayerField", Field.class);
        Field secondComputerPlayerField = context.getBean("secondPlayerField", Field.class);
        Assert.assertEquals(true, ((AbstractPlayer) firstPlayer).getField() == firstPlayerField);
        Assert.assertEquals(true, ((AbstractPlayer) secondComputerPlayer).getField() == secondComputerPlayerField);
    }

    @Test
    public void FieldObserversNotEquivalence() {
        IGame gameWithComputer = context.getBean("gameWithComputer", IGame.class);
        List<FirstPlayerFieldObserver> firstPlayerFieldObservers = ((AbstractGame) gameWithComputer).getFirstPlayerFieldObservers();
        List<SecondPlayerFieldObserver> secondPlayerFieldObservers = ((AbstractGame) gameWithComputer).getSecondPlayerFieldObservers();
//        Assert.assertEquals(false, firstPlayerFieldObservers.equals(secondPlayerFieldObservers)); //todo find info about object comparison
    }
}
