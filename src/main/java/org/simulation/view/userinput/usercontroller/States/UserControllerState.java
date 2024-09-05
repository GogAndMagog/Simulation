package org.simulation.view.UserInput.UserController.States;

import org.simulation.service.Graphs.Entities.Coordinates;
import org.simulation.view.UserInput.Dialog;
import org.simulation.view.UserInput.Screens.Screen;

public interface UserControllerState {
    void Execute(int command);
    Dialog getMessage();
    public Screen getScreen();
    public void chooseMap();
    public void addCreatures();
    public void addLandscapeObj();
    public void makeSimulationMove();
    public void runSimulation();
    public void exit();
    public void chooseSandyWorld();
    public void chooseGreenWorld();
    public void chooseIndustrialWorld();
    public void addWolf(Coordinates coordinates);
    public void addSheep(Coordinates coordinates);
    public void addTerrain();
    public void addStaticObj();
    public void addHerb(Coordinates coordinates);
    public void addSand(Coordinates coordinates);
    public void addRoad(Coordinates coordinates);
    public void addRock(Coordinates coordinates);
    public void addTree(Coordinates coordinates);
    public void pauseSimulation();
    public void back();

}
