package model.otherClasses;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Dmitriy on 10.01.2016.
 */
public class Field {
    private int fieldSize;
    private List<Ship> ships;
    private ShipFactory factory;
    private Point[][] gameField;
    private Point[][] fieldWithShips;
    private Point[][] designerField;
    private Point[][] fieldForDestroyedShips;

    public Field() {
    }

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public Field(ShipFactory factory) {
        this.factory = factory;
    }

    public Field(int fieldSize, ShipFactory factory) {
        this.fieldSize = fieldSize;
        this.factory = factory;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFactory(ShipFactory factory) {
        this.factory = factory;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public Point[][] getGameField() {
        return gameField;
    }

    public Point[][] getFieldWithShips() {
        return fieldWithShips;
    }

    public Point[][] getDesignerField() {
        return designerField;
    }

    public Point[][] getFieldForDestroyedShips() {
        return fieldForDestroyedShips;
    }

    public void init() {
        initFields();
        getFleet();
    }

    private void initFields() {
        gameField = new Point[fieldSize][fieldSize];
        fieldWithShips = new Point[fieldSize][fieldSize];
        designerField = new Point[fieldSize][fieldSize];
        fieldForDestroyedShips = new Point[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                gameField[i][j] = new Point(i, j, PointType.FIELD);
                fieldWithShips[i][j] = new Point(i, j, PointType.FIELD);
                designerField[i][j] = new Point(i, j, PointType.FIELD);
                fieldForDestroyedShips[i][j] = new Point(i, j, PointType.FIELD);
            }
        }
    }

    private void getFleet() {
        ships = factory.createFleet(fieldSize);
    }

    public boolean isShipPlaced(List<Point> decks) {
        boolean isPlaced = true;
        for (Point deck : decks) {
            if (designerField[deck.getY()][deck.getX()].getType() != PointType.FIELD) {
                isPlaced = false;
            }
        }
        return isPlaced;
    }


    public boolean isUndestroyedFieldExist() {
        return false;
    }

    public void placeShips(List<Point> decks) {
        sendAsDesignerField(decks);
        sendAsGameField(decks);
    }

    private void sendAsGameField(List<Point> decks) {
        Point origin = decks.get(0);
        Point end = decks.get(decks.size() - 1);
        int originX = origin.getX();
        int originY = origin.getY();
        int endX = end.getX();
        int endY = end.getY();
        for (int i = originX; i <= endX; i++) {
            for (int j = originY; j <= endY; j++) {
                fieldWithShips[j][i].setType(PointType.UNHITTED_DECK);
            }
        }
    }

    public void sendAsGameField(Point[][] field, Point point, PointType state) {
        field[point.getY()][point.getX()].setType(state);
    }

    private void sendAsDesignerField(List<Point> decks) {
        Point origin = decks.get(0);
        Point end = decks.get(decks.size() - 1);
        int originX = origin.getX() - 1;
        if (originX < 0) {
            originX = 0;
        }
        int originY = origin.getY() - 1;
        if (originY < 0) {
            originY = 0;
        }
        int endX = end.getX() + 1;
        if (endX > fieldSize - 1) {
            endX = fieldSize - 1;
        }
        int endY = end.getY() + 1;
        if (endY > fieldSize - 1) {
            endY = fieldSize - 1;
        }
        for (int i = originX; i <= endX; i++) {
            for (int j = originY; j <= endY; j++) {
                designerField[j][i].setType(PointType.MISS);
            }
        }
    }

    public void sendAsDesignerField(Point[][] field, Point point, PointType state) {
        int originX = point.getX() - 1;
        if (originX < 0) {
            originX = 0;
        }
        int originY = point.getY() - 1;
        if (originY < 0) {
            originY = 0;
        }
        int endX = point.getX() + 1;
        if (endX > fieldSize - 1) {
            endX = fieldSize - 1;
        }
        int endY = point.getY() + 1;
        if (endY > fieldSize - 1) {
            endY = fieldSize - 1;
        }
        for (int i = originX; i <= endX; i++) {
            for (int j = originY; j <= endY; j++) {
                field[j][i].setType(state);
            }
        }
    }

    public void showFields(Point[][] field) {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                PointType state = field[i][j].getType();
                switch (state) {
                    case FIELD:
                        System.out.print(". ");
                        break;
                    case UNHITTED_DECK:
                        System.out.print("# ");
                        break;
                    case HITTED_DECK:
                        System.out.print("@ ");
                        break;
                    case MISS:
                        System.out.print("& ");
                        break;
                }
            }
            System.out.println();

        }
    }

    //    public boolean checkShot(Point shot) {
