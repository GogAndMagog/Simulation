package org.simulation.service.Graphs.DistanceCalculationHeuristic;

import org.simulation.service.Graphs.Entities.Coordinates;

public interface DistanceCalculator {
    public double calculateDistance(Coordinates from, Coordinates to);
}
