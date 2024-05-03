package org.simulation.entities;

/**
 * An abstraction that represents any basic object on the map
 */
public abstract class Entity {
    /**
     * Entity current position.
     */
    private Coordinates position;
    /**
     * Type of entity.
     */
    private final EntityType type;

    /**
     * Creates entity with set position and type.
     * @param position position on the map.
     * @param type type of the entity.
     */
    public Entity(Coordinates position, EntityType type)
    {
        this.position = position;
        this.type = type;
    }

    /**
     * Getter for position.
     * @return current position.
     */
    public Coordinates getPosition() {
        return position;
    }

    /**
     * Getter for entity type.
     * @return entity type.
     */
    public EntityType getType() {
        return type;
    }
}
