package org.simulation.view.userinput.usercontroller.States;

import org.simulation.service.graph.entity.Coordinates;
import org.simulation.service.simulation.SimulationCommand;
import org.simulation.view.userinput.Dialog;
import org.simulation.view.userinput.screen.InterruptSimulationScreen;
import org.simulation.view.userinput.screen.Screen;
import org.simulation.view.userinput.usercontroller.UserControllerContext;

public class SimulationInProcessState implements UserControllerState {
    UserControllerContext userControllerContext;
    Screen screen;

    public SimulationInProcessState(UserControllerContext userControllerContext) {
        this.userControllerContext = userControllerContext;
        screen = new InterruptSimulationScreen(userControllerContext);
    }

    @Override
    public void Execute(int command) {

    }

    @Override
    public Dialog getMessage() {
        return null;
    }

    @Override
    public Screen getScreen() {
        return screen;
    }

    @Override
    public void chooseMap() {

    }

    @Override
    public void addCreatures() {

    }

    @Override
    public void addLandscapeObj() {

    }

    @Override
    public void makeSimulationMove() {

    }

    @Override
    public void runSimulation() {

    }

    @Override
    public void exit() {

    }

    @Override
    public void chooseSandyWorld() {

    }

    @Override
    public void chooseGreenWorld() {

    }

    @Override
    public void chooseIndustrialWorld() {

    }

    @Override
    public void addWolf(Coordinates coordinates) {

    }

    @Override
    public void addSheep(Coordinates coordinates) {

    }

    @Override
    public void addTerrain() {

    }

    @Override
    public void addStaticObj() {

    }

    @Override
    public void addHerb(Coordinates coordinates) {

    }

    @Override
    public void addSand(Coordinates coordinates) {

    }

    @Override
    public void addRoad(Coordinates coordinates) {

    }

    @Override
    public void addRock(Coordinates coordinates) {

    }

    @Override
    public void addTree(Coordinates coordinates) {

    }

    @Override
    public void pauseSimulation() {
        userControllerContext.getSimulation().pauseSimulation();
        userControllerContext.changeState(new MainScreenState(userControllerContext));
        userControllerContext.showScreen();
//        var commandQueue = userControllerContext.getCommandQueue();
//        try {
//            commandQueue.put(SimulationCommand.STOP_SIMULATION);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void back() {

    }
}
