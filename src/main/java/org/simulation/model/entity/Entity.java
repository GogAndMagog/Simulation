package org.simulation.model.entity;

import org.simulation.service.graph.entity.Coordinates;

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
