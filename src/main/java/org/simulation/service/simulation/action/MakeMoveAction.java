package org.simulation.service.simulation.action;

import org.simulation.model.entity.WorldMap;
import org.simulation.model.entity.dynamic.Creature;

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