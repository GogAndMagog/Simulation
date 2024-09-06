package org.simulation.model.entity.dynamic;

import org.simulation.model.entity.Entity;
import org.simulation.model.entity.WorldMap;
import org.simulation.service.graph.entity.Coordinates;
import org.simulation.service.graph.graphfabric.GraphAbstractFabric;
import org.simulation.service.graph.PathFinder;
import org.simulation.service.simulation.TargetIdentifier;
import org.simulation.service.simulation.TargetIdentifierDistanceCalculatorImpl;

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
        this.targetIdentifier = TargetIdentifierDistanceCalculatorImpl.getInstance();
    }

    public Creature(Coordinates position, WorldMap worldMap, int actionPoints, int hp) {
        super(position, worldMap);
        this.actionPoints = actionPoints;
        this.hp = hp;
        creatureStatus = CreatureStatus.ALIVE;
        this.targetIdentifier = TargetIdentifierDistanceCalculatorImpl.getInstance();
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

    public CreatureStatus getCreatureStatus() {
        return creatureStatus;
    }

    protected boolean filterDeadCreatures(Entity entity) {
        return !(entity instanceof Creature)
                || !((Creature) entity).getCreatureStatus().equals(CreatureStatus.DEAD);
    }

    protected boolean filterCreaturesOnTheGround(Entity entity) {
        if (this.worldMap == null)
            return false;

        if (this.worldMap.getCreatures().containsKey(entity.getPosition())) {
            return this.worldMap.getCreatures().get(entity.getPosition()).equals(this);
        } else {
            return true;
        }
    }
}
