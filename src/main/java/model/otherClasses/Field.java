package model.otherClasses;

import java.util.ArrayList;
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

    public Field(ShipFactory factory) {
        this.factory = factory;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public List<Ship> getShips() {
        return ships;
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

    public void updateFields(List<Point> decks) {
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
}
