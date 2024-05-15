package org.simulation.model.entities;

import org.simulation.model.coordinates.Coordinates;
import org.simulation.model.entities.dynamic.Creature;
import org.simulation.model.entities.statical.LandscapeObject;

import java.util.*;

public class WorldMap {
    //Field size
    private int x;
    private int y;

    //Objects containers
    private HashMap<Coordinates, LandscapeObject> landscape = new HashMap<>();
    private HashMap<Coordinates, Creature> creatures = new HashMap<>();

    public WorldMap(int x, int y) {
        this.y = y;
        this.x = x;

//        for (int i = 0; i < x; i++) {
//            for (int j = 0; j < y; j++) {
//              landscape.put(new Coordinates(i, j), null);
//              creatures.put(new Coordinates(i, j), null);
//            }
//        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean setLandscapeObject(LandscapeObject object) {
        if (object.getPosition().getX() >= 0 && object.getPosition().getX() <= x
                && object.getPosition().getY() >= 0 && object.getPosition().getY() <= y) {
            landscape.put(object.getPosition(), object);
            return true;
        } else
            return false;
    }

    public boolean setCreature(Creature creature) {
        if (creature.getPosition().getX() >= 0 && creature.getPosition().getX() <= x
                && creature.getPosition().getY() >= 0 && creature.getPosition().getY() <= y) {
            creatures.put(creature.getPosition(), creature);
            return true;
        } else
            return false;
    }

    public Map<Coordinates, LandscapeObject> getLandscape() {
//        return Collections.unmodifiableMap(landscape);
        return landscape;
    }

    public Map<Coordinates, Creature> getCreatures() {
//        return Collections.unmodifiableMap(creatures);
        return creatures;
    }

}
