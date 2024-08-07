package org.simulation.service.Graphs.DistanceCalculationHeuristic;

import Graphs.Coordinates;

public class ManhattanDistanceCalculator implements DistanceCalculator {
    @Override
    public int calculateDistance(Coordinates from, Coordinates to) {
        return Math.abs(from.getX() - to.getY()) + Math.abs(from.getY() - to.getY());
    }
}
