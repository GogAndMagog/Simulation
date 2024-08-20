package org.simulation.model.entities.statical;

import org.simulation.model.entities.Icons;
import org.simulation.model.entities.WorldMap;
import org.simulation.service.Graphs.Entities.Coordinates;

public class Sand extends LandscapeObject implements Terrain  {
    public Sand(Coordinates position) {
        super(position);
    }
    public Sand(Coordinates position, WorldMap worldMap) {
        super(position, worldMap);
    }
    @Override
    public String getIcon() {
        return Icons.ICON_HERB;
    }

    @Override
    public int getPassability() {
        return 5;
    }
}
