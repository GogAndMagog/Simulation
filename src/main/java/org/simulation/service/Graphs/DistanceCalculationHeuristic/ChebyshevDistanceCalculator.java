package org.simulation.service.Graphs.DistanceCalculationHeuristic;

import org.simulation.service.Graphs.Entities.Coordinates;

public class ChebyshevDistanceCalculator implements DistanceCalculator {

    private static DistanceCalculator instance = new ChebyshevDistanceCalculator();

    private ChebyshevDistanceCalculator() {}

    public static DistanceCalculator getInstance() {
        if (instance == null) {
            instance = new ChebyshevDistanceCalculator();
        }
        return instance;
    }

    @Override
    public double calculateDistance(Coordinates from, Coordinates to) {
        return Math.max(Math.abs(from.getX() - to.getX()), Math.abs(from.getY() - to.getY()));
    }
}
