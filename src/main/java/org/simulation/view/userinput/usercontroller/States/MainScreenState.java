package org.simulation.view.userinput.usercontroller.States;

import org.simulation.service.graph.entity.Coordinates;
import org.simulation.view.userinput.screen.MainConsoleScreen;
import org.simulation.view.userinput.screen.Screen;
import org.simulation.view.userinput.usercontroller.UserControllerContext;

public class MainScreenState implements UserControllerState {

    UserControllerContext userControllerContext;
    Screen mainScreen;

    public MainScreenState(UserControllerContext userControllerContext) {
        this.userControllerContext = userControllerContext;
        mainScreen = new MainConsoleScreen(userControllerContext);
    }

    @Override
    public Screen getScreen() {
        return new MainConsoleScreen(this.userControllerContext);
    }

    @Override
    public void chooseMap() {
        userControllerContext.changeState(new MapChooseState(this.userControllerContext));
        userControllerContext.showScreen();
    }

    @Override
    public void addCreatures() {
        userControllerContext.changeState(new AddCreaturesState(this.userControllerContext));
        userControllerContext.showScreen();
    }

    @Override
    public void addLandscapeObj() {
        userControllerContext.changeState(new AddLandscapeObjectState(this.userControllerContext));
        userControllerContext.showScreen();
    }

    @Override
    public void makeSimulationMove() {
        try {
            userControllerContext.getSimulation().nextMove();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        userControllerContext.showScreen();
    }

    @Override
    public void runSimulation() {
        try {
            userControllerContext.getSimulation().startSimulation();
            userControllerContext.changeState(new SimulationInProcessState(userControllerContext));
            userControllerContext.showScreen();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            userControllerContext.showScreen();
        }
    }

    @Override
    public void exit() {
        System.exit(0);
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
    }

    @Override
    public void back() {
    }

}
