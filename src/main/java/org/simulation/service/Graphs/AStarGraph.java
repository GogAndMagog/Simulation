package org.simulation.service.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AStarGraph implements Graph<String, AStarNode> {

    private List<AStarNode> nodes = new ArrayList<>();
    private HashMap<String, AStarNode> idToNodes = new HashMap<>();
    private HashMap<Coordinates, AStarNode> coordinatesToNodes = new HashMap<>();

    @Override
    public void addNode(AStarNode node) {
        nodes.add(node);
        idToNodes.put(node.getId(), node);
        coordinatesToNodes.put(node.getCoordinates(), node);
    }

    @Override
    public AStarNode getNodeById(String node) {
        return idToNodes.get(node);
    }

    public AStarNode getNodeByCoordinates(Coordinates coordinates) {
        return coordinatesToNodes.get(coordinates);
    }

    public void addNeighbour(String id, AStarNode node) {
        try {
            idToNodes.get(id).addNeighbour(node);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<AStarNode> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (var node : nodes) {
            str.append(node.getId()).append(": ").append(node.getNeighbours()).append("\n");
        }
        return str.toString();
    }
}
