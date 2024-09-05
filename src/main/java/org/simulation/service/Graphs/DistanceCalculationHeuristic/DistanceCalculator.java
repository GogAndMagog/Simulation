package org.simulation.service.Graphs.DistanceCalculationHeuristic;

import org.simulation.service.Graphs.Entities.Coordinates;

public interface DistanceCalculator {
    double calculateDistance(Coordinates from, Coordinates to);
}
