package org.simulation.service.Graphs;


import org.simulation.service.Graphs.DistanceCalculationHeuristic.ChebyshevDistanceCalculator;
import org.simulation.service.Graphs.DistanceCalculationHeuristic.DistanceCalculator;
import org.simulation.service.Graphs.Entities.*;

import java.util.*;

public class Test {

    public static void main(String... args) {
        Test test = new Test();
        int times = 1;
        int n = 150;
        int m = 150;
        Coordinates targetCoordinates = new Coordinates(149, 149);

//        PathFinder pathFinder = new DijkstraAlgorithmQueue();
        PathFinder pathFinder = DijkstraAlgorithmQueue.getInstance();
        Graph graph = test.createDijkstraGraph2(n, m);

        test.testDijkstra2(graph, pathFinder, targetCoordinates);

        DistanceCalculator distanceCalculator = ChebyshevDistanceCalculator.getInstance();
        pathFinder = AStarAlgorithmQueue.getInstance(distanceCalculator);

//        test.testAStarGraph1(pathFinder);

        graph = test.createAStarGraph2(n, m);
        test.testAStarGraph2(graph, pathFinder, targetCoordinates);

//        try {
//            Graph graph = test.createDijkstraGraph2();
//            Graph finalGraph1 = graph;
//            System.out.println(test.estimateAlgorithm(() -> test.testDijkstra2((DijkstraGraph) finalGraph1), times));
//            graph = test.createAStarGraph2();
//            Graph finalGraph = graph;
//            System.out.println(test.estimateAlgorithm(() -> test.testAStarGraph2((AStarGraph) finalGraph), times));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

    }

    private long estimateAlgorithm(Runnable operation, int times) throws Exception {

        long startTime;
        long endTime;
        long totalTime = 0;
        long averageTime = 0;

        for (int i = 0; i < times; i++) {
            System.out.println(i);
            startTime = System.nanoTime();
            operation.run();
            endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        averageTime = totalTime / times;
        return averageTime;
    }

    private DijkstraGraph createDijkstraGraph(int n, int m) {
        DijkstraGraph dijkstraGraph = new DijkstraGraph();
        Coordinates coordinates;
        int id = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                coordinates = new Coordinates(j, i);
                dijkstraGraph.addNode(new DijkstraNode(Integer.toString(id), coordinates, 1));
                id++;
            }
        }

        for (var node : dijkstraGraph.getNodes()) {
            var neighbors = getNeighbours(node.getCoordinates(), n, m);
            for (var neighbor : neighbors) {
                dijkstraGraph.addNeighbour(node.getId(), dijkstraGraph.getNodeByCoordinates(neighbor));
            }
        }

