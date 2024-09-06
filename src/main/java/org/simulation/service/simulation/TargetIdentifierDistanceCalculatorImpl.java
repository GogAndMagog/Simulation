package org.simulation.service.simulation;

import org.simulation.model.entity.Entity;
import org.simulation.service.graph.distancecalculationheuristic.ChebyshevDistanceCalculator;
import org.simulation.service.graph.distancecalculationheuristic.DistanceCalculator;
import org.simulation.service.graph.entity.Coordinates;

import java.util.Collection;

public class TargetIdentifierDistanceCalculatorImpl implements TargetIdentifier {
    DistanceCalculator distanceCalculator;

    static private TargetIdentifierDistanceCalculatorImpl instance = new TargetIdentifierDistanceCalculatorImpl();

    private TargetIdentifierDistanceCalculatorImpl() {
        distanceCalculator = ChebyshevDistanceCalculator.getInstance();
    }

    static public TargetIdentifierDistanceCalculatorImpl getInstance() {
        if (instance == null) {
            instance = new TargetIdentifierDistanceCalculatorImpl();
        }
        return instance;
    }

    @Override
    public Coordinates getClosest(Coordinates from, Collection<? extends Entity> entities, Class<?>... targetClasses) {
        double minDistance = Double.MAX_VALUE;
        double currDistance;
        Coordinates closestCoordinates = null;

        for (Entity entity : entities) {
            for (var targetClass : targetClasses) {
                if (targetClass.isInstance(entity)) {
                    currDistance = distanceCalculator.calculateDistance(from, entity.getPosition());
                    if (currDistance < minDistance) {
                        minDistance = currDistance;
                        closestCoordinates = entity.getPosition();
                    }
                }
            }
        }

        return closestCoordinates;
    }
}
