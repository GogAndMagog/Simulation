package org.simulation.model.entities.dynamic.herbivore;

import org.simulation.model.coordinates.Coordinates;
import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.dynamic.Creature;

public abstract class Herbivore extends Creature {
    public Herbivore(Coordinates position, int speed, int hp) {
        super(position, speed, hp);
    }

    public Herbivore(Coordinates position, WorldMap worldMap, int speed, int hp) {
        super(position, worldMap, speed, hp);
    }
}
