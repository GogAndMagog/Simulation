package org.simulation.service.Graphs.GraphFabric;

import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.statical.terrain.Terrain;
import org.simulation.service.Graphs.Entities.*;

import java.util.ArrayList;
import java.util.List;

public class AStarGraphFactory implements GraphAbstractFabric<AStarGraph> {

    private static AStarGraphFactory instance = new AStarGraphFactory();

    public static AStarGraphFactory getInstance() {
        if (instance == null) {
            instance = new AStarGraphFactory();
        }
        return instance;
    }

    private AStarGraphFactory() {}

    @Override
    public AStarGraph createGraph(WorldMap worldMap) {
        AStarGraph aStarGraph = new AStarGraph();
        AStarNode aStarNode;

        Coordinates coordinates;

        int id = 0;

        for (int i = 0; i < worldMap.getX(); i++) {
            for (int j = 0; j < worldMap.getX(); j++) {
                coordinates = new Coordinates(i, j);
                aStarGraph.addNode(new AStarNode(Integer.toString(id), coordinates, Terrain.DEFAULT_PASSABILITY));
                id++;
            }
        }

        for (var landscapeObject : worldMap.getLandscape().entrySet()) {
            aStarNode = aStarGraph.getNodeByCoordinates(landscapeObject.getValue().getPosition());

            if (landscapeObject.getValue() instanceof Terrain) {
                aStarNode.setCost(((Terrain) landscapeObject.getValue()).getPassability());
            } else {
                aStarNode.setCost(Integer.MAX_VALUE);
            }
        }

        for (var creature : worldMap.getCreatures().entrySet()) {
            aStarNode = aStarGraph.getNodeByCoordinates(creature.getValue().getPosition());
            aStarNode.setCost(Integer.MAX_VALUE);
        }



        for (var node : aStarGraph.getNodes()) {
            var neighbors = getNeighbours(node.getCoordinates(), worldMap.getX(), worldMap.getY());
            for (var neighbor : neighbors) {
                aStarGraph.addNeighbour(node.getId(), aStarGraph.getNodeByCoordinates(neighbor));
            }
        }

        return aStarGraph;
    }


    public List<Coordinates> getNeighbours(Coordinates coordinates, int n, int m) {
        List<Coordinates> neighbors = new ArrayList<>();

        Coordinates tmpPosition = new Coordinates(coordinates.getX(), coordinates.getY() - 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() + 1, coordinates.getY() - 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() + 1, coordinates.getY());
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() + 1, coordinates.getY() + 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX(), coordinates.getY() + 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() - 1, coordinates.getY() + 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() - 1, coordinates.getY());
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() - 1, coordinates.getY() - 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        return neighbors;
    }

    private boolean isAccessible(Coordinates coordinates, int n, int m) {
        return checkOutOfField(coordinates, n, m);
    }

    private boolean checkOutOfField(Coordinates coordinates, int n, int m) {
        if (coordinates.getX() >= n ||
                coordinates.getX() < 0 ||
                coordinates.getY() >= m ||
                coordinates.getY() < 0)
            return false;
        else
            return true;
    }



}
