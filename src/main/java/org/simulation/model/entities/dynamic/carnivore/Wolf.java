package org.simulation.model.entities.dynamic.carnivore;

import com.sun.jdi.ClassType;
import org.simulation.model.coordinates.Coordinates;
import org.simulation.model.entities.Entity;
import org.simulation.model.entities.Icons;
import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.dynamic.Creature;
import org.simulation.model.entities.dynamic.herbivore.Herbivore;
import org.simulation.model.entities.statical.Herb;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wolf extends Carnivore {
    private int visionRange = 10;

    public static void main(String[] args) {
        Wolf wolf = new Wolf(new Coordinates(2, 2), 5, 1);

        WorldMap wp = new WorldMap(3, 3);

        wp.setCreature(wolf);
        wp.setCreature(new Wolf(new Coordinates(0, 0), 5, 1));
        wp.setCreature(new Wolf(new Coordinates(1, 0), 5, 1));

        wolf.chooseClosest(wolf.getDistancesToCreatures(wolf.getPosition(), wp, Wolf.class))
                .ifPresent(System.out::println);
//                .forEach((creature, aDouble) ->
//                {
//                    StringBuilder sb = new StringBuilder();
//                    sb.append("Creature: ")
//                            .append(creature.getIcon())
//                            .append(" Position: ")
//                            .append(creature.getPosition())
//                            .append(" Distance: ")
//                            .append(aDouble);
//                    System.out.println(sb);
//                });



//        Class className = Creature.class;
//        Class<Creature> classNameGeneric = Creature.class;
//
//        System.out.println(className.isInstance(wolf));
//
//        className = Carnivore.class;
//
//        System.out.println(className.isInstance(wolf));
//
//        className = Herbivore.class;
//
//        System.out.println(className.isInstance(wolf));

    }

    public Wolf(Coordinates position, int speed, int hp) {
        super(position, speed, hp);
    }

    public Wolf(Coordinates position, WorldMap worldMap, int speed, int hp) {
        super(position, worldMap, speed, hp);
    }

    @Override
    public void makeMove() {
        setPosition(new Coordinates(2, 1));

    }

    private Optional<Coordinates> chooseTarget() {
        var ableDirections = checkDirections(this.getPosition());

        return Optional.empty();
    }

    private Coordinates chooseRandomDirection() {
        return new Coordinates(0, 0);
    }

    @Override
    public String getIcon() {
        return Icons.ICON_WOLF;
    }
}
