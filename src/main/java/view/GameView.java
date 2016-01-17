package view;

import controller.IGameController;
import model.abstractClassesAndInterfaces.IGameManager;

/**
 * Created by Dmitriy on 17.01.2016.
 */
public class GameView {
    private IGameManager model;
    private IGameController controller;

    public GameView(IGameManager model) {
        this.model = model;
    }

    public void setController(IGameController controller) {
        this.controller = controller;
    }
}
