package org.simulation.service.simulation.action;

import org.simulation.model.entity.WorldMap;
import org.simulation.model.entity.dynamic.carnivore.Wolf;
import org.simulation.model.entity.dynamic.herbivore.Sheep;
import org.simulation.model.entity.statical.terrain.Herb;
import org.simulation.model.entity.statical.terrain.Road;
import org.simulation.model.entity.statical.terrain.Sand;
import org.simulation.service.graph.entity.Coordinates;

public class InitWorldMapAction implements WorldAction, InitWorldAction{
    @Override
    public void execute(WorldMap worldMap) {

        WorldMap newMap;

        int n = 5;
        int m = 5;

        newMap = new WorldMap(n, m);

        for (int i = 0; i < n-1; i++) {
            newMap.setLandscapeObject(new Sand(new Coordinates(i, 2)));
        }

        for (int i = 0; i < n; i++) {
            newMap.setLandscapeObject(new Herb(new Coordinates(i, 3)));
            newMap.setLandscapeObject(new Herb(new Coordinates(i, 4)));
        }
        newMap.setLandscapeObject(new Road(new Coordinates(0, 0)));
        for (int i = 0; i < n; i++) {
            newMap.setLandscapeObject(new Road(new Coordinates(i, 1)));
        }
        newMap.setLandscapeObject(new Road(new Coordinates(4, 2)));
        newMap.setCreature(new Sheep(new Coordinates(0, 4), newMap, 2, 10));
        newMap.setCreature(new Wolf(new Coordinates(0, 0), newMap, 3, 10, 3));

        worldMap.setMap(newMap);
    }
}
