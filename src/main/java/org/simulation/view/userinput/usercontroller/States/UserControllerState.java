package org.simulation.view.userinput.usercontroller.States;

import org.simulation.service.graph.entity.Coordinates;
import org.simulation.view.userinput.screen.Screen;

public interface UserControllerState {
    Screen getScreen();
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
    void addFactory(Coordinates coordinates);
    void pauseSimulation();
    void back();
}
