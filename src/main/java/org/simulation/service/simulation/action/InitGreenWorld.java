package org.simulation.service.simulation.action;

import org.simulation.model.entity.WorldMap;
import org.simulation.model.entity.dynamic.Creature;
import org.simulation.model.entity.dynamic.carnivore.Wolf;
import org.simulation.model.entity.dynamic.herbivore.Sheep;
import org.simulation.model.entity.statical.Rock;
import org.simulation.model.entity.statical.Tree;
import org.simulation.model.entity.statical.terrain.Herb;
import org.simulation.model.entity.statical.terrain.Road;
import org.simulation.service.graph.entity.Coordinates;

public class InitGreenWorld implements WorldAction, InitWorldAction {
    @Override
    public void execute(WorldMap worldMap) {

        WorldMap greenWorld = new WorldMap(14, 10);

        //Feel whole map with green
        for (int x = 0; x < greenWorld.getX(); x++) {
            for (int y = 0; y < greenWorld.getY(); y++) {
                greenWorld.setLandscapeObject(new Herb(new Coordinates(x, y), greenWorld));
            }
        }

        //Add road
        for (int x = 0; x <= 4; x++) {
            greenWorld.setLandscapeObject(new Road(new Coordinates(x, 7), greenWorld));
        }
        for (int y = 1; y <= 7; y++) {
            greenWorld.setLandscapeObject(new Road(new Coordinates(4, y), greenWorld));
        }
        for (int x = 5; x <= 13; x++) {
            greenWorld.setLandscapeObject(new Road(new Coordinates(x, 1), greenWorld));
        }

        //Add trees
        for (int x = 0; x <= 3; x++) {
            greenWorld.setLandscapeObject(new Tree(new Coordinates(x, 8), greenWorld));
        }
        for (int y = 1; y <= 5; y++) {
            greenWorld.setLandscapeObject(new Tree(new Coordinates(3, y), greenWorld));
        }
        for (int y = 2; y <= 7; y++) {
            greenWorld.setLandscapeObject(new Tree(new Coordinates(5, y), greenWorld));
        }
        for (int x = 7; x <= 13; x++) {
            if (x % 2 == 1) {
                greenWorld.setLandscapeObject(new Tree(new Coordinates(x, 2), greenWorld));
            }
        }

        //Add rocks
        greenWorld.setLandscapeObject(new Rock(new Coordinates(0, 1), greenWorld));
        greenWorld.setLandscapeObject(new Rock(new Coordinates(1, 0), greenWorld));
        greenWorld.setLandscapeObject(new Rock(new Coordinates(7, 5), greenWorld));
        greenWorld.setLandscapeObject(new Rock(new Coordinates(7, 9), greenWorld));
        greenWorld.setLandscapeObject(new Rock(new Coordinates(8, 4), greenWorld));
        greenWorld.setLandscapeObject(new Rock(new Coordinates(9, 4), greenWorld));
        greenWorld.setLandscapeObject(new Rock(new Coordinates(10, 5), greenWorld));
        greenWorld.setLandscapeObject(new Rock(new Coordinates(13, 9), greenWorld));

        Creature creature = Wolf.getWolf(new Coordinates(0, 0));
        creature.setWorldMap(greenWorld);
        greenWorld.setCreature(creature);

        creature = Sheep.getSheep(new Coordinates(12, 9));
        creature.setWorldMap(greenWorld);
        greenWorld.setCreature(creature);

        worldMap.setMap(greenWorld);
    }
}
