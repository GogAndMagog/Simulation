package org.simulation.service.Simulation.Actions;

import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.dynamic.carnivore.Wolf;
import org.simulation.model.entities.dynamic.herbivore.Sheep;
import org.simulation.model.entities.statical.terrain.Herb;
import org.simulation.model.entities.statical.terrain.Road;
import org.simulation.model.entities.statical.terrain.Sand;
import org.simulation.service.Graphs.Entities.Coordinates;

public class InitWorldMap implements WorldAction{
    @Override
    public void execute(WorldMap worldMap) {
        int n = 5;
        int m = 5;

        if (worldMap.getX() != n
        || worldMap.getY() != m)
            return;

        for (int i = 0; i < n-1; i++) {
            worldMap.setLandscapeObject(new Sand(new Coordinates(i, 2)));
        }

        for (int i = 0; i < n; i++) {
            worldMap.setLandscapeObject(new Herb(new Coordinates(i, 3)));
            worldMap.setLandscapeObject(new Herb(new Coordinates(i, 4)));
        }
        worldMap.setLandscapeObject(new Road(new Coordinates(0, 0)));
        for (int i = 0; i < n; i++) {
            worldMap.setLandscapeObject(new Road(new Coordinates(i, 1)));
        }
        worldMap.setLandscapeObject(new Road(new Coordinates(4, 2)));
        worldMap.setCreature(new Sheep(new Coordinates(0, 4), worldMap, 2, 10));
        worldMap.setCreature(new Wolf(new Coordinates(0, 0), worldMap, 3, 10, 3));
    }
}
