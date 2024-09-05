package org.simulation.service.Simulation.Actions;

import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.dynamic.Creature;
import org.simulation.model.entities.dynamic.CreatureStatus;

import java.util.ArrayList;
import java.util.List;

public class RemoveDeadCreaturesAction implements WorldAction {
    @Override
    public void execute(WorldMap worldMap) {
        List<Creature> creatures = new ArrayList<>(worldMap.getCreatures().values());
        creatures.forEach(creature -> {
            if (creature.getCreatureStatus().equals(CreatureStatus.DEAD)) {
                worldMap.removeCreature(creature.getPosition());
            }
        });
    }
}
