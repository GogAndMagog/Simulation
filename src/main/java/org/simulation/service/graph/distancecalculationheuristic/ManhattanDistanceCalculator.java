package org.simulation.service.graph.distancecalculationheuristic;

import org.simulation.service.graph.entity.Coordinates;

public class ManhattanDistanceCalculator implements DistanceCalculator {

    private static DistanceCalculator instance = new ManhattanDistanceCalculator();

    private ManhattanDistanceCalculator() {}

    public static DistanceCalculator getInstance() {
        if (instance == null) {
            instance = new ManhattanDistanceCalculator();
        }
        return instance;
    }

    @Override
    public double calculateDistance(Coordinates from, Coordinates to) {
        return Math.abs(from.getX() - to.getY()) + Math.abs(from.getY() - to.getY());
    }
}
