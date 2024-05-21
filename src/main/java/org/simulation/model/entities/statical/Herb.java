package org.simulation.model.entities.statical;

import org.simulation.model.coordinates.*;
import org.simulation.model.entities.Icons;
import org.simulation.model.entities.WorldMap;


public class Herb extends LandscapeObject implements Terrain {

    public Herb(Coordinates position) {
        super(position);
    }
    public Herb(Coordinates position, WorldMap worldMap) {
        super(position, worldMap);
    }
    @Override
    public String getIcon() {
        return Icons.ICON_HERB;
    }

    @Override
    public int getPassability() {
        return 0;
    }
}
