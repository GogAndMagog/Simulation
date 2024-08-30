package org.simulation.service.Simulation;

import org.simulation.service.Simulation.Actions.WorldAction;

public interface AbstractSimulation {
    public void startSimulation();
    public void pauseSimulation();
    public void nextMove();
    public void setInitWorldAction(WorldAction action);
    public void setTurnWorldAction(WorldAction action);
}
