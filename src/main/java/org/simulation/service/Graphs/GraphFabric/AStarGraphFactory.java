package org.simulation.service.Graphs.GraphFabric;

import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.statical.Terrain;
import org.simulation.service.Graphs.Entities.*;

public class AStarGraphFactory implements GraphAbstractFabric<AStarGraph>{
    @Override
    public AStarGraph createGraph(WorldMap worldMap) {
        AStarGraph aStarGraph = new AStarGraph();
        AStarNode aStarNode;

        Coordinates coordinates;

        int id = 0;

        for (int i = 0; i < worldMap.getX(); i++) {
            for (int j = 0; j < worldMap.getX(); j++) {
                coordinates = new Coordinates(i, j);
                aStarGraph.addNode(new AStarNode(Integer.toString(id), coordinates, 1));
                id++;
            }
        }

        for (var creature : worldMap.getCreatures().entrySet()) {
            aStarNode = aStarGraph.getNodeByCoordinates(creature.getValue().getPosition());
            aStarNode.setCost(Integer.MAX_VALUE);
        }

        for (var landscapeObject : worldMap.getLandscape().entrySet()) {
            aStarNode = aStarGraph.getNodeByCoordinates(landscapeObject.getValue().getPosition());

            if (landscapeObject.getValue() instanceof Terrain) {
                aStarNode.setCost(((Terrain) landscapeObject.getValue()).getPassability());
            } else {
                aStarNode.setCost(Integer.MAX_VALUE);
            }
        }

        return aStarGraph;
    }
}
