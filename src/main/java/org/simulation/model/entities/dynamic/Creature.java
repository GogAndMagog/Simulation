package org.simulation.model.entities.dynamic;

import org.simulation.model.entities.Entity;
import org.simulation.model.entities.WorldMap;
import org.simulation.service.Graphs.Entities.Coordinates;
import org.simulation.service.Graphs.GraphFabric.GraphAbstractFabric;
import org.simulation.service.Graphs.PathFinder;
import org.simulation.service.Simulation.TargetIdentifier;

public abstract class Creature extends Entity {

    private final int actionPoints;
    private int hp;
    private CreatureStatus creatureStatus;

    protected PathFinder pathFinder;
    protected GraphAbstractFabric graphAbstractFabric;
    protected TargetIdentifier targetIdentifier;

    public Creature(Coordinates position, int actionPoints, int hp) {
        super(position);
        this.actionPoints = actionPoints;
        this.hp = hp;
        creatureStatus = CreatureStatus.ALIVE;
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
            creatureStatus = CreatureStatus.DEAD;
        }
    }

//    private void die() {
//        worldMap.removeCreature(this.position);
//    }

}
