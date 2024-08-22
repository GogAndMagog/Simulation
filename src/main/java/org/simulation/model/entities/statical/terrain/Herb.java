package org.simulation.model.entities.statical.terrain;

import org.simulation.model.entities.Icons;
import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.statical.LandscapeObject;
import org.simulation.service.Graphs.Entities.Coordinates;


public class Herb extends LandscapeObject implements Terrain {

    public Herb(Coordinates position) {
        super(position);
    }
    public Herb(Coordinates position, WorldMap worldMap) {
        super(position, worldMap);
    }
    @Override
    public String getIcon() {
        return Icons.ANSI_GREEN_BACKGROUND;
    }

    @Override
    public int getPassability() {
        return 1;
    }
}
