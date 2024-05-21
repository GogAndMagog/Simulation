package org.simulation.model.entities.searchstructs;

import org.simulation.model.coordinates.Coordinates;
import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.dynamic.Creature;
import org.simulation.model.entities.dynamic.carnivore.Wolf;
import org.simulation.model.entities.statical.Rock;

import java.util.*;

public class Graph {
    Map<Coordinates, Node> nodes = new HashMap<Coordinates, Node>();

    public static void main(String[] args) {
        int x = 3;
        int y = 3;

        WorldMap map = new WorldMap(x, y);
        map.setCreature(new Wolf(new Coordinates(0, 0), 2, 10));
        map.setCreature(new Wolf(new Coordinates(2, 2), 2, 10));
        map.setLandscapeObject(new Rock(new Coordinates(1, 1)));

        Graph graph = new Graph();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                graph.addNode(new Node(new Coordinates(i, j), 0));
            }
        }
        graph.fillChildren(map, new Coordinates(3, 3));
        System.out.println(graph);
    }

    public void addNode(Node node) {
        nodes.put(node.getPosition(), node);
    }

    public void fillChildren(WorldMap wp, Coordinates target) {
        List<Coordinates> childrenPositions;
        List<Node> children = new ArrayList<>();

        for (Node node : nodes.values()) {
            children.clear();
            childrenPositions = wp.getNeighbours(node.getPosition(), target);

            for (Coordinates childPosition : childrenPositions) {
                if (nodes.get(childPosition) != null) {

                    children.add(nodes.get(childPosition));
                }
            }

            node.setChildren(children);
        }
    }

    public static Graph createGraph(WorldMap map, Coordinates target) {
        Graph graph = new Graph();

        for (int i = 0; i < map.getX(); i++) {
            for (int j = 0; j < map.getY(); j++) {
                graph.addNode(new Node(new Coordinates(i, j), 0));
            }
        }

        graph.fillChildren(map, target);

        return graph;
    }

    public Node getNode(Coordinates position) {
        return this.nodes.get(position);
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        nodes.values()
                .stream()
                .sorted((o1, o2) -> {
                    Comparator<Coordinates> coordinatesComparator
                            = Comparator.comparing(Coordinates::getX).thenComparing(Coordinates::getY);
                    return coordinatesComparator.compare(o1.getPosition(), o2.getPosition());
                })
                .forEach(nodeEntry -> {
                    str.append(nodeEntry)
                            .append("\n");
                });

        return str.toString();
    }
}
