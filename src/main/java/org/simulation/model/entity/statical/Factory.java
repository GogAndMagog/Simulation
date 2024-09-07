package org.simulation.model.entity.statical;

import org.simulation.model.entity.Icons;
import org.simulation.model.entity.WorldMap;
import org.simulation.service.graph.entity.Coordinates;

public class Factory extends LandscapeObject {

    public Factory(Coordinates position) {
        super(position);
    }

    public Factory(Coordinates position, WorldMap worldMap) {
        super(position, worldMap);
    }

    @Override
    public String getIcon() {
        return Icons.ICON_FACTORY;
    }
}
