package model.abstractClassesAndInterfaces;

/**
 * Created by Dmitriy on 10.01.2016.
 */
public interface IGame {
    void start();

    void save();

    void load();

    void restart();

    void notifyListeners();

    void addListener();

    void showStatistic();
}
