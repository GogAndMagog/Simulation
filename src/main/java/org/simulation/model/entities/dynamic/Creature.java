package org.simulation.model.entities.dynamic;

import org.simulation.model.entities.Entity;
import org.simulation.model.entities.WorldMap;
import org.simulation.service.Graphs.Entities.Coordinates;
import org.simulation.service.Graphs.GraphFabric.GraphAbstractFabric;
import org.simulation.service.Graphs.PathFinder;

public abstract class Creature extends Entity {

    private final int actionPoints;
    private int hp;

    protected PathFinder pathFinder;
    protected GraphAbstractFabric graphAbstractFabric;

    public Creature(Coordinates position, int actionPoints, int hp) {
        super(position);
        this.actionPoints = actionPoints;
        this.hp = hp;
    }

    public Creature(Coordinates position, WorldMap worldMap, int actionPoints, int hp) {
        super(position, worldMap);
        this.actionPoints = actionPoints;
        this.hp = hp;
    }

    public abstract void makeMove();

    public int getActionPoints() {
        return actionPoints;
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
