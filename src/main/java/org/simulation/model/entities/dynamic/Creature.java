package org.simulation.model.entities.dynamic;

import org.simulation.model.coordinates.*;
import org.simulation.model.entities.Entity;
import org.simulation.model.entities.WorldMap;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Creature extends Entity {

    private final int speed;
    private int hp;

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

    protected List<Directions> checkDirections(Coordinates position) {
        List<Directions> ableDirections = new ArrayList<>();
        for (Directions direction : Directions.values()) {
            switch (direction) {
                case TOP -> {
                    if (canGoTop(position))
                        ableDirections.add(direction);
                }
                case TOP_RIGHT -> {
                    if (canGoTop(position) && canGoRight(position))
                        ableDirections.add(direction);
                }
                case RIGHT -> {
                    if (canGoRight(position))
                        ableDirections.add(direction);
                }
                case BOTTOM_RIGHT -> {
                    if (canGoBottom(position) && canGoRight(position))
                        ableDirections.add(direction);
                }
                case BOTTOM -> {
                    if (canGoBottom(position))
                        ableDirections.add(direction);
                }
                case BOTTOM_LEFT -> {
                    if (canGoBottom(position) && canGoLeft(position))
                        ableDirections.add(direction);
                }
                case LEFT -> {
                    if (canGoLeft(position))
                        ableDirections.add(direction);
                }
                case TOP_LEFT -> {
                    if (canGoTop(position) && canGoLeft(position))
                        ableDirections.add(direction);
                }
            }
        }

        return ableDirections;
    }

    private boolean canGoTop(Coordinates position) {
        return position.getY() - 1 >= 0;
    }

    private boolean canGoRight(Coordinates position) {
        return position.getX() + 1 <= worldMap.getX();
    }

    private boolean canGoBottom(Coordinates position) {
        return position.getY() + 1 <= worldMap.getY();
    }

    private boolean canGoLeft(Coordinates position) {
        return position.getX() - 1 >= 0;
    }

    protected double getLength(Coordinates current, Coordinates target) {
        double length = 0.0;
        length = Math.sqrt(Math.pow((current.getX() - target.getX()), 2)
                + Math.pow((current.getY() - target.getY()), 2));

        return length;
    }

    protected Map<Creature, Double> getDistancesToCreatures(Coordinates currentPosition, WorldMap worldMap, Class className) {
        Map<Creature, Double> creaturesDistances = new HashMap<>();

        worldMap.getCreatures().values().stream()
                .filter(className::isInstance)
                .filter(creature -> creature.getPosition() != currentPosition)
                .forEach(creature -> creaturesDistances.put(creature, getLength(currentPosition, creature.getPosition())));

        return creaturesDistances;
    }

    protected Optional<Coordinates> chooseClosest(Map<Creature, Double> creaturesDistances) {
        //AtomicReference<Coordinates> closest = new AtomicReference<>();
        return creaturesDistances
                .entrySet()
                .stream().min(Comparator.comparingDouble(Map.Entry::getValue))
//                .stream().mapToDouble(value -> value.getValue());
                .map(creature -> creature.getKey().getPosition());
    }
}
