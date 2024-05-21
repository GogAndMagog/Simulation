package org.simulation.model.entities.statical;

import org.simulation.model.coordinates.*;
import org.simulation.model.entities.Icons;
import org.simulation.model.entities.WorldMap;

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
