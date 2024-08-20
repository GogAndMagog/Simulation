package org.simulation.model.entities.statical;

import org.simulation.model.entities.Icons;
import org.simulation.model.entities.WorldMap;
import org.simulation.service.Graphs.Entities.Coordinates;

public class Tree extends LandscapeObject {

    public Tree(Coordinates position) {
        super(position);
    }

    public Tree(Coordinates position, WorldMap worldMap) {
        super(position, worldMap);
    }

    @Override
    public String getIcon() {
        return Icons.ICON_TREE;
    }
}
