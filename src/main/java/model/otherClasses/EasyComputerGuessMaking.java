package model.otherClasses;

import model.abstractClassesAndInterfaces.GuessMaking;

import java.util.Random;

/**
 * Created by Dmitriy on 12.01.2016.
 */
public class EasyComputerGuessMaking implements GuessMaking {
    public boolean makeShot(Field field) {
        Random random = new Random();
        Point shot;
        do {
            shot = new Point(random.nextInt(field.getFieldSize()), random.nextInt(field.getFieldSize()));
        } while (!field.isAvailableForShot(shot));
//        boolean isHit = this.game.getPlayerField().checkShot(shot);
//        game.notifyLocalPlayerFieldObservers();
//        game.getPlayer().setShotAbility(!isHit);
        return field.checkShot(shot);
    }
}

