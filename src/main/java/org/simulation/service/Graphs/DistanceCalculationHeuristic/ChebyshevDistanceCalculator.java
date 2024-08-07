package org.simulation.service.Graphs.DistanceCalculationHeuristic;

import Graphs.Coordinates;

public class ChebyshevDistanceCalculator implements DistanceCalculator {
    @Override
    public int calculateDistance(Coordinates from, Coordinates to) {
        return Math.max(Math.abs(from.getX() - to.getX()), Math.abs(from.getY() - to.getY()));
    }
}
