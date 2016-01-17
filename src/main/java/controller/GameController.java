package controller;

import model.abstractClassesAndInterfaces.IGameManager;
import view.GameView;

/**
 * Created by Dmitriy on 17.01.2016.
 */
public class GameController implements IGameController {
    private IGameManager model;
    private GameView view;

    public GameController(IGameManager model, GameView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void initGameView() {
        view.setController(this);

    }
}
