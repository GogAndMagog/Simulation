package org.simulation.view.UserInput.UserController.States;

import org.simulation.model.entities.statical.terrain.Herb;
import org.simulation.model.entities.statical.terrain.Road;
import org.simulation.model.entities.statical.terrain.Sand;
import org.simulation.service.Graphs.Entities.Coordinates;
import org.simulation.view.UserInput.Dialog;
import org.simulation.view.UserInput.Screens.AddTerrainScreen;
import org.simulation.view.UserInput.Screens.Screen;
import org.simulation.view.UserInput.UserController.UserControllerContext;

public class AddTerrainSate implements UserControllerState{

    UserControllerContext userControllerContext;

    public AddTerrainSate(UserControllerContext userControllerContext) {
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
        return new AddTerrainScreen(userControllerContext);
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
        userControllerContext.getSimulation().addLandscapeObject(new Herb(coordinates));
        userControllerContext.getSimulation().renderMap();
        userControllerContext.showScreen();
    }

    @Override
    public void addSand(Coordinates coordinates) {
        userControllerContext.getSimulation().addLandscapeObject(new Sand(coordinates));
        userControllerContext.getSimulation().renderMap();
        userControllerContext.showScreen();
    }

    @Override
    public void addRoad(Coordinates coordinates) {
        userControllerContext.getSimulation().addLandscapeObject(new Road(coordinates));
        userControllerContext.getSimulation().renderMap();
        userControllerContext.showScreen();
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
        userControllerContext.changeState(new AddLandscapeObjectState(userControllerContext));
        userControllerContext.showScreen();
    }
}
