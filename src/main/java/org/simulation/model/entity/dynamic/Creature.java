package org.simulation.model.entities.dynamic;

import org.simulation.model.entities.Entity;
import org.simulation.model.entities.WorldMap;
import org.simulation.service.graphs.Entities.Coordinates;
import org.simulation.service.graphs.GraphFabric.GraphAbstractFabric;
import org.simulation.service.graphs.PathFinder;
import org.simulation.service.Simulation.TargetIdentifier;
import org.simulation.service.Simulation.TargetIdentifierDistanceCalculatorImpl;

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

    //    private void die() {
//        worldMap.removeCreature(this.position);
//    }

}
