package org.simulation.view.UserInput;

import java.util.Scanner;

public class ContinueSimulationDialog implements Dialog
{
    Scanner scanner = new Scanner(System.in);
    UserInputValidation validator = new ContinueValidation();

    @Override
    public String userInput() {


        return "";
    }
}
