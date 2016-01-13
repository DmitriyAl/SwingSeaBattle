package model.otherClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Dmitriy on 13.01.2016.
 */
public class ShipFactory {
    private Ship ship;

    public List<Ship> createFleet(int amount) {
        List<Ship> ships = new ArrayList<Ship>();

        String name;
        int length;
        List<Point> coordinates;
        Point[] coordinatesForProgram;
        boolean isVertical;

        int longestShip = determineAmount(amount);
        Integer currentLength = longestShip;
        int placedShipsOfThisType;
        do {
            placedShipsOfThisType = 0;
            int availableAmountOtThisTypeShip;
            do {
                availableAmountOtThisTypeShip = longestShip - currentLength - placedShipsOfThisType++ + 1;

                name = currentLength.toString()+"-deck ship";
                length = currentLength;
                coordinates = new ArrayList<Point>();
                coordinatesForProgram = new Point[currentLength];
                isVertical = new Random().nextBoolean();
                ship = new Ship(name, length, coordinates, coordinatesForProgram, isVertical);

//                ship.setLength(currentLength);
//                ship.setCoordinatesForProgram(new Point[currentLength]);
//                ship.setIsVertical(isVertical());
//                switch (currentLength) {
//                    case 4:
//                        ship.setName("four deck");
//                        break;
//                    case 3:
//                        ship.setName("three deck");
//                        break;
//                    case 2:
//                        ship.setName("two deck");
//                        break;
//                    case 1:
//                        ship.setName("one deck");
//                        break;
//                    default:
//                        ship.setName("this");
//                        break;
//                }
////                System.out.println(ship.getName() + " "+ ship.getLength());
                ships.add(ship);
                availableAmountOtThisTypeShip--;
            } while (availableAmountOtThisTypeShip != 0);
            currentLength--;
        } while (currentLength != 0);
        return ships;
    }

    public int determineAmount(int amount) {
        int decks = 0;
        int longest;
        int field = amount * amount;
        for (longest = 1; longest < Integer.MAX_VALUE; longest++) {
            for (int j = 1; j <= longest; j++) {
                decks += j;
                if (field / decks <= 5) {
                    return longest;
                }
            }
        }
//        return longest;
        return 0;
    }

    private boolean isVertical() {
        Random r = new Random();
        return r.nextBoolean();
    }
}

