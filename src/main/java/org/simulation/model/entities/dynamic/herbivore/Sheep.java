package org.simulation.model.entities.dynamic.herbivore;

import org.simulation.model.entities.Icons;
import org.simulation.model.entities.WorldMap;
import org.simulation.service.Graphs.AStarAlgorithmQueue;
import org.simulation.service.Graphs.DistanceCalculationHeuristic.ChebyshevDistanceCalculator;
import org.simulation.service.Graphs.Entities.Coordinates;
import org.simulation.service.Graphs.GraphFabric.AStarGraphFactory;

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

    @Override
    public void makeMove() {

    }

    @Override
    public String getIcon() {
        return Icons.ICON_SHEEP;
    }
}
