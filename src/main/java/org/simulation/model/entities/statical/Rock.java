package org.simulation.model.entities.statical;

import org.simulation.model.coordinates.*;
import org.simulation.model.entities.WorldMap;

public class Rock extends LandscapeObject {

    private final String ICON = "\u26F0\uFE0F";

    public Rock(Coordinates position) {
        super(position);
    }

    public Rock(Coordinates position, WorldMap worldMap) {
        super(position, worldMap);
    }

    @Override
    public String getIcon() {
        return ICON;
    }
}
