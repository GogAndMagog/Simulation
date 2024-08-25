package org.simulation.model.entities.dynamic.carnivore;

import org.simulation.model.entities.Icons;
import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.dynamic.Creature;
import org.simulation.model.entities.dynamic.herbivore.Herbivore;
import org.simulation.model.entities.statical.terrain.Terrain;
import org.simulation.service.Graphs.AStarAlgorithmQueue;
import org.simulation.service.Graphs.DistanceCalculationHeuristic.ChebyshevDistanceCalculator;
import org.simulation.service.Graphs.DistanceCalculationHeuristic.DistanceCalculator;
import org.simulation.service.Graphs.Entities.Coordinates;
import org.simulation.service.Graphs.GraphFabric.AStarGraphFactory;

import java.util.*;
import java.util.stream.Collectors;

public class Wolf extends Carnivore {
    private int visionRange = 10;


    public static void main(String[] args) {
        Wolf wolf = new Wolf(new Coordinates(2, 2), 5, 1, 2);

        WorldMap wp = new WorldMap(3, 3);

        wp.setCreature(wolf);
        wp.setCreature(new Wolf(new Coordinates(0, 0), 5, 1, 2));
        wp.setCreature(new Wolf(new Coordinates(1, 0), 5, 1, 2));
    }

    public Wolf(Coordinates position, int actionPoints, int hp, int attack) {
        super(position, actionPoints, hp, attack);
        graphAbstractFabric = AStarGraphFactory.getInstance();
        pathFinder = AStarAlgorithmQueue.getInstance(ChebyshevDistanceCalculator.getInstance());
    }

    public Wolf(Coordinates position, WorldMap worldMap, int actionPoints, int hp, int attack) {
        super(position, worldMap, actionPoints, hp, attack);
        graphAbstractFabric = AStarGraphFactory.getInstance();
        pathFinder = AStarAlgorithmQueue.getInstance(ChebyshevDistanceCalculator.getInstance());
    }

    @Override
    public void makeMove() {
        Creature target = this.worldMap
                .getCreatures()
                .get(targetIdentifier.getClosest(this.getPosition(),
                        worldMap.getCreatures()
                                .values()
                                .stream()
                                .filter(this::filterDeadCreatures)
                                .collect(Collectors.toCollection(ArrayList::new)),
                        Herbivore.class));

        if (target == null) {
            return;
        }

        int actionPointsPerTurn = this.getActionPoints();

        actionPointsPerTurn = movement(actionPointsPerTurn, target);

        if (actionPointsPerTurn > 0) {
            attack(target);
        }
    }

    private int movement(Integer actionPointsPerTurn, Creature target) {
        var graph = graphAbstractFabric.createGraph(this.worldMap);
        List<Coordinates> path = pathFinder.findPath(graph,
                graph.getNodeByCoordinates(this.getPosition()),
                graph.getNodeByCoordinates(target.getPosition()));

        Iterator<Coordinates> pathIterator = path.iterator();
        Coordinates currentCoordinates;
        while (pathIterator.hasNext() || actionPointsPerTurn > 0) {
            currentCoordinates = pathIterator.next();
            var landscapeObject = this.worldMap.getLandscape().get(currentCoordinates);
            if (landscapeObject instanceof Terrain) {
                actionPointsPerTurn -= ((Terrain) landscapeObject).getPassability();
            } else
                actionPointsPerTurn -= Terrain.DEFAULT_PASSABILITY;
            if (actionPointsPerTurn >= 0) {
                this.position = currentCoordinates;
            }
        }

        return actionPointsPerTurn;
    }

    private Coordinates chooseRandomDirection() {
        return new Coordinates(0, 0);
    }

    @Override
    public String getIcon() {
        return Icons.ICON_WOLF;
    }
}
