package org.simulation.model.entities.statical;

import org.simulation.model.entities.Entity;
import org.simulation.model.entities.WorldMap;
import org.simulation.service.graphs.Entities.Coordinates;

public abstract class LandscapeObject extends Entity {
    LandscapeObjectStatus status;

    public LandscapeObject(Coordinates position) {
        super(position);
        status = LandscapeObjectStatus.EXISTS;
    }

    public LandscapeObject(Coordinates position, WorldMap worldMap) {
        super(position);
        this.worldMap = worldMap;
        status = LandscapeObjectStatus.EXISTS;
    }

    public LandscapeObjectStatus getStatus() {
        return status;
    }

    public void setStatus(LandscapeObjectStatus status) {
        this.status = status;
    }
}
