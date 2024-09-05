package org.simulation.model.entity;

import org.simulation.model.entity.dynamic.Creature;
import org.simulation.model.entity.statical.LandscapeObject;
import org.simulation.service.graph.entity.Coordinates;

import java.util.*;

public class WorldMap {
    private int x;
    private int y;

    private HashMap<Coordinates, LandscapeObject> landscape = new HashMap<>();
    private HashMap<Coordinates, Creature> creatures = new HashMap<>();

    public WorldMap(int x, int y) {
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setLandscapeObject(LandscapeObject object) {
        if (checkOutOfField(object.getPosition())) {
            landscape.put(object.getPosition(), object);
            object.setWorldMap(this);
        }
        else
            throw new IllegalArgumentException("""
                    Размер поля: %d %d
                    """.formatted(this.getX(), this.getY()));
    }

    public void setCreature(Creature creature) {
        if (checkOutOfField(creature.getPosition())) {
            creatures.put(creature.getPosition(), creature);
            creature.setWorldMap(this);
        }
        else
            throw new IllegalArgumentException("""
                    Размер поля: %d %d
                    """.formatted(this.getX(), this.getY()));
    }

    public HashMap<Coordinates, LandscapeObject> getLandscape() {
        return landscape;
    }

    public HashMap<Coordinates, Creature> getCreatures() {
        return creatures;
    }

    public void removeCreature(Coordinates position) {
        creatures.remove(position);
    }

    public void removeLandscapeObjet(Coordinates position) {
        landscape.remove(position);
    }

    public List<Coordinates> getNeighbours(Coordinates coordinates, Coordinates target) {
        List<Coordinates> neighbors = new ArrayList<>();

        Coordinates tmpPosition = new Coordinates(coordinates.getX(), coordinates.getY() - 1);
        if (isAccessible(tmpPosition, target))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() + 1, coordinates.getY() - 1);
        if (isAccessible(tmpPosition, target))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() + 1, coordinates.getY());
        if (isAccessible(tmpPosition, target))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() + 1, coordinates.getY() + 1);
        if (isAccessible(tmpPosition, target))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX(), coordinates.getY() + 1);
        if (isAccessible(tmpPosition, target))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() - 1, coordinates.getY() + 1);
        if (isAccessible(tmpPosition, target))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() - 1, coordinates.getY());
        if (isAccessible(tmpPosition, target))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() - 1, coordinates.getY() - 1);
        if (isAccessible(tmpPosition, target))
            neighbors.add(tmpPosition);

        return neighbors;
    }

    private boolean isAccessible(Coordinates coordinates, Coordinates target) {
        return checkOutOfField(coordinates);
    }

    private boolean checkOutOfField(Coordinates coordinates) {
        if (coordinates.getX() >= x ||
                coordinates.getX() < 0 ||
                coordinates.getY() >= y ||
                coordinates.getY() < 0)
            return false;
        else
            return true;
    }

    public void setMap(WorldMap worldMap)
    {
        this.x = worldMap.getX();
        this.y = worldMap.getY();
        this.landscape = worldMap.getLandscape();
        this.creatures = worldMap.getCreatures();
    }
}