        return dijkstraGraph;
    }

    private AStarGraph createAStarGraph(int n, int m) {
        AStarGraph dijkstraGraph = new AStarGraph();
        Coordinates coordinates;
        int id = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                coordinates = new Coordinates(j, i);
                dijkstraGraph.addNode(new AStarNode(Integer.toString(id), coordinates, 1));
                id++;
            }
        }

        for (var node : dijkstraGraph.getNodes()) {
            var neighbors = getNeighbours(node.getCoordinates(), n, m);
            for (var neighbor : neighbors) {
                dijkstraGraph.addNeighbour(node.getId(), dijkstraGraph.getNodeByCoordinates(neighbor));
            }
        }

        return dijkstraGraph;
    }

    private Graph createDijkstraGraph2(int n, int m) {
        Graph graph = createDijkstraGraph(n, m);

        int rock = 300;

        var node = ((DijkstraGraph) graph).getNodeByCoordinates(new Coordinates(0, 1));
//        node.setCost(rock);
//        node = ((DijkstraGraph) graph).getNodeByCoordinates(new Coordinates(1, 1));
//        node.setCost(rock);
//        node = ((DijkstraGraph) graph).getNodeByCoordinates(new Coordinates(2, 1));
//        node.setCost(rock);
//        node = ((DijkstraGraph) graph).getNodeByCoordinates(new Coordinates(3, 1));
//        node.setCost(rock);
//        node = ((DijkstraGraph) graph).getNodeByCoordinates(new Coordinates(4, 1));
//        node.setCost(2);

        return graph;
    }

    private Graph createAStarGraph1()
    {
        AStarGraph graph = createAStarGraph(3, 3);

        var node = graph.getNodeById("1");
        node.setCost(5);

        return graph;
    }

    private Graph createAStarGraph2(int n, int m) {
        Graph graph = createAStarGraph(n, m);

        int rock = 300;

        var node = ((AStarGraph) graph).getNodeByCoordinates(new Coordinates(17, 16));
        node.setCost(rock);
        node = ((AStarGraph) graph).getNodeByCoordinates(new Coordinates(16, 16));
        node.setCost(rock);
        node = ((AStarGraph) graph).getNodeByCoordinates(new Coordinates(16, 17));
        node.setCost(1);
//        node = ((AStarGraph) graph).getNodeByCoordinates(new Coordinates(1, 1));
//        node.setCost(rock);
//        node = ((AStarGraph) graph).getNodeByCoordinates(new Coordinates(2, 1));
//        node.setCost(rock);
//        node = ((AStarGraph) graph).getNodeByCoordinates(new Coordinates(3, 1));
//        node.setCost(rock);
//        node = ((AStarGraph) graph).getNodeByCoordinates(new Coordinates(4, 1));
//        node.setCost(2);

        return graph;
    }

    private void testDijkstra1() {
        Graph graph = createDijkstraGraph(3, 3);
        PathFinder pathFinder = DijkstraAlgorithmQueue.getInstance();

        var node = ((DijkstraGraph) graph).getNodeByCoordinates(new Coordinates(1, 1));
        node.setCost(10);
        node = ((DijkstraGraph) graph).getNodeByCoordinates(new Coordinates(2, 1));
        node.setCost(10);

        var path = pathFinder.findPath(graph, "0", "8");

        System.out.println(path);
    }

    private void testDijkstra2(Graph graph, PathFinder pathFinder, Coordinates targetCoordinates) {
        List<String> path = pathFinder.findPath(graph,
                "0",
                ((DijkstraGraph) graph).getNodeByCoordinates(targetCoordinates).getId());

        System.out.println(path);

        long pathLength = 0;
        for (var id : path) {
            pathLength += ((DijkstraGraph) graph).getNodeById(id).getCost();
        }
        System.out.println("Path length: " + pathLength);
    }

    private void testAStarGraph1(PathFinder pathFinder) {
        AStarGraph graph = createAStarGraph(3, 3);

        var node = graph.getNodeById("4");
        node.setCost(5);
        node = graph.getNodeById("5");
        node.setCost(5);

        var path = pathFinder.findPath(graph, "0", "8");

        System.out.println(path);
    }

    private void testAStarGraph2(Graph graph, PathFinder pathFinder, Coordinates targetCoordinates) {
        List<String> path = pathFinder.findPath(graph,
                "0",
                ((AStarGraph) graph).getNodeByCoordinates(targetCoordinates).getId());

        System.out.println(path);

        long pathLength = 0;
        for (var id : path) {
            pathLength += ((AStarGraph) graph).getNodeById(id).getCost();
        }
        System.out.println("Path length: " + pathLength);
    }

    public List<Coordinates> getNeighbours(Coordinates coordinates, int n, int m) {
        List<Coordinates> neighbors = new ArrayList<>();

        Coordinates tmpPosition = new Coordinates(coordinates.getX(), coordinates.getY() - 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() + 1, coordinates.getY() - 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() + 1, coordinates.getY());
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() + 1, coordinates.getY() + 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX(), coordinates.getY() + 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() - 1, coordinates.getY() + 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() - 1, coordinates.getY());
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() - 1, coordinates.getY() - 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        return neighbors;
    }

    private boolean isAccessible(Coordinates coordinates, int n, int m) {
        return checkOutOfField(coordinates, n, m);
    }

    private boolean checkOutOfField(Coordinates coordinates, int n, int m) {
        if (coordinates.getX() >= n ||
                coordinates.getX() < 0 ||
                coordinates.getY() >= m ||
                coordinates.getY() < 0)
            return false;
        else
            return true;
    }

}
