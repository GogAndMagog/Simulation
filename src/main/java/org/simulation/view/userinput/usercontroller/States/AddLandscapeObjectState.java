package org.simulation.view.userinput.usercontroller.States;

import org.simulation.service.graph.entity.Coordinates;
import org.simulation.view.userinput.screen.AddLandscapeObjectsScreen;
import org.simulation.view.userinput.screen.Screen;
import org.simulation.view.userinput.usercontroller.UserControllerContext;

public class AddLandscapeObjectState implements UserControllerState{

    UserControllerContext userControllerContext;

    public AddLandscapeObjectState(UserControllerContext userControllerContext) {
        this.userControllerContext = userControllerContext;
    }

    @Override
    public Screen getScreen() {
        return new AddLandscapeObjectsScreen(userControllerContext);
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
        userControllerContext.changeState(new AddTerrainSate(userControllerContext));
        userControllerContext.showScreen();
    }

    @Override
    public void addStaticObj() {
        userControllerContext.changeState(new AddStaticObject(userControllerContext));
        userControllerContext.showScreen();
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
        userControllerContext.changeState(new MainScreenState(userControllerContext));
        userControllerContext.showScreen();
    }
}
