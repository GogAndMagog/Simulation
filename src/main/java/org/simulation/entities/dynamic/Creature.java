package org.simulation.entities.dynamic;

import org.simulation.entities.Coordinates;
import org.simulation.entities.Entity;
import org.simulation.entities.EntityType;

/**
 * Creature - is an abstraction on every live object on the map,
 */
public abstract class Creature extends Entity {
    /**
     * The number of cells that creature can pass.
     */
    private final int speed;
    /**
     * Health points.
     */
    private int hp;

    /**
     * Creates creature with set values.
     * @param position position of creature on the map.
     * @param speed number of cells that creature can pass.
     * @param hp health points of the creature.
     */
    public Creature(Coordinates position, int speed, int hp)
    {
        super(position, EntityType.DYNAMIC);
        this.speed = speed;
        this.hp = hp;
    }

    /**
     * Creature does what creature does. Must be realized in every child-class.
     */
    public abstract void makeMove();
}
