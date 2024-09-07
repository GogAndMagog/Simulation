package org.simulation.service.simulation;

import org.simulation.model.entity.WorldMap;
import org.simulation.model.entity.dynamic.Creature;
import org.simulation.model.entity.dynamic.herbivore.Sheep;
import org.simulation.model.entity.statical.LandscapeObject;
import org.simulation.service.graph.entity.Coordinates;
import org.simulation.service.simulation.action.MakeMoveAction;
import org.simulation.service.simulation.action.RemoveDeadCreaturesAction;
import org.simulation.service.simulation.action.RemoveNotExistedLandscapeObjsAction;
import org.simulation.service.simulation.action.WorldAction;
import org.simulation.service.simulation.action.InitWorldMapAction;
import org.simulation.service.simulation.exception.MapNotSetException;
import org.simulation.view.ConsoleRenderer;
import org.simulation.view.Renderer;

import java.util.ArrayList;
import java.util.List;

public class Simulation implements AbstractSimulation {

    List<WorldAction> initActions;
    List<WorldAction> turnActions;

    WorldMap worldMap;

    long turnCounter = 0;
    boolean running = false;
    boolean initActionsPassed = false;

    Renderer renderer;

    public Simulation() {
        this.initActions = new ArrayList<>();
        this.turnActions = new ArrayList<>();
        this.worldMap = new WorldMap(0, 0);
        this.renderer = new ConsoleRenderer(this.worldMap);

        this.setTurnWorldAction(new MakeMoveAction());
        this.setTurnWorldAction(new RemoveDeadCreaturesAction());
        this.setTurnWorldAction(new RemoveNotExistedLandscapeObjsAction());
    }

    @Override
    public void startSimulation(Thread.UncaughtExceptionHandler handler) {
        if (!initActionsPassed) {
            initActionsPassed = true;
            processInitActions();
            renderer.render();
        }

        running = true;

        Runnable task = () -> {
            renderer.render();
            while (running) {
                nextMove();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t = new Thread(task);
        t.setUncaughtExceptionHandler(handler);
        t.start();
    }

    @Override
    public void pauseSimulation() {
        running = false;
    }

    @Override
    public void nextMove() {
        if (!initActionsPassed) {
            initActionsPassed = true;
            processInitActions();
            renderer.render();
        }

        checkMap();

        if (turnCounter == 10) {
            worldMap.setCreature(new Sheep(new Coordinates(0, 0), worldMap, 10, 10));
        }
        turnCounter++;
        processTurnActions();
        renderer.render();
    }

    @Override
    public void setInitWorldAction(WorldAction action) {
        initActionsPassed = false;
        turnCounter = 0;

        if (action instanceof InitWorldMapAction) {
            if (!initActions.isEmpty()) {
                initActions.removeFirst();
            }
            initActions.addFirst(action);
        }
        else{
            initActions.addLast(action);
        }
    }

    @Override
    public void setTurnWorldAction(WorldAction action) {
        turnActions.add(action);
    }

    private void processInitActions() {
        for (WorldAction initAction : initActions) {
            initAction.execute(this.worldMap);
        }
    }

    private void processTurnActions() {
        for (WorldAction turnAction : turnActions) {
            turnAction.execute(this.worldMap);
        }
    }

    @Override
    public void setMap(WorldMap worldMap) {
        this.worldMap = worldMap;
        initActionsPassed = false;
    }

    @Override
    public void addCreature(Creature creature) {
        this.worldMap.setCreature(creature);
    }

    @Override
    public void addLandscapeObject(LandscapeObject landscapeObject) {
        this.worldMap.setLandscapeObject(landscapeObject);
    }

    private void checkMap() {
        if (this.worldMap == null
                || (this.worldMap.getX() == 0 && this.worldMap.getY() == 0)) {
            throw new MapNotSetException();
        }
    }

    @Override
    public void renderMap() {
        renderer.render();
    }
}
