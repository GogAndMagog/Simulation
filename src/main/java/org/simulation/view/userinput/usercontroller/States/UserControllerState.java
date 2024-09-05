package org.simulation.view.userinput.usercontroller.States;

import org.simulation.service.graph.entity.Coordinates;
import org.simulation.view.userinput.Dialog;
import org.simulation.view.userinput.screen.Screen;

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
