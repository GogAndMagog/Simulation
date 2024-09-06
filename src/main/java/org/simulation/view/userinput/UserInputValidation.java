package org.simulation.view.userinput;

public interface UserInputValidation {
    boolean isValid(String input);
    void setValidationPattern(String pattern);
}
