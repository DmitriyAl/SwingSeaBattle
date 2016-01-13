package model.otherClasses;

import model.abstractClassesAndInterfaces.IGame;

/**
 * Created by Dmitriy on 1/11/2016.
 */
public class GameManager {
    private IGame game;

    public GameManager(IGame game) {
        this.game = game;
    }

    public void startGame() {
        int fieldSize = 10;
        game.start(10);
    }
}
