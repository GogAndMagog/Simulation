package org.simulation.model.entities;

import org.simulation.model.coordinates.*;

public abstract class Entity {

    protected Coordinates position;
    protected WorldMap worldMap;

    public Entity(Coordinates position) {
        this.position = position;
    }

    public Entity(Coordinates position, WorldMap worldMap) {
        this.position = position;
        this.worldMap = worldMap;
    }

    protected void setPosition(Coordinates position) {
        this.position = position;
    }

    public Coordinates getPosition() {
        return position;
    }

    public abstract String getIcon();

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }
}