//        boolean isDamaged = false;
//        if (fieldWithShips[shot.getY()][shot.getX()].getType() == PointType.UNHITTED_DECK) {
//            for (Ship ship : ships) {
//                for (Point deck : ship.getCoordinates()) {
//                    if (shot.equals(deck)) {
//                        isDamaged = true;
//                        sendAsGameField(gameField, shot, PointType.HITTED_DECK);
//                        sendAsGameField(this.fieldWithShips, shot, PointType.HITTED_DECK);
//                        ship.getCoordinates().remove(deck);
////                        game.notifyStatisticListeners("Hit");
//                        break;
//                    }
//                }
//                if (ship.getCoordinates().isEmpty()) {
//                    for (Point deck : ship.getCoordinatesForProgram()) {
//                        sendAsDesignerField(fieldForDestroyedShips, deck, PointType.MISS);
//                    }
//                    for (int i = 0; i < fieldSize; i++) {
//                        for (int j = 0; j < fieldSize; j++) {
//                            if (fieldForDestroyedShips[j][i].getType() == PointType.MISS && fieldWithShips[j][i].getType() != PointType.UNHITTED_DECK && fieldWithShips[j][i].getType() != PointType.HITTED_DECK) {
//                                gameField[j][i].setType(fieldForDestroyedShips[j][i].getType());
//                                this.fieldWithShips[j][i].setType(fieldForDestroyedShips[j][i].getType());
//                            }
//                        }
//                    }
//                    ships.remove(ship);
////                    game.notifyStatisticListeners("Destroyed");
////                    }
//                    break;
//                }
//            }
//        } else {
//            sendAsGameField(gameField, shot, PointType.MISS);
//            sendAsGameField(this.fieldWithShips, shot, PointType.MISS);
////            game.notifyStatisticListeners("Miss");
//        }
//        return isDamaged;
//    }
    public boolean checkShot(Point shot) {
        boolean isDamaged = false;
        if (fieldWithShips[shot.getY()][shot.getX()].getType() == PointType.UNHITTED_DECK) {
            for (Iterator<Ship> shipIterator = ships.iterator(); shipIterator.hasNext();) {
                Ship currentShip = shipIterator.next();
                for (Iterator<Point> deckIterator = currentShip.getCoordinates().iterator(); deckIterator.hasNext(); ) {
                    if (shot.equals(deckIterator.next())) {
                        System.out.println("damaged");
                        isDamaged = true;
                        sendAsGameField(gameField, shot, PointType.HITTED_DECK);
                        sendAsGameField(this.fieldWithShips, shot, PointType.HITTED_DECK);
                        deckIterator.remove();
                        if (currentShip.getCoordinates().isEmpty()) {
                            System.out.println("and destroyed " + currentShip.getName());
                            for (Point point : currentShip.getCoordinatesForProgram()) {
                                sendAsDesignerField(fieldForDestroyedShips, point, PointType.MISS);
                            }
                            for (int i = 0; i < fieldSize; i++) {
                                for (int j = 0; j < fieldSize; j++) {
                                    if (fieldForDestroyedShips[j][i].getType() == PointType.MISS && fieldWithShips[j][i].getType() != PointType.UNHITTED_DECK && fieldWithShips[j][i].getType() != PointType.HITTED_DECK) {
                                        gameField[j][i].setType(fieldForDestroyedShips[j][i].getType());
                                        this.fieldWithShips[j][i].setType(fieldForDestroyedShips[j][i].getType());
                                    }
                                }
                            }
                            shipIterator.remove();
                            break;
                        }
//                        break;
                    }
                }
            }
        } else if (fieldWithShips[shot.getY()][shot.getX()].getType() != PointType.FIELD) {
            return false;
        } else {
            sendAsGameField(gameField, shot, PointType.MISS);
            sendAsGameField(this.fieldWithShips, shot, PointType.MISS);
        }
        return isDamaged;
    }

    public boolean isAvailableForShot(Point shot) {
        if (fieldWithShips[shot.getY()][shot.getX()].getType() == PointType.FIELD || fieldWithShips[shot.getY()][shot.getX()].getType() == PointType.UNHITTED_DECK) {
            return true;
        }
        return false;
    }

    public boolean isAllShipDestroyed() {
        if (ships.size() == 0) {
            return true;
        }
        return false;
    }
}
