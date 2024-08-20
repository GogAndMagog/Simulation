package org.simulation.service.Graphs.Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DijkstraGraph implements Graph<String, DijkstraNode> {
    private List<DijkstraNode> nodes = new ArrayList<>();
    private HashMap<String, DijkstraNode> idToNodes = new HashMap<>();
    private HashMap<Coordinates, DijkstraNode> coordinatesToNodes = new HashMap<>();

    @Override
    public void addNode(DijkstraNode node) {
        nodes.add(node);
        idToNodes.put(node.getId(), node);
        coordinatesToNodes.put(node.getCoordinates(), node);
    }

    @Override
    public DijkstraNode getNodeById(String dijkstraNode) {
        return idToNodes.get(dijkstraNode);
    }

    public DijkstraNode getNodeByCoordinates(Coordinates coordinates) {
        return coordinatesToNodes.get(coordinates);
    }

    public void addNeighbour(String id, DijkstraNode node) {
        try {
            idToNodes.get(id).addNeighbour(node);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<DijkstraNode> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (var node : nodes) {
            str.append("ID = ").append(node.getId())
                    .append(" Cost = ").append(node.getCost())
                    .append(" Coordinates = ").append(node.getCoordinates())
                    .append(": ").append(node.getNeighbours())
                    .append("\n");
        }
        return str.toString();
    }
}
