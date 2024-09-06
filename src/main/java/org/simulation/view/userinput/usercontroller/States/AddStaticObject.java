package org.simulation.view.userinput.usercontroller.States;

import org.simulation.model.entity.statical.Rock;
import org.simulation.model.entity.statical.Tree;
import org.simulation.service.graph.entity.Coordinates;
import org.simulation.view.userinput.screen.AddStaticObjectScreen;
import org.simulation.view.userinput.screen.Screen;
import org.simulation.view.userinput.usercontroller.UserControllerContext;

public class AddStaticObject implements UserControllerState{

    UserControllerContext userControllerContext;

    public AddStaticObject(UserControllerContext userControllerContext) {
        this.userControllerContext = userControllerContext;
    }

    @Override
    public Screen getScreen() {
        return new AddStaticObjectScreen(userControllerContext);
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
        userControllerContext.getSimulation().addLandscapeObject(new Rock(coordinates));
        userControllerContext.getSimulation().renderMap();
        userControllerContext.showScreen();
    }

    @Override
    public void addTree(Coordinates coordinates) {
        userControllerContext.getSimulation().addLandscapeObject(new Tree(coordinates));
        userControllerContext.getSimulation().renderMap();
        userControllerContext.showScreen();
    }

    @Override
    public void pauseSimulation() {

    }

    @Override
    public void back() {
        userControllerContext.changeState(new AddLandscapeObjectState(userControllerContext));
        userControllerContext.showScreen();
    }
}
