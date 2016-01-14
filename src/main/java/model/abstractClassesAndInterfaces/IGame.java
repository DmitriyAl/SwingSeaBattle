package model.abstractClassesAndInterfaces;

/**
 * Created by Dmitriy on 10.01.2016.
 */
public interface IGame {

    void start(int fieldSize);

    void save();

    void load();

    void restart();

    void notifyFirstPlayerFieldListeners();

    void notifySecondPlayerFieldListeners();

    void notifyStatisticListeners();

    void addListener();

    void showStatistic();
}
