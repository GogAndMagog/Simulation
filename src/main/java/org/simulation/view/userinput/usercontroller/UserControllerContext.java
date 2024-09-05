package org.simulation.view.UserInput.UserController;

import org.simulation.service.Graphs.Entities.Coordinates;
import org.simulation.service.Simulation.AbstractSimulation;
import org.simulation.service.Simulation.Simulation;
import org.simulation.view.UserInput.UserController.States.UserControllerState;

public interface UserControllerContext {
    void changeState(UserControllerState state);
    void showScreen();
    AbstractSimulation getSimulation();
    void chooseMap();
    void addCreatures();
    void addLandscapeObj();
    void makeSimulationMove();
    void runSimulation();
    void exit();
    void chooseSandyWorld();
    void chooseGreenWorld();
    void chooseIndustrialWorld();
    void addWolf(Coordinates coordinates);
    void addSheep(Coordinates coordinates);
    void addTerrain();
    void addStaticObj();
    void addHerb(Coordinates coordinates);
    void addSand(Coordinates coordinates);
    void addRoad(Coordinates coordinates);
    void addRock(Coordinates coordinates);
    void addTree(Coordinates coordinates);
    void pauseSimulation();
    void back();
}
