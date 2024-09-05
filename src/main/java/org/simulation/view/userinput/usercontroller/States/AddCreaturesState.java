package org.simulation.view.UserInput.UserController.States;

import org.simulation.model.entities.dynamic.carnivore.Wolf;
import org.simulation.model.entities.dynamic.herbivore.Sheep;
import org.simulation.service.Graphs.Entities.Coordinates;
import org.simulation.view.UserInput.Dialog;
import org.simulation.view.UserInput.Screens.AddCreaturesScreen;
import org.simulation.view.UserInput.Screens.Screen;
import org.simulation.view.UserInput.UserController.UserControllerContext;

public class AddCreaturesState implements UserControllerState {

    UserControllerContext userControllerContext;

    AddCreaturesState(UserControllerContext userControllerContext) {
        this.userControllerContext = userControllerContext;
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
        return new AddCreaturesScreen(this.userControllerContext);
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
        userControllerContext.getSimulation().addCreature(Wolf.getWolf(coordinates));
        userControllerContext.getSimulation().renderMap();
        userControllerContext.showScreen();
    }

    @Override
    public void addSheep(Coordinates coordinates) {
        userControllerContext.getSimulation().addCreature(Sheep.getSheep(coordinates));
        userControllerContext.getSimulation().renderMap();
        userControllerContext.showScreen();
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
