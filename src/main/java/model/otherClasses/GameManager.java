package model.otherClasses;

import model.abstractClassesAndInterfaces.AbstractGame;
import model.abstractClassesAndInterfaces.IGame;

/**
 * Created by Dmitriy on 1/11/2016.
 */
public class GameManager {
    private AbstractGame game;

    public GameManager(AbstractGame game) {
        this.game = game;
    }

    public void startGame() {
        int fieldSize = 10;
        game.start(10);
    }
}
