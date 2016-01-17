package controller;

import model.abstractClassesAndInterfaces.IGameManager;
import view.StartMenuView;

/**
 * Created by Dmitriy on 17.01.2016.
 */
public class StartMenuViewController implements IStartMenuViewController {
    private IGameManager model;
    private StartMenuView view;
    private IGameController gameController;

    public StartMenuViewController(IGameManager model) {
        this.model = model;
    }

    public IGameManager getModel() {
        return model;
    }

    public StartMenuView getView() {
        return view;
    }

    public void setView(StartMenuView view) {
        this.view = view;
    }

    @Override
    public void startGame(boolean isGameWithHuman, boolean isManualShipPlacing, int fieldSize) {
        model.startGame(isGameWithHuman, isManualShipPlacing, fieldSize);
        gameController.initGameView();
    }
}
