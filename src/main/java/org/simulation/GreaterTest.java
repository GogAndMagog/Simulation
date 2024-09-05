package org.simulation;

import org.simulation.model.entity.WorldMap;
import org.simulation.model.entity.dynamic.Creature;
import org.simulation.model.entity.dynamic.carnivore.Wolf;
import org.simulation.model.entity.dynamic.herbivore.Sheep;
import org.simulation.model.entity.statical.*;
import org.simulation.model.entity.statical.terrain.Sand;
import org.simulation.service.graph.entity.Coordinates;
import org.simulation.service.graph.graphfabric.DijkstraGraphFabric;
import org.simulation.service.graph.graphfabric.GraphAbstractFabric;
import org.simulation.view.ConsoleRenderer;
import org.simulation.view.Renderer;

import java.util.HashSet;
import java.util.Set;

public class GreaterTest {
    public static void main(String[] args) {
        WorldMap worldMap = new WorldMap(8, 8);
//        worldMap.setLandscapeObject(new Herb(new Coordinates(0, 0)));
//        worldMap.setLandscapeObject(new Herb(new Coordinates(0, 1)));
//        worldMap.setLandscapeObject(new Herb(new Coordinates(1, 0)));
//        worldMap.setLandscapeObject(new Tree(new Coordinates(0, 2)));
        worldMap.setLandscapeObject(new Tree(new Coordinates(1, 2)));
        worldMap.setLandscapeObject(new Tree(new Coordinates(2, 2)));
        worldMap.setLandscapeObject(new Tree(new Coordinates(3, 2)));
        worldMap.setLandscapeObject(new Sand(new Coordinates(4, 2)));
//        worldMap.setLandscapeObject(new Tree(new Coordinates(4, 2)));
        worldMap.setLandscapeObject(new Tree(new Coordinates(5, 2)));
        worldMap.setLandscapeObject(new Tree(new Coordinates(6, 2)));
//        worldMap.setLandscapeObject(new Tree(new Coordinates(7, 2)));
//        worldMap.setLandscapeObject(new Herb(new Coordinates(1, 1)));
        worldMap.setCreature(new Wolf(new Coordinates(7, 7), 5, 10, 2));
        worldMap.setCreature(new Wolf(new Coordinates(7, 6), 5, 10, 2));
        worldMap.setCreature(new Sheep(new Coordinates(0, 0), 5, 5));
//        worldMap.setCreature(new Sheep(new Coordinates(0, 7), 5, 5));

        Renderer renderer = new ConsoleRenderer(worldMap);
        renderer.render();
        int iterations = 4;

//        makeMove(worldMap, renderer, iterations);

        GraphAbstractFabric graphFabric =  DijkstraGraphFabric.getInstance();
        var graph = graphFabric.createGraph(worldMap);
        System.out.println(graph);

    }

    static void makeMove(WorldMap worldMap, Renderer renderer, int iterations) {
        Set<Creature> tmpCreatures = new HashSet<>();
        for (int i = 0; i < iterations; i++) {
            tmpCreatures.clear();
            tmpCreatures.addAll(worldMap.getCreatures().values());
            tmpCreatures.stream()
                    .filter(Wolf.class::isInstance)
                    .forEach(Creature::makeMove);
            renderer.render();
        }
    }

}
