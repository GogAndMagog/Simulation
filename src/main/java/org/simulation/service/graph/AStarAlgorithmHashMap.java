package org.simulation.service.graph;

import org.simulation.service.graph.distancecalculationheuristic.*;
import org.simulation.service.graph.entity.AStarGraph;
import org.simulation.service.graph.entity.AStarNode;
import org.simulation.service.graph.entity.Coordinates;

import java.util.*;

public class AStarAlgorithmHashMap implements PathFinder<String, AStarNode, AStarGraph> {

    DistanceCalculator distanceCalculator;

    public AStarAlgorithmHashMap(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    @Override
    public List<Coordinates> findPath(AStarGraph graph, String baseNode, String targetNode) {

        calculateHeuristicAndPriority(graph, baseNode, targetNode);

        HashMap<String, Double> costs = createCosts(graph, baseNode, targetNode);
        HashMap<String, String> parents = createParents(graph, baseNode);
        HashMap<String, AStarNode> neighbours = new HashMap<>();

        HashSet<String> passedNodes = new HashSet<>();

        double cost;
        double newCost;

//        System.out.println(graph);

        String currentNode = findLowestCostNode(costs, passedNodes);
//        System.out.println(currentNode);

        long comparisons = 0;
        while (currentNode != null) {
            comparisons++;
//            System.out.println("Current node: " + graph.getNodeById(currentNode).getCoordinates());
            if (currentNode.equals(targetNode)) {break;}
            cost = costs.get(currentNode);
            neighbours = graph.getNodeById(currentNode).getNeighbours();
            if (neighbours == null) {
                passedNodes.add(currentNode);
                currentNode = null;
                continue;
            }
            for (var neighbour : neighbours.keySet()) {
                newCost = cost + neighbours.get(neighbour).getCost();
                if (costs.get(neighbour) > newCost) {
                    costs.put(neighbour, newCost);
                    parents.put(neighbour, currentNode);
                }
            }
            passedNodes.add(currentNode);
            currentNode = findLowestCostNode(costs, passedNodes);
        }

        System.out.println("Comparisons: " + comparisons);

        return restorePath(parents, graph, baseNode, targetNode);
    }

    private HashMap<String, String> createParents(AStarGraph graph, String baseNode) {
        HashMap<String, String> parents = new HashMap<>();
        //Adding all nodes to table
        for (var node : graph.getNodes()) {
            parents.put(node.getId(), null);
        }

        var baseNodeNeighbours = graph.getNodeById(baseNode).getNeighbours();

        //Init neighbours of base node
        for (var neighbour : baseNodeNeighbours.keySet()) {
            if (parents.containsKey(neighbour)) {
                parents.put(neighbour, baseNode);
            }
        }

        parents.put(baseNode, null);

        return parents;
    }

    private HashMap<String, Double> createCosts(AStarGraph graph, String baseNode, String targetNode) {
        HashMap<String, Double> costs = new HashMap<>();

        //All nodes inits by MAX value analog of Infinity
        for (var node : graph.getNodes()) {
            costs.put(node.getId(), Double.MAX_VALUE);
        }

        //Neighbours of base node inits by its original costs
        var neighbours = graph.getNodeById(baseNode).getNeighbours();
        for (var neighbourNode : neighbours.keySet()) {
            costs.put(neighbourNode, ((AStarNode) neighbours.get(neighbourNode)).getPriority());
        }

        return costs;
    }

    private void calculateHeuristicAndPriority(AStarGraph graph, String baseNode, String targetNode) {

        AStarNode baseAStarNode = graph.getNodeById(baseNode);
        AStarNode targetAStarNode = graph.getNodeById(targetNode);

        for (AStarNode currentNode : graph.getNodes()) {
            currentNode.setHeuristic(distanceCalculator
                    .calculateDistance(currentNode.getCoordinates(), targetAStarNode.getCoordinates()));
            currentNode.setPriority(currentNode.getCost() + currentNode.getHeuristic());
        }
    }

    private String findLowestCostNode(HashMap<String, Double> costs, HashSet<String> passed) {
        double lowestCost = Integer.MAX_VALUE;
        double cost;

        String lowestCostNode = null;

        for (var node : costs.keySet()) {
            cost = costs.get(node);
            if (cost < lowestCost && !(passed.contains(node))) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }

        return lowestCostNode;
    }

    private List<Coordinates> restorePath(HashMap<String, String> parents, AStarGraph graph, String baseNode, String targetNode) {
        List<Coordinates> path = new ArrayList<>();
        String currentNode = targetNode;

        parents.put(baseNode, null);

        while (currentNode != null) {
            path.add(graph.getNodeById(currentNode).getCoordinates());
            currentNode = parents.get(currentNode);
        }

        Collections.reverse(path);

        return path;
    }
}
