package org.simulation.service.simulation;

import org.simulation.model.entity.WorldMap;
import org.simulation.model.entity.dynamic.Creature;
import org.simulation.model.entity.statical.LandscapeObject;
import org.simulation.service.simulation.action.WorldAction;

public interface AbstractSimulation {
    void startSimulation();
    void pauseSimulation();
    void nextMove();
    void setInitWorldAction(WorldAction action);
    void setTurnWorldAction(WorldAction action);
    void setMap(WorldMap worldMap);
    void addCreature(Creature creature);
    void addLandscapeObject(LandscapeObject landscapeObject);
    void renderMap();
}
