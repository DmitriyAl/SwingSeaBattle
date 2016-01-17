package controller;

import model.abstractClassesAndInterfaces.IGameManager;
import view.StartMenuView;

/**
 * Created by Dmitriy on 17.01.2016.
 */
public interface IStartMenuViewController {
    StartMenuView getView();

    IGameManager getModel();

    void setView(StartMenuView view);

    void startGame(boolean isGameWithHuman, boolean isManualShipPlacing, int fieldSize);
}
