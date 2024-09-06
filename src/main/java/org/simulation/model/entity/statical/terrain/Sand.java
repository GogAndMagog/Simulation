package org.simulation.model.entity.statical.terrain;

import org.simulation.model.entity.Icons;
import org.simulation.model.entity.WorldMap;
import org.simulation.model.entity.statical.LandscapeObject;
import org.simulation.service.graph.entity.Coordinates;

public class Sand extends LandscapeObject implements Terrain {

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
