package org.simulation.service.graphs.distancecalculationheuristic;

import org.simulation.service.graphs.entity.Coordinates;

public interface DistanceCalculator {
    double calculateDistance(Coordinates from, Coordinates to);
}
