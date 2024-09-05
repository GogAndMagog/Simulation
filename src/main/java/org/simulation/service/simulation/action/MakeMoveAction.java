package org.simulation.service.Simulation.Actions;

import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.dynamic.Creature;

import java.util.*;

public class MakeMoveAction implements WorldAction{

    @Override
    public void execute(WorldMap worldMap) {
        List<Creature> creatures = new ArrayList<>(worldMap.getCreatures().values());

        for (Creature creature : creatures) {
            worldMap.removeCreature(creature.getPosition());
            creature.makeMove();
            worldMap.setCreature(creature);
        }
    }
}