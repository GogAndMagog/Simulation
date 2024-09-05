package org.simulation.service.Simulation;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SimulationTest {

    public static void main(String[] args) {
        BlockingQueue<SimulationCommand> commandQueue = new ArrayBlockingQueue<SimulationCommand>(10);

        Simulation simulation = new Simulation(commandQueue, 2, 2);

        try {
            commandQueue.put(SimulationCommand.START_SIMULATION);
            Thread simulationThread = new Thread(simulation);
            simulationThread.start();

            Thread.sleep(1500);
            commandQueue.put(SimulationCommand.STOP_SIMULATION);

            Thread.sleep(1500);
            simulation.setState("Continue");
            commandQueue.put(SimulationCommand.CONTINUE_SIMULATION);

            Thread.sleep(1500);
            commandQueue.put(SimulationCommand.EXIT_SIMULATION);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
