package org.simulation.model.entity.statical;

import org.simulation.model.entity.Icons;
import org.simulation.model.entity.WorldMap;
import org.simulation.service.graph.entity.Coordinates;

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
