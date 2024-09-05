package org.simulation.service.simulation;

import org.simulation.model.entity.WorldMap;
import org.simulation.model.entity.dynamic.Creature;
import org.simulation.model.entity.dynamic.herbivore.Sheep;
import org.simulation.model.entity.statical.LandscapeObject;
import org.simulation.service.graph.entity.Coordinates;
import org.simulation.service.simulation.action.*;
import org.simulation.view.ConsoleRenderer;
import org.simulation.view.Renderer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Simulation implements AbstractSimulation, Runnable {

    List<WorldAction> initActions;
    List<WorldAction> turnActions;

    WorldMap worldMap;

    long turnCounter = 0;
    boolean running = false;
    boolean initActionsPassed = false;

    private String state = "Initial state";
    BlockingQueue<SimulationCommand> commandQueue = new LinkedBlockingQueue<SimulationCommand>();

    Renderer renderer;

    public static void main(String[] args) {
        BlockingQueue<SimulationCommand> commandQueue = new LinkedBlockingQueue<>();

        Simulation testSimulation = new Simulation(commandQueue, 5, 5);
        testSimulation.setInitWorldAction(new InitWorldMapAction());
        testSimulation.setTurnWorldAction(new MakeMoveAction());
        testSimulation.setTurnWorldAction(new RemoveDeadCreaturesAction());
        testSimulation.setTurnWorldAction(new RemoveNotExistedLandscapeObjsAction());

        testSimulation.startSimulation();
    }

    public Simulation(BlockingQueue<SimulationCommand> commandQueue, int n, int m) {
        this.commandQueue = commandQueue;
        this.initActions = new ArrayList<>();
        this.turnActions = new ArrayList<>();
        this.worldMap = new WorldMap(n, m);
        this.renderer = new ConsoleRenderer(this.worldMap);

        this.setTurnWorldAction(new MakeMoveAction());
        this.setTurnWorldAction(new RemoveDeadCreaturesAction());
        this.setTurnWorldAction(new RemoveNotExistedLandscapeObjsAction());
    }

    @Override
    public void startSimulation() {
        if (!initActionsPassed) {
            initActionsPassed = true;
            processInitActions();
            renderer.render();
        }

        running = true;

        Runnable task = new Runnable() {
            @Override
            public void run() {
                renderer.render();
//                while (commandQueue.isEmpty()) {
                while (running) {
                    nextMove();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
//                commandQueue.poll();
            }
        };
        new Thread(task).start();
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

    public void simulationProcess() {
        renderer.render();
        while (running && turnCounter < 25) {
            nextMove();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        while (commandQueue.isEmpty()) {
//            try {
//                while(running)
//                {
//                    turnCounter++;
//                    processTurnActions();
//                    renderer.render();
//                    break;
//                }
////                Thread.sleep(500);
//            } catch (Exception e) {
//                System.out.println("Simulation interrupted.");
//                return;
//            }
//            System.out.println("Simulation process. State is \"" + state + "\".");
//        }
//        controller();
    }

    @Override
    public void run() {
        startSimulation();
    }

    private void idle() {
        while (commandQueue.isEmpty()) {
        }
        controller();
    }

    @Override
    public void setInitWorldAction(WorldAction action) {
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

    private void controller() {
        var command = commandQueue.poll();
        switch (command) {
            case STOP_SIMULATION -> {
                System.out.println("Simulation stopped.");
                idle();
            }
            case CONTINUE_SIMULATION -> {
                System.out.println("Simulation continued.");
                simulationProcess();
            }
            case START_SIMULATION -> {
                System.out.println("Simulation started.");
                simulationProcess();
            }
            case EXIT_SIMULATION -> {
                System.out.println("Simulation exited.");
            }
            case null -> {
                return;
//                stopFlag = true;
            }
        }

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

    public void setState(String state) {
        this.state = state;
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
            throw new RuntimeException("Карта не выбрана!");
        }
    }

    @Override
    public void renderMap() {
        renderer.render();
    }
}
