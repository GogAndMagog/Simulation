package org.simulation.service.Graphs.GraphFabric;

import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.statical.Terrain;
import org.simulation.service.Graphs.Entities.Coordinates;
import org.simulation.service.Graphs.Entities.DijkstraGraph;
import org.simulation.service.Graphs.Entities.DijkstraNode;

public class DijkstraGraphFabric implements GraphAbstractFabric<DijkstraGraph> {
    @Override
    public DijkstraGraph createGraph(WorldMap worldMap) {
        DijkstraGraph dijkstraGraph = new DijkstraGraph();
        DijkstraNode dijkstraNode;

        Coordinates coordinates;

        int id = 0;

        for (int i = 0; i < worldMap.getX(); i++) {
            for (int j = 0; j < worldMap.getX(); j++) {
                coordinates = new Coordinates(i, j);
                dijkstraGraph.addNode(new DijkstraNode(Integer.toString(id), coordinates, 1));
                id++;
            }
        }

        for (var creature : worldMap.getCreatures().entrySet()) {
            dijkstraNode = dijkstraGraph.getNodeByCoordinates(creature.getValue().getPosition());
            dijkstraNode.setCost(Integer.MAX_VALUE);
        }

        for (var landscapeObject : worldMap.getLandscape().entrySet()) {
            dijkstraNode = dijkstraGraph.getNodeByCoordinates(landscapeObject.getValue().getPosition());

            if (landscapeObject.getValue() instanceof Terrain) {
                dijkstraNode.setCost(((Terrain) landscapeObject.getValue()).getPassability());
            } else {
                dijkstraNode.setCost(Integer.MAX_VALUE);
            }
        }

        return dijkstraGraph;
    }
}
