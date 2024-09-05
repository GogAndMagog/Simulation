package org.simulation.model.entity.statical.terrain;

import org.simulation.model.entity.Icons;
import org.simulation.model.entity.WorldMap;
import org.simulation.model.entity.statical.LandscapeObject;
import org.simulation.service.graph.entity.Coordinates;

public class Road extends LandscapeObject implements Terrain{

    public static void main(String[] args) {
        var road = new Road(new Coordinates(0,0));

        System.out.println(road.getIcon());
    }

    public Road(Coordinates position) {
        super(position);
    }

    public Road(Coordinates position, WorldMap worldMap) {
        super(position, worldMap);
    }

    @Override
    public String getIcon() {
        return Icons.ANSI_GRAY_BACKGROUND;
    }

    @Override
    public int getPassability() {
        return 1;
    }
}
