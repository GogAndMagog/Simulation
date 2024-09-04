package org.simulation.service.Graphs.Entities;

import java.util.Objects;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Coordinates {
    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public static Coordinates createCoordinates(int xRange, int yRange) {
        Random rand = new Random();
        return new Coordinates(rand.nextInt(0, xRange), rand.nextInt(0, yRange));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates: {" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}