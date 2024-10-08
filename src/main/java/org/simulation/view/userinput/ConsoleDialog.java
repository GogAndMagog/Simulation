package org.simulation.view.userinput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

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
