package org.simulation.view.UserInput.UserController.States;

import org.simulation.model.entities.dynamic.carnivore.Wolf;
import org.simulation.service.Graphs.Entities.Coordinates;
import org.simulation.service.Simulation.Actions.InitWorldAction;
import org.simulation.service.Simulation.Actions.InitWorldMap;
import org.simulation.view.UserInput.Dialog;
import org.simulation.view.UserInput.Screens.MainConsoleScreen;
import org.simulation.view.UserInput.Screens.MapChooseScreen;
import org.simulation.view.UserInput.Screens.Screen;
import org.simulation.view.UserInput.UserController.UserControllerContext;

public class MapChooseState implements UserControllerState {

    UserControllerContext userControllerContext;
    Screen mapChooseScreen;

    public MapChooseState(UserControllerContext userControllerContext) {
        this.userControllerContext = userControllerContext;
        mapChooseScreen = new MapChooseScreen(userControllerContext);
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
        return new MapChooseScreen(this.userControllerContext);
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
        userControllerContext.getSimulation().setInitWorldAction(new InitWorldMap());
    }

    @Override
    public void chooseGreenWorld() {
        userControllerContext.getSimulation().setInitWorldAction(new InitWorldMap());
    }

    @Override
    public void chooseIndustrialWorld() {
        userControllerContext.getSimulation().setInitWorldAction(new InitWorldMap());
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
        userControllerContext.changeState(new MainScreenState(this.userControllerContext));
        userControllerContext.showScreen();
    }
}
