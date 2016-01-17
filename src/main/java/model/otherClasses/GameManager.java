package model.otherClasses;

import model.abstractClassesAndInterfaces.AbstractGame;
import model.abstractClassesAndInterfaces.IGame;
import model.abstractClassesAndInterfaces.IGameManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dmitriy on 1/11/2016.
 */
public class GameManager implements IGameManager {
    private AbstractGame game;

    public GameManager() {
    }

    public GameManager(AbstractGame game) {
        this.game = game;
    }

    public void startGame(boolean isGameWithHuman, boolean isManualShipPlacing, int fieldSize) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});
        if (isGameWithHuman) {
            System.exit(0);
        } else {
            if (isManualShipPlacing) {
                System.exit(0);
            } else {
                game = context.getBean("gameWithComputerAutomaticShipPlacing", AbstractGame.class);
            }
        }
        game.start(fieldSize);
    }
}
