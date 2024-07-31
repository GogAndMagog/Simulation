package org.simulation.service.Simulation;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Simulation implements AbstractSimulation, Runnable {

    private String state = "Initial state";
    BlockingQueue<SimulationCommand> commandQueue = new LinkedBlockingQueue<SimulationCommand>();

    public Simulation(BlockingQueue<SimulationCommand> commandQueue) {
        this.commandQueue = commandQueue;
    }

    @Override
    public void startSimulation() {
        simulationProcess();
    }

    @Override
    public void stopSimulation() {
    }

    private void simulationProcess() {

        while (commandQueue.isEmpty()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Simulation interrupted.");
                return;
            }
            System.out.println("Simulation process. State is \"" + state + "\".");
        }
        controller();
    }

    @Override
    public void run() {
        startSimulation();
    }

    private void idle(){
        while(commandQueue.isEmpty()){
        }
        controller();
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

    public void setState(String state) {
        this.state = state;
    }
}
