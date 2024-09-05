package org.simulation.view.userinput.usercontroller;

import org.simulation.service.graph.entity.Coordinates;
import org.simulation.service.simulation.AbstractSimulation;
import org.simulation.service.simulation.SimulationCommand;
import org.simulation.view.userinput.usercontroller.States.UserControllerState;

import java.util.concurrent.BlockingQueue;

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
    BlockingQueue<SimulationCommand> getCommandQueue();
}
