package org.simulation.model.entities.dynamic;

import org.simulation.model.entities.Entity;
import org.simulation.model.entities.WorldMap;
import org.simulation.service.Graphs.Entities.Coordinates;
import org.simulation.service.PathFinder.PathFinder;

public abstract class Creature extends Entity {

    private final int speed;
    private int hp;
    protected PathFinder pathFinder;

    public Creature(Coordinates position, int speed, int hp) {
        super(position);
        this.speed = speed;
        this.hp = hp;
    }

    public Creature(Coordinates position, WorldMap worldMap, int speed, int hp) {
        super(position, worldMap);
        this.speed = speed;
        this.hp = hp;
    }

    public abstract void makeMove();

    public int getSpeed() {
        return speed;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            this.die();
        }
    }

    private void die() {
        worldMap.removeCreature(this.position);
    }

}
