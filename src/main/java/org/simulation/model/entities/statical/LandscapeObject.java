package org.simulation.model.entities.statical;

import org.simulation.model.coordinates.*;
import org.simulation.model.entities.Entity;
import org.simulation.model.entities.WorldMap;

public abstract class LandscapeObject extends Entity {
    public LandscapeObject(Coordinates position) {
        super(position);
    }

    public LandscapeObject(Coordinates position, WorldMap worldMap) {
        super(position);
    }

}
