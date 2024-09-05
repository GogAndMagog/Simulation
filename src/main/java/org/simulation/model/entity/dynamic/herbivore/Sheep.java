package org.simulation.model.entity.dynamic.herbivore;

import org.simulation.model.entity.Icons;
import org.simulation.model.entity.WorldMap;
import org.simulation.model.entity.statical.LandscapeObject;
import org.simulation.model.entity.statical.terrain.Herb;
import org.simulation.model.entity.statical.terrain.Terrain;
import org.simulation.service.graph.AStarAlgorithmQueue;
import org.simulation.service.graph.distancecalculationheuristic.ChebyshevDistanceCalculator;
import org.simulation.service.graph.entity.Coordinates;
import org.simulation.service.graph.entity.Graph;
import org.simulation.service.graph.entity.Node;
import org.simulation.service.graph.graphfabric.AStarGraphFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Sheep extends Herbivore {

    public Sheep(Coordinates position, int actionPoints, int hp) {
        super(position, actionPoints, hp);
        graphAbstractFabric = AStarGraphFactory.getInstance();
        pathFinder = AStarAlgorithmQueue.getInstance(ChebyshevDistanceCalculator.getInstance());
    }

    public Sheep(Coordinates position, WorldMap worldMap, int actionPoints, int hp) {
        super(position, worldMap, actionPoints, hp);
        graphAbstractFabric = AStarGraphFactory.getInstance();
        pathFinder = AStarAlgorithmQueue.getInstance(ChebyshevDistanceCalculator.getInstance());
    }

    public static Sheep getSheep(Coordinates coordinates) {
        return new Sheep(coordinates, 3, 5);
    }

    @Override
    public void makeMove() {
        LandscapeObject target = this.worldMap
                .getLandscape()
                .get(targetIdentifier.getClosest(this.getPosition(),
                        worldMap.getLandscape()
                                .values()
                                .stream()
                                .filter(this::filterCreaturesOnTheGround)
                                .collect(Collectors.toCollection(ArrayList::new)),
                        Herb.class));

        if (target == null) {
            return;
        }

        int actionPointsPerTurn = this.getActionPoints();

        actionPointsPerTurn = movement(actionPointsPerTurn, target);

        if (actionPointsPerTurn > 0) {
            eatHerb(target);
        }
    }


    private int movement(Integer actionPointsPerTurn, LandscapeObject target) {
        Graph<String, Node> graph = graphAbstractFabric.createGraph(this.worldMap);
        List<Coordinates> path = pathFinder.findPath(graph,
                graph.getNodeByCoordinates(this.getPosition()).getId(),
                graph.getNodeByCoordinates(target.getPosition()).getId());

        if (path == null) {
            return actionPointsPerTurn;
        }

        //remove current position
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

    @Override
    public String getIcon() {
        return Icons.ICON_SHEEP;
    }
}
