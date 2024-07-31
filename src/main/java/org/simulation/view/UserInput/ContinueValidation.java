package org.simulation.view.UserInput;

public class ContinueValidation implements UserInputValidation {
    @Override
    public boolean isValid(String input) {
        return input.equals("c") || input.equals("C") || input.equals("Continue");
    }
}
