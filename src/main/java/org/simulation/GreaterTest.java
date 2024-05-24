package org.simulation;

import org.simulation.model.coordinates.*;
import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.dynamic.Creature;
import org.simulation.model.entities.dynamic.carnivore.Wolf;
import org.simulation.model.entities.statical.*;
import org.simulation.view.ConsoleRenderer;
import org.simulation.view.Renderer;

public class GreaterTest {
    public static void main(String[] args) {

        WorldMap worldMap = new WorldMap(3, 3);
        worldMap.setLandscapeObject(new Herb(new Coordinates(0, 0)));
        worldMap.setLandscapeObject(new Herb(new Coordinates(0, 1)));
        worldMap.setLandscapeObject(new Herb(new Coordinates(1, 0)));
        worldMap.setLandscapeObject(new Tree(new Coordinates(0, 2)));
        worldMap.setLandscapeObject(new Tree(new Coordinates(1, 2)));
        worldMap.setLandscapeObject(new Tree(new Coordinates(2, 2)));
//        worldMap.setLandscapeObject(new Herb(new Coordinates(1, 1)));
        worldMap.setCreature(new Wolf(new Coordinates(2, 0), 5, 10, 2));

        Renderer renderer = new ConsoleRenderer(worldMap);
        renderer.render();

        Creature wolf = worldMap.getCreatures().remove(new Coordinates(2, 0));
        wolf.makeMove();
        worldMap.setCreature(wolf);
        renderer.render();

    }

}
