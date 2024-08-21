package org.simulation.service.Graphs;

import org.simulation.service.Graphs.Entities.DijkstraGraph;
import org.simulation.service.Graphs.Entities.DijkstraNode;

import java.util.*;

public class DijkstraAlgorithmQueue implements PathFinder<String, DijkstraNode, DijkstraGraph> {

    private static final DijkstraAlgorithmQueue instance = new DijkstraAlgorithmQueue();

    public static DijkstraAlgorithmQueue getInstance() {
        return instance;
    }

    private DijkstraAlgorithmQueue(){}

    @Override
    public List<String> findPath(DijkstraGraph graph, String baseNode, String targetNode) {

        Set<DijkstraNode> visited = new HashSet<>();
        Queue<DijkstraNode> queue = new PriorityQueue<>();
        Map<String, Integer> totalDistance = new HashMap<>();

        totalDistance = this.createTotalDistance(graph, baseNode);

        DijkstraNode currentNode;
        queue.add(graph.getNodeById(baseNode));
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            if (visited.contains(currentNode)) {
                continue;
            }
            for (var neighbour : currentNode.getNeighbours().values()) {
                if (!visited.contains(neighbour)) {
                    if ((totalDistance.get(currentNode.getId()) + currentNode.getCost()) < totalDistance.get(neighbour.getId())) {
                        totalDistance.put(neighbour.getId(), totalDistance.get(currentNode.getId()) + currentNode.getCost());
                        neighbour.setParent(currentNode);
                    }
                    queue.add(neighbour);
                }
            }

            visited.add(currentNode);
        }

        return restorePath(graph, targetNode);
    }

    private HashMap<String, Integer> createTotalDistance(DijkstraGraph graph, String baseNode) {
        HashMap<String, Integer> totalDistance = new HashMap<>();

        for (var node : graph.getNodes()) {
            totalDistance.put(node.getId(), Integer.MAX_VALUE);
        }

        totalDistance.put(baseNode, 0);

        return totalDistance;
    }

    private List<String> restorePath(DijkstraGraph graph, String targetNode) {
        List<String> path = new ArrayList<>();
        DijkstraNode currentNode = graph.getNodeById(targetNode);

        while (currentNode != null) {
            path.add(currentNode.getId());
            currentNode = currentNode.getParent();
        }

        return path;
    }
}