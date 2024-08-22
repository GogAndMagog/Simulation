package org.simulation.model.entities.statical.terrain;

import org.simulation.model.entities.Icons;
import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.statical.LandscapeObject;
import org.simulation.service.Graphs.Entities.Coordinates;

public class Sand extends LandscapeObject implements Terrain {

    public static void main(String[] args) {
        var sand = new Sand(new Coordinates(0, 0));

        System.out.println(sand.getIcon());
    }

    public Sand(Coordinates position) {
        super(position);
    }

    public Sand(Coordinates position, WorldMap worldMap) {
        super(position, worldMap);
    }

    @Override
    public String getIcon() {
        return Icons.ANSI_YELLOW_BACKGROUND;
    }

    @Override
    public int getPassability() {
        return 5;
    }
}
