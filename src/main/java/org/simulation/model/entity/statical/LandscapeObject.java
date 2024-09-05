package org.simulation.model.entity.statical;

import org.simulation.model.entity.Entity;
import org.simulation.model.entity.WorldMap;
import org.simulation.service.graph.entity.Coordinates;

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
