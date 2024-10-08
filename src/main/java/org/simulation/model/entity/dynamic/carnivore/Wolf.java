package org.simulation.model.entity.dynamic.carnivore;

import org.simulation.model.entity.Icons;
import org.simulation.model.entity.WorldMap;
import org.simulation.model.entity.dynamic.Creature;
import org.simulation.model.entity.dynamic.herbivore.Herbivore;
import org.simulation.model.entity.statical.terrain.Terrain;
import org.simulation.service.graph.AStarAlgorithmQueue;
import org.simulation.service.graph.distancecalculationheuristic.ChebyshevDistanceCalculator;
import org.simulation.service.graph.entity.Coordinates;
import org.simulation.service.graph.entity.Graph;
import org.simulation.service.graph.entity.Node;
import org.simulation.service.graph.graphfabric.AStarGraphFactory;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Wolf extends Carnivore {

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

    public static Wolf getWolf(Coordinates coordinates)
    {
        return new Wolf(coordinates, 5, 10, 3);
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
        Graph<String, Node> graph = graphAbstractFabric.createGraph(this.worldMap);
        List<Coordinates> path = pathFinder.findPath(graph,
                graph.getNodeByCoordinates(this.getPosition()).getId(),
                graph.getNodeByCoordinates(target.getPosition()).getId());

        if (path == null) {
            return actionPointsPerTurn;
        }

        //remove current position and position of target creature
        path.removeLast();
        path.removeFirst();

        Iterator<Coordinates> pathIterator = path.iterator();
        Coordinates currentCoordinates;
        while (pathIterator.hasNext() && actionPointsPerTurn > 0) {
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
