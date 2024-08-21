package org.simulation.model.entities.dynamic.carnivore;

import org.simulation.model.entities.Icons;
import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.dynamic.herbivore.Herbivore;
import org.simulation.service.Graphs.AStarAlgorithmQueue;
import org.simulation.service.Graphs.DistanceCalculationHeuristic.ChebyshevDistanceCalculator;
import org.simulation.service.Graphs.Entities.Coordinates;
import org.simulation.service.Graphs.GraphFabric.AStarGraphFactory;
import org.simulation.service.Graphs.GraphFabric.GraphAbstractFabric;
import org.simulation.service.PathFinder.PathFinderBFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wolf extends Carnivore {
    private int visionRange = 10;

    public static void main(String[] args) {
        Wolf wolf = new Wolf(new Coordinates(2, 2), 5, 1, 2);

        WorldMap wp = new WorldMap(3, 3);

        wp.setCreature(wolf);
        wp.setCreature(new Wolf(new Coordinates(0, 0), 5, 1, 2));
        wp.setCreature(new Wolf(new Coordinates(1, 0), 5, 1, 2));
    }

    public Wolf(Coordinates position, int speed, int hp, int attack) {
        super(position, speed, hp, attack);
        graphAbstractFabric = AStarGraphFactory.getInstance();
        pathFinder = AStarAlgorithmQueue.getInstance(new ChebyshevDistanceCalculator());
    }

    public Wolf(Coordinates position, WorldMap worldMap, int speed, int hp, int attack) {
        super(position, worldMap, speed, hp, attack);
        graphAbstractFabric = AStarGraphFactory.getInstance();
        pathFinder = AStarAlgorithmQueue.getInstance(new ChebyshevDistanceCalculator());
    }

    @Override
    public void makeMove() {
//        int actionPoints = getSpeed();
//        Coordinates newPosition = this.position;
//        List<Coordinates> path = new ArrayList<>();
//
//        var closest = worldMap.getClosest(this.position, Herbivore.class);
//        if (closest.isPresent()) {
//            path = pathFinder.findPath(this.position, closest.get(), worldMap);
//            if (path.size() > 0) {
//                path.removeLast();
//                path.removeFirst();
//            }
//        }
//        else {
//            chooseRandomDirection();
//        }
//
//        var pathIterator = path.iterator();
//        while (actionPoints > 0 && pathIterator.hasNext()) {
//            newPosition = pathIterator.next();
//            actionPoints--;
//        }
//
//        this.worldMap.removeCreature(this.position);
//        this.setPosition(newPosition);
//        this.worldMap.setCreature(this);


    }

    private Optional<Coordinates> chooseTarget() {
        return worldMap.getClosest(this.position, Herbivore.class);
    }

    private Coordinates chooseRandomDirection() {
        return new Coordinates(0, 0);
    }

    @Override
    public String getIcon() {
        return Icons.ICON_WOLF;
    }
}
