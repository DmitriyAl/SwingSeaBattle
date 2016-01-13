package model.otherClasses;

import model.abstractClassesAndInterfaces.ShipPlacing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy on 12.01.2016.
 */
public class AutomaticShipPlacing implements ShipPlacing {

    public static final Logger log = LoggerFactory.getLogger(AutomaticShipPlacing.class);

    public void placeShips(Field field) {
        for (Ship ship : field.getShips()) {
            List<Point> decks;
            do {
                decks = new ArrayList<>();
                int coordinateInDirection = (int) (Math.random() * (field.getFieldSize() - ship.getLength() + 1));
                int orthogonalCoordinate = (int) (Math.random() * field.getFieldSize());
                for (int i = 0; i < ship.getLength(); i++) {
                    Point point = new Point();
                    point.setType(PointType.UNHITTED_DECK);
                    if (ship.getIsVertical()) {
                        point.setX(orthogonalCoordinate);
                        point.setY(coordinateInDirection++);
                    } else {
                        point.setX(coordinateInDirection++);
                        point.setY(orthogonalCoordinate);
                    }
                    decks.add(point);
                }
            } while (!field.isShipPlaced(decks));
            log.info(ship.getName() + " placed with coordinates: " + decks);
            ship.setCoordinates(decks);
            field.updateFields(decks);
        }
        field.showFields(field.getFieldWithShips());
    }
}

