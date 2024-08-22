package org.simulation.model.entities.dynamic.carnivore;

import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.dynamic.Creature;
import org.simulation.service.Graphs.Entities.Coordinates;

public abstract class Carnivore extends Creature {
    private int attack;

    public Carnivore(Coordinates position, int speed, int hp, int attack) {
        super(position, speed, hp);
        this.attack = attack;
    }

    public Carnivore(Coordinates position, WorldMap worldMap, int speed, int hp, int attack) {
        super(position, worldMap, speed, hp);
        this.attack = attack;
    }

    protected void attack(Creature creature) {
        //if target close enough able to attack
        if (Math.abs(this.getPosition().getX() - creature.getPosition().getX()) <= 1
                && Math.abs(this.getPosition().getY() - creature.getPosition().getY()) <= 1) {
            creature.takeDamage(this.attack);
        }
    }
}
