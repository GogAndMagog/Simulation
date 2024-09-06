package org.simulation.model.entity.statical.terrain;

import org.simulation.model.entity.Icons;
import org.simulation.model.entity.WorldMap;
import org.simulation.model.entity.statical.LandscapeObject;
import org.simulation.service.graph.entity.Coordinates;

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
