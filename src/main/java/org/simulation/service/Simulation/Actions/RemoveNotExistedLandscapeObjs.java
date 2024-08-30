package org.simulation.service.Simulation.Actions;

import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.dynamic.Creature;
import org.simulation.model.entities.dynamic.CreatureStatus;
import org.simulation.model.entities.statical.LandscapeObject;
import org.simulation.model.entities.statical.LandscapeObjectStatus;

import java.util.ArrayList;
import java.util.List;

public class RemoveNotExistedLandscapeObjs implements WorldAction {
    @Override
    public void execute(WorldMap worldMap) {
        List<LandscapeObject> landscapeObjects = new ArrayList<>(worldMap.getLandscape().values());
        landscapeObjects.forEach(landscapeObject -> {
            if (landscapeObject.getStatus().equals(LandscapeObjectStatus.NOT_EXISTS)) {
                worldMap.removeLandscapeObjet(landscapeObject.getPosition());
            }
        });
    }
}
