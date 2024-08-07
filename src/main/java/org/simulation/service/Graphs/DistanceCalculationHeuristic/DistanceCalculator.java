package org.simulation.service.Graphs.DistanceCalculationHeuristic;

import Graphs.Coordinates;

public interface DistanceCalculator {
    public int calculateDistance(Coordinates from, Coordinates to);
}
