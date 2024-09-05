package org.simulation.service.simulation.action;

import org.simulation.model.entity.WorldMap;
import org.simulation.model.entity.dynamic.Creature;
import org.simulation.model.entity.dynamic.CreatureStatus;

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
