package org.simulation.service.PathFinder;

import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.dynamic.carnivore.Wolf;
import org.simulation.model.entities.searchstructs.Graph;
import org.simulation.model.entities.searchstructs.Node;
import org.simulation.model.entities.statical.Rock;
import org.simulation.service.Graphs.Entities.Coordinates;

import java.util.*;

public class PathFinderBFS implements PathFinder {

    public static void main(String[] args) {
        int x = 4;
        int y = 4;

        WorldMap map = new WorldMap(x, y);
        map.setCreature(new Wolf(new Coordinates(0, 0), 2, 10, 2));
//        map.setCreature(new Wolf(new Coordinates(2, 2), 2, 10));
//        map.setLandscapeObject(new Rock(new Coordinates(2, 0)));
        map.setLandscapeObject(new Rock(new Coordinates(2, 1)));
        map.setLandscapeObject(new Rock(new Coordinates(2, 3)));
//        map.setLandscapeObject(new Rock(new Coordinates(1, 1)));

        PathFinder pathFinder = new PathFinderBFS();
        var path = pathFinder.findPath(new Coordinates(3, 3), new Coordinates(0, 0), map);
        path.forEach(System.out::println);
    }

    @Override
    public List<Coordinates> findPath(Coordinates startNode, Coordinates target, WorldMap worldMap) {
        Set<Coordinates> visited = new HashSet<>();
        Queue<Node> path = new LinkedList<>();
        LinkedList<Coordinates> result = new LinkedList<>();

        Graph graph = Graph.createGraph(worldMap, target);
        Node curNode = graph.getNode(startNode);
        curNode.setParent(null);

        path.add(curNode);
        while (!path.isEmpty()) {

            curNode = path.poll();

            if (curNode.getPosition().equals(target)) {
                break;
            }

            curNode.setVisited(true);

            for (var child : curNode.getChildren()) {
                if (!child.isVisited()) {
                    path.add(child);
                } else
                    continue;

                if (child.getParent() == null) {
                    child.setParent(curNode);
                }
            }
        }

        if (curNode.getPosition().equals(target)) {
            while (curNode != null) {
                result.add(curNode.getPosition());
                curNode = curNode.getParent();
            }
            Collections.reverse(result);
        }

        return result;
    }
}
