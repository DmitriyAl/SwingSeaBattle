package model.otherClasses;

import model.abstractClassesAndInterfaces.IGameManager;

/**
 * Created by Dmitriy on 17.01.2016.
 */
public class GameSimulation {
    public static void main(String[] args) {
        IGameManager manager = new GameManager();
        manager.startGame(false, false, 4);
    }
}
