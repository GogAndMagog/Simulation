package org.simulation.view.userinput.usercontroller.States;

import org.simulation.model.entity.dynamic.carnivore.Wolf;
import org.simulation.model.entity.dynamic.herbivore.Sheep;
import org.simulation.service.graph.entity.Coordinates;
import org.simulation.view.userinput.screen.AddCreaturesScreen;
import org.simulation.view.userinput.screen.Screen;
import org.simulation.view.userinput.usercontroller.UserControllerContext;

public class AddCreaturesState implements UserControllerState {

    UserControllerContext userControllerContext;

    AddCreaturesState(UserControllerContext userControllerContext) {
        this.userControllerContext = userControllerContext;
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
