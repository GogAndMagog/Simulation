package org.simulation.model.entities.dynamic.carnivore;

import org.simulation.model.coordinates.Coordinates;
import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.dynamic.Creature;

public abstract class Carnivore extends Creature {
    public Carnivore(Coordinates position, int speed, int hp) {
        super(position, speed, hp);
    }

    public Carnivore(Coordinates position, WorldMap worldMap, int speed, int hp) {
        super(position, worldMap, speed, hp);
    }
}
