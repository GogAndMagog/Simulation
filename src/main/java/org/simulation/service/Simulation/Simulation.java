package org.simulation.service.Simulation;

import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.dynamic.herbivore.Sheep;
import org.simulation.model.entities.statical.Rock;
import org.simulation.service.Graphs.Entities.Coordinates;
import org.simulation.service.Simulation.Actions.*;
import org.simulation.view.ConsoleRenderer;
import org.simulation.view.Renderer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Simulation implements AbstractSimulation, Runnable {

    List<WorldAction> initActions;
    List<WorldAction> turnActions;

    WorldMap worldMap;

    long turnCounter = 0;
    boolean running = true;

    private String state = "Initial state";
    BlockingQueue<SimulationCommand> commandQueue = new LinkedBlockingQueue<SimulationCommand>();

    Renderer renderer;

    public static void main(String[] args) {
        BlockingQueue<SimulationCommand> commandQueue = new LinkedBlockingQueue<>();

        Simulation testSimulation = new Simulation(commandQueue, 5, 5);
        testSimulation.setInitWorldAction(new InitWorldMap());
        testSimulation.setTurnWorldAction(new MakeMove());
        testSimulation.setTurnWorldAction(new RemoveDeadCreatures());
        testSimulation.setTurnWorldAction(new RemoveNotExistedLandscapeObjs());

        testSimulation.startSimulation();
    }

    public Simulation(BlockingQueue<SimulationCommand> commandQueue, int n, int m) {
        this.commandQueue = commandQueue;
        this.initActions = new ArrayList<>();
        this.turnActions = new ArrayList<>();
        this.worldMap = new WorldMap(n, m);
        this.running = true;
        this.renderer = new ConsoleRenderer(this.worldMap);
    }

    @Override
    public void startSimulation() {
        processInitActions();
        simulationProcess();
    }

    @Override
    public void pauseSimulation() {
    }

    @Override
    public void nextMove() {

    }

    private void simulationProcess() {

        renderer.render();
        while(running && turnCounter < 25)
        {
            if (turnCounter == 10) {
                worldMap.setCreature(new Sheep(new Coordinates(0,0), worldMap, 10,10));
//                worldMap.setLandscapeObject(new Rock(new Coordinates(4,2), worldMap));ы
            }
            turnCounter++;
            processTurnActions();
            renderer.render();
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
        initActions.add(action);
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
}
