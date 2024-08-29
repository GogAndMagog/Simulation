package org.simulation.model.entities.dynamic.herbivore;

import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.dynamic.Creature;
import org.simulation.model.entities.statical.LandscapeObject;
import org.simulation.model.entities.statical.LandscapeObjectStatus;
import org.simulation.service.Graphs.Entities.Coordinates;

public abstract class Herbivore extends Creature {
    public Herbivore(Coordinates position, int speed, int hp) {
        super(position, speed, hp);
    }

    public Herbivore(Coordinates position, WorldMap worldMap, int speed, int hp) {
        super(position, worldMap, speed, hp);
    }

    protected void eatHerb(LandscapeObject herb)
    {
        if (this.getPosition().equals(herb.getPosition()))
        {
            herb.setStatus(LandscapeObjectStatus.NOT_EXISTS);
        }
    }

}
