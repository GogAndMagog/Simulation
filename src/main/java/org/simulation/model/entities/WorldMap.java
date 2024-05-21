package org.simulation.model.entities;

import org.simulation.model.coordinates.Coordinates;
import org.simulation.model.entities.dynamic.Creature;
import org.simulation.model.entities.searchstructs.Node;
import org.simulation.model.entities.statical.LandscapeObject;
import org.simulation.model.entities.statical.Terrain;

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

    public boolean setLandscapeObject(LandscapeObject object) {
        if (checkOutOfField(object.getPosition())) {
            landscape.put(object.getPosition(), object);
            return true;
        } else
            return false;
    }

    public boolean setCreature(Creature creature) {
        if (checkOutOfField(creature.getPosition())) {
            creatures.put(creature.getPosition(), creature);
            return true;
        } else
            return false;
    }

    public Map<Coordinates, LandscapeObject> getLandscape() {
        return landscape;
    }

    public Map<Coordinates, Creature> getCreatures() {
        return creatures;
    }

    public List<Coordinates> getNeighbours(Coordinates coordinates, Coordinates target) {
        List<Coordinates> neighbors = new ArrayList<>();

        Coordinates tmpPosition = new Coordinates(coordinates.getX(), coordinates.getY() - 1);
        if (isAccessible(tmpPosition, target))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() + 1, coordinates.getY() - 1);
        if (isAccessible(tmpPosition,target))
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
        return checkOutOfField(coordinates) &&
                checkObstacles(coordinates, target);
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

    private boolean checkObstacles(Coordinates coordinates, Coordinates target) {

        if (coordinates != null && coordinates.equals(target))
            return true;

        if (landscape.get(coordinates) != null && !(landscape.get(coordinates) instanceof Terrain))
            return false;

        if (creatures.get(coordinates) != null)
            return false;

        return true;
    }

    public int getPassability(Coordinates coordinates) {
        LandscapeObject landscapeObject = landscape.get(coordinates);

        if (landscapeObject != null && landscapeObject instanceof Terrain)
            return ((Terrain) landscapeObject).getPassability() + 1;
        else
            return 1;
    }

}
