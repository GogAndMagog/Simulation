package org.simulation.view.userinput.usercontroller;

import org.simulation.service.graph.entity.Coordinates;
import org.simulation.service.simulation.AbstractSimulation;
import org.simulation.service.simulation.Simulation;
import org.simulation.service.simulation.SimulationCommand;
import org.simulation.view.userinput.usercontroller.States.MainScreenState;
import org.simulation.view.userinput.usercontroller.States.UserControllerState;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class UserControllerConsoleController implements UserControllerContext {
    private UserControllerState state;

    private BlockingQueue<SimulationCommand> commandQueue = new LinkedBlockingQueue<SimulationCommand>();

    private AbstractSimulation simulation = new Simulation(commandQueue);

    public UserControllerConsoleController() {
        this.state = new MainScreenState(this);
    }

    @Override
    public void changeState(UserControllerState state) {
        this.state = state;
    }

    @Override
    public void showScreen() {
        state.getScreen().display();
    }

    @Override
    public void chooseMap() {
        state.chooseMap();
    }

    @Override
    public void addCreatures() {
        state.addCreatures();
    }

    @Override
    public void addLandscapeObj() {
        state.addLandscapeObj();
    }

    @Override
    public void makeSimulationMove() {
        state.makeSimulationMove();
    }

    @Override
    public void runSimulation() {
        state.runSimulation();
    }

    @Override
    public void exit() {
        state.exit();
    }

    @Override
    public void chooseSandyWorld() {
        state.chooseSandyWorld();
    }

    @Override
    public void chooseGreenWorld() {
        state.chooseGreenWorld();
    }

    @Override
    public void chooseIndustrialWorld() {
        state.chooseIndustrialWorld();
    }

    @Override
    public void addWolf(Coordinates coordinates) {
        state.addWolf(coordinates);
    }

    @Override
    public void addSheep(Coordinates coordinates) {
        state.addSheep(coordinates);
    }

    @Override
    public void addTerrain() {
        state.addTerrain();
    }

    @Override
    public void addStaticObj() {
        state.addStaticObj();
    }

    @Override
    public void addHerb(Coordinates coordinates) {
        state.addHerb(coordinates);
    }

    @Override
    public void addSand(Coordinates coordinates) {
        state.addSand(coordinates);
    }

    @Override
    public void addRoad(Coordinates coordinates) {
        state.addRoad(coordinates);
    }

    @Override
    public void addRock(Coordinates coordinates) {
        state.addRock(coordinates);
    }

    @Override
    public void addTree(Coordinates coordinates) {
        state.addTree(coordinates);
    }

    @Override
    public void pauseSimulation() {
        state.pauseSimulation();
    }

    @Override
    public AbstractSimulation getSimulation() {
        return this.simulation;
    }

    @Override
    public void back() {
        state.back();
    }

    public BlockingQueue<SimulationCommand> getCommandQueue() {
        return commandQueue;
    }
}
