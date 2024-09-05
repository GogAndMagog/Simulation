package org.simulation.view.UserInput;

import java.io.*;

public class ConsoleDialog implements Dialog{

    private static ConsoleDialog instance = null;

    private ConsoleDialog() {}

    public static ConsoleDialog getInstance() {
        if(instance == null) {
            instance = new ConsoleDialog();
        }
        return instance;
    }

    @Override
    public String userInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
