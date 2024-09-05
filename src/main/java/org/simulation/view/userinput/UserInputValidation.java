package org.simulation.view.userinput;

public interface UserInputValidation {
    public boolean isValid(String input);
    public void setValidationPattern(String pattern);
}
