package org.simulation.view.userinput.usercontroller.States;

import org.simulation.service.graph.entity.Coordinates;
import org.simulation.service.simulation.action.InitGreenWorld;
import org.simulation.service.simulation.action.InitIndustrialWorld;
import org.simulation.service.simulation.action.InitSandyWorld;
import org.simulation.service.simulation.action.InitWorldMapAction;
import org.simulation.view.userinput.screen.MapChooseScreen;
import org.simulation.view.userinput.screen.Screen;
import org.simulation.view.userinput.usercontroller.UserControllerContext;

public class MapChooseState implements UserControllerState {

    UserControllerContext userControllerContext;
    Screen mapChooseScreen;

    public MapChooseState(UserControllerContext userControllerContext) {
        this.userControllerContext = userControllerContext;
        mapChooseScreen = new MapChooseScreen(userControllerContext);
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
        userControllerContext.getSimulation().setInitWorldAction(new InitSandyWorld());
    }

    @Override
    public void chooseGreenWorld() {
        userControllerContext.getSimulation().setInitWorldAction(new InitGreenWorld());
    }

    @Override
    public void chooseIndustrialWorld() {
        userControllerContext.getSimulation().setInitWorldAction(new InitIndustrialWorld());
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
