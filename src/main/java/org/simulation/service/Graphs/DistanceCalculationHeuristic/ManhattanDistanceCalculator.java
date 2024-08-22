package org.simulation.service.Graphs.DistanceCalculationHeuristic;

import org.simulation.service.Graphs.Entities.Coordinates;

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
