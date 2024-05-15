package org.simulation.model.entities.statical;

import org.simulation.model.coordinates.*;
import org.simulation.model.entities.WorldMap;

public class Tree extends LandscapeObject {

    private final String ICON = "\uD83C\uDF33";

    public Tree(Coordinates position) {
        super(position);
    }

    public Tree(Coordinates position, WorldMap worldMap) {
        super(position, worldMap);
    }

    @Override
    public String getIcon() {
        return ICON;
    }
}
