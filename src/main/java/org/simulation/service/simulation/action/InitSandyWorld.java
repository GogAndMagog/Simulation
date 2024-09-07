package org.simulation.service.simulation.action;

import org.simulation.model.entity.WorldMap;
import org.simulation.model.entity.dynamic.Creature;
import org.simulation.model.entity.dynamic.carnivore.Wolf;
import org.simulation.model.entity.dynamic.herbivore.Sheep;
import org.simulation.model.entity.statical.Rock;
import org.simulation.model.entity.statical.Tree;
import org.simulation.model.entity.statical.terrain.Herb;
import org.simulation.model.entity.statical.terrain.Road;
import org.simulation.model.entity.statical.terrain.Sand;
import org.simulation.service.graph.entity.Coordinates;

public class InitSandyWorld implements WorldAction, InitWorldAction {
    @Override
    public void execute(WorldMap worldMap) {
        WorldMap sandyWorldMap = new WorldMap(10, 10);

        for (int x = 0; x < sandyWorldMap.getX(); x++) {
            for (int y = 0; y < sandyWorldMap.getY(); y++) {
                sandyWorldMap.setLandscapeObject(new Sand(new Coordinates(x, y), sandyWorldMap));
            }
        }

        for (int x = 0; x < sandyWorldMap.getX(); x++) {
            sandyWorldMap.setLandscapeObject(new Road(new Coordinates(x, 4), sandyWorldMap));
        }

        for (int y = 0; y < sandyWorldMap.getY(); y++) {
            sandyWorldMap.setLandscapeObject(new Road(new Coordinates(4, y), sandyWorldMap));
        }

        for (int x = 6; x < sandyWorldMap.getX(); x++) {
            for (int y = 6; y < sandyWorldMap.getY(); y++) {
                sandyWorldMap.setLandscapeObject(new Herb(new Coordinates(x, y), sandyWorldMap));
            }
        }

        sandyWorldMap.setLandscapeObject(new Road(new Coordinates(9, 5), sandyWorldMap));

        sandyWorldMap.setLandscapeObject(new Rock(new Coordinates(0, 9), sandyWorldMap));
        sandyWorldMap.setLandscapeObject(new Rock(new Coordinates(3, 0), sandyWorldMap));
        sandyWorldMap.setLandscapeObject(new Rock(new Coordinates(3, 1), sandyWorldMap));
        sandyWorldMap.setLandscapeObject(new Rock(new Coordinates(6, 2), sandyWorldMap));
        sandyWorldMap.setLandscapeObject(new Rock(new Coordinates(7, 1), sandyWorldMap));
        sandyWorldMap.setLandscapeObject(new Rock(new Coordinates(8, 2), sandyWorldMap));

        sandyWorldMap.setLandscapeObject(new Tree(new Coordinates(6, 8), sandyWorldMap));
        sandyWorldMap.setLandscapeObject(new Tree(new Coordinates(9, 7), sandyWorldMap));

        Creature creature = Wolf.getWolf(new Coordinates(0, 0));
        creature.setWorldMap(sandyWorldMap);
        sandyWorldMap.setCreature(creature);

        creature = Sheep.getSheep(new Coordinates(4, 9));
        creature.setWorldMap(sandyWorldMap);
        sandyWorldMap.setCreature(creature);

        worldMap.setMap(sandyWorldMap);
    }
}
