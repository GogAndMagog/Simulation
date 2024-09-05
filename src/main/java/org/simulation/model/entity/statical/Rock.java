package org.simulation.model.entity.statical;

import org.simulation.model.entity.Icons;
import org.simulation.model.entity.WorldMap;
import org.simulation.service.graph.entity.Coordinates;

public class Rock extends LandscapeObject {

    public Rock(Coordinates position) {
        super(position);
    }

    public Rock(Coordinates position, WorldMap worldMap) {
        super(position, worldMap);
    }

    @Override
    public String getIcon() {
        return Icons.ICON_ROCK;
    }
}
