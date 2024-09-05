package org.simulation.service.simulation.action;

import org.simulation.model.entity.WorldMap;
import org.simulation.model.entity.statical.LandscapeObject;
import org.simulation.model.entity.statical.LandscapeObjectStatus;

import java.util.ArrayList;
import java.util.List;

public class RemoveNotExistedLandscapeObjsAction implements WorldAction {
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
