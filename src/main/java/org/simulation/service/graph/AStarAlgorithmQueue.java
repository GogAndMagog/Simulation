package org.simulation.service.graph;

import org.simulation.service.graph.distancecalculationheuristic.DistanceCalculator;
import org.simulation.service.graph.entity.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class AStarAlgorithmQueue implements PathFinder<String, AStarNode, AStarGraph> {

    private static AStarAlgorithmQueue instance = null;

    private DistanceCalculator distanceCalculator;

    public static AStarAlgorithmQueue getInstance(DistanceCalculator calculator) {
        if (instance == null) {
            instance = new AStarAlgorithmQueue(calculator);
        }
        return instance;
    }

    private AStarAlgorithmQueue(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    @Override
    public List<Coordinates> findPath(AStarGraph graph, String baseNode, String targetNode) {
        Set<AStarNode> visited = new HashSet<>();
        Queue<AStarNode> queue = new PriorityQueue<>();
        Map<String, Integer> totalDistance = new HashMap<>();

        calculateHeuristicAndPriority(graph, baseNode, targetNode);
        totalDistance = this.createTotalDistance(graph, baseNode);

        AStarNode currentNode;
        queue.add(graph.getNodeById(baseNode));
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            if (currentNode.getId().equals(targetNode)) {
                break;
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

    private HashMap<String, Integer> createTotalDistance(AStarGraph graph, String baseNode) {
        HashMap<String, Integer> totalDistance = new HashMap<>();

        for (var node : graph.getNodes()) {
            totalDistance.put(node.getId(), Integer.MAX_VALUE);
        }

        totalDistance.put(baseNode, 0);

        return totalDistance;
    }

    private void calculateHeuristicAndPriority(AStarGraph graph, String baseNode, String targetNode) {

//        AStarNode baseAStarNode = graph.getNodeById(baseNode);
        AStarNode targetAStarNode = graph.getNodeById(targetNode);

        for (AStarNode currentNode : graph.getNodes()) {
            currentNode.setHeuristic(distanceCalculator
                    .calculateDistance(currentNode.getCoordinates(), targetAStarNode.getCoordinates()));
            currentNode.setPriority(currentNode.getCost() + currentNode.getHeuristic());
        }
    }

    private List<Coordinates> restorePath(AStarGraph graph, String targetNode) {
        List<Coordinates> path = new ArrayList<>();
        AStarNode currentNode = graph.getNodeById(targetNode);

        while (currentNode != null) {
            path.add(currentNode.getCoordinates());
            currentNode = currentNode.getParent();
        }

        Collections.reverse(path);

        return path;
    }
}
