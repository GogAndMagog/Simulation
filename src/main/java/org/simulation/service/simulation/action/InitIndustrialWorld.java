package org.simulation.service.simulation.action;

import org.simulation.model.entity.WorldMap;
import org.simulation.model.entity.dynamic.Creature;
import org.simulation.model.entity.dynamic.carnivore.Wolf;
import org.simulation.model.entity.dynamic.herbivore.Sheep;
import org.simulation.model.entity.statical.Factory;
import org.simulation.model.entity.statical.Rock;
import org.simulation.model.entity.statical.terrain.Herb;
import org.simulation.model.entity.statical.terrain.Road;
import org.simulation.service.graph.entity.Coordinates;

public class InitIndustrialWorld implements WorldAction, InitWorldAction{
    @Override
    public void execute(WorldMap worldMap) {
        WorldMap industrialWorld = new WorldMap(15, 15);

        for (int x = 0; x < industrialWorld.getX(); x++) {
            industrialWorld.setLandscapeObject(new Road(new Coordinates(x, 0), industrialWorld));
            industrialWorld.setLandscapeObject(new Road(new Coordinates(x, 5), industrialWorld));
            industrialWorld.setLandscapeObject(new Road(new Coordinates(x, 10), industrialWorld));
        }
        for (int y = 0; y <= 10; y++) {
            industrialWorld.setLandscapeObject(new Road(new Coordinates(7, y), industrialWorld));
        }

        for (int x = 0; x < industrialWorld.getX(); x++) {
            if (x % 2 == 0) {
                industrialWorld.setLandscapeObject(new Herb(new Coordinates(x, 11), industrialWorld));
                industrialWorld.setLandscapeObject(new Herb(new Coordinates(x, 13), industrialWorld));
            }
            else{
                industrialWorld.setLandscapeObject(new Herb(new Coordinates(x, 12), industrialWorld));
                industrialWorld.setLandscapeObject(new Herb(new Coordinates(x, 14), industrialWorld));
            }
        }

        industrialWorld.setLandscapeObject(new Rock(new Coordinates(1, 2), industrialWorld));
        industrialWorld.setLandscapeObject(new Rock(new Coordinates(3, 1), industrialWorld));

        industrialWorld.setLandscapeObject(new Factory(new Coordinates(2, 7), industrialWorld));
        industrialWorld.setLandscapeObject(new Factory(new Coordinates(3, 7), industrialWorld));
        industrialWorld.setLandscapeObject(new Factory(new Coordinates(9, 2), industrialWorld));
        industrialWorld.setLandscapeObject(new Factory(new Coordinates(10, 8), industrialWorld));
        industrialWorld.setLandscapeObject(new Factory(new Coordinates(11, 7), industrialWorld));
        industrialWorld.setLandscapeObject(new Factory(new Coordinates(11, 8), industrialWorld));
        industrialWorld.setLandscapeObject(new Factory(new Coordinates(12, 8), industrialWorld));
        industrialWorld.setLandscapeObject(new Factory(new Coordinates(13, 2), industrialWorld));

        Creature creature = Wolf.getWolf(new Coordinates(0, 0));
        creature.setWorldMap(industrialWorld);
        industrialWorld.setCreature(creature);

        creature = Sheep.getSheep(new Coordinates(0, 14));
        creature.setWorldMap(industrialWorld);
        industrialWorld.setCreature(creature);

        creature = Sheep.getSheep(new Coordinates(14, 14));
        creature.setWorldMap(industrialWorld);
        industrialWorld.setCreature(creature);

        worldMap.setMap(industrialWorld);
    }
}
