package org.simulation.service.graphs;

import org.simulation.service.graphs.entity.Coordinates;
import org.simulation.service.graphs.entity.DijkstraGraph;
import org.simulation.service.graphs.entity.DijkstraNode;

import java.util.*;

public class DijkstraAlgorithmHashMap implements PathFinder<String, DijkstraNode, DijkstraGraph> {

  @Override
  public List<Coordinates> findPath(DijkstraGraph graph, String baseNode, String targetNode) {
    HashMap<String, Integer> costs = createCosts(graph, baseNode);
    HashMap<String, String> parents = createParents(graph, baseNode);
    HashMap<String, DijkstraNode> neighbours;

    HashSet<String> passedNodes = new HashSet<>();

    int cost;
    int newCost;

//    System.out.println(graph);
    passedNodes.add(baseNode);

    String currentNode = findLowestCostNode(costs, passedNodes);
//    System.out.println(currentNode);

    int comparisons = 0;
    while (currentNode != null) {
      comparisons++;
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

    //To avoid infinite loop we must null parent for base node
    parents.put(baseNode, null);


    System.out.println("Comparisons: " + comparisons);

    return restorePath(parents, graph, baseNode, targetNode);
  }

  private HashMap<String, String> createParents(DijkstraGraph graph, String baseNode) {
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

  private HashMap<String, Integer> createCosts(DijkstraGraph graph, String baseNode) {
    HashMap<String, Integer> costs = new HashMap<>();

    //All nodes inits by MAX value analog of Infinity
    for (var node : graph.getNodes()) {
      costs.put(node.getId(), Integer.MAX_VALUE);
    }

    //Neighbours of base node inits by its original costs
    var neighbours = graph.getNodeById(baseNode).getNeighbours();
    for (var neighbourNode : neighbours.keySet()) {
      costs.put(neighbourNode, neighbours.get(neighbourNode).getCost());
    }

    return costs;
  }

  private String findLowestCostNode(HashMap<String, Integer> costs, HashSet<String> passed) {
    int lowestCost = Integer.MAX_VALUE;
    int cost;

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

  private List<Coordinates> restorePath(HashMap<String, String> parents, DijkstraGraph graph, String baseNode, String targetNode) {
    List<Coordinates> path = new ArrayList<>();
    String currentNode = targetNode;

    while (currentNode != null) {
      path.add(graph.getNodeById(currentNode).getCoordinates());
      currentNode = parents.get(currentNode);
    }

    Collections.reverse(path);

    return path;
  }
}
