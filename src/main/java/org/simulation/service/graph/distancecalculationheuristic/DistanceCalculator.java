package org.simulation.service.graph.distancecalculationheuristic;

import org.simulation.service.graph.entity.Coordinates;

public interface DistanceCalculator {
    double calculateDistance(Coordinates from, Coordinates to);
}
