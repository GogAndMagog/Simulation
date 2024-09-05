package org.simulation.service.simulation;

import org.simulation.model.entity.Entity;
import org.simulation.model.entity.dynamic.carnivore.Wolf;
import org.simulation.model.entity.dynamic.herbivore.Sheep;
import org.simulation.model.entity.statical.Rock;
import org.simulation.service.graph.distancecalculationheuristic.ChebyshevDistanceCalculator;
import org.simulation.service.graph.distancecalculationheuristic.DistanceCalculator;
import org.simulation.service.graph.entity.Coordinates;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public static void main(String[] args) {
        TargetIdentifierDistanceCalculatorImpl instance = TargetIdentifierDistanceCalculatorImpl.getInstance();

        List<Entity> entities = new ArrayList<Entity>();

        entities.add(new Wolf(new Coordinates(0,1), 10,10,10));
        entities.add(new Wolf(new Coordinates(1,1), 10,10,10));
        entities.add(new Wolf(new Coordinates(5,5), 10,10,10));
        entities.add(new Wolf(new Coordinates(5,0), 10,10,10));
        entities.add(new Sheep(new Coordinates(2,2),10,10));
        entities.add(new Sheep(new Coordinates(5,0),10,10));
        entities.add(new Rock(new Coordinates(4,4)));
        entities.add(new Rock(new Coordinates(4,3)));

        Coordinates from = new Coordinates(4,2);

        System.out.println(instance.getClosest(from, entities, Wolf.class));
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
