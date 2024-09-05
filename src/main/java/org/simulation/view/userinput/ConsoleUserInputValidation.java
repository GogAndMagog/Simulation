package org.simulation.view.UserInput;

public class ConsoleUserInputValidation implements UserInputValidation {

    String validationPattern = "";

    @Override
    public boolean isValid(String input) {
        return input.matches(validationPattern);
    }

    @Override
    public void setValidationPattern(String pattern) {
        this.validationPattern = pattern;
    }
}
