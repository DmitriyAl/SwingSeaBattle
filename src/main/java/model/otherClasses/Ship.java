package model.otherClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dmitriy on 10.01.2016.
 */
public class Ship {
    private String name;
    private int length;
    private List<Point> coordinates;
    private Point[] coordinatesForProgram;
    private boolean isVertical;

    public Ship(String name, int length, List<Point> coordinates, Point[] coordinatesForProgram, boolean isVertical) {
        this.name = name;
        this.length = length;
        this.coordinates = coordinates;
        this.coordinatesForProgram = coordinatesForProgram;
        this.isVertical = isVertical;
    }

    public String getName() {
        return name;
    }

    public boolean isVertical() {
        return isVertical;
    }

    public int getLength() {
        return length;
    }

    public List<Point> getCoordinates() {
        return coordinates;
    }

    public Point[] getCoordinatesForProgram() {
        return coordinatesForProgram;
    }

    public boolean getIsVertical() {
        return isVertical;
    }

    public void setCoordinates(List<Point> coordinates) {
        this.coordinates = coordinates;
    }
}
