package org.simulation.view.userinput.screen;

import org.simulation.service.graph.entity.Coordinates;

import org.simulation.view.userinput.Info;
import org.simulation.view.userinput.Dialog;
import org.simulation.view.userinput.UserInputValidation;
import org.simulation.view.userinput.ConsoleDialog;
import org.simulation.view.userinput.ConsoleInfo;
import org.simulation.view.userinput.ConsoleUserInputValidation;

public class CoordinatesConsoleScreen implements CoordinatesScreen {

    private static final CoordinatesConsoleScreen instance = new CoordinatesConsoleScreen();
    public static CoordinatesConsoleScreen getInstance() {
        return instance;
    }


    private final String SCREEN_MESSAGE = """
        Введите координаты(x, y):""";
    private final String ERROR_MESSAGE = "Неверный ввод!";

    Info info;
    Dialog dialog;
    UserInputValidation validation;

    private CoordinatesConsoleScreen() {
        this.dialog = ConsoleDialog.getInstance();
        this.info = ConsoleInfo.getInstance();
        this.validation = new ConsoleUserInputValidation();
        this.validation.setValidationPattern("\\s*\\d+\\s*\\d+\\s*");
    }

    @Override
    public Coordinates display() {
        Coordinates coordinates = null;

        info.showInfo(SCREEN_MESSAGE);

        String userInput = dialog.userInput();

        while (!validation.isValid(userInput)) {
            info.showInfo(SCREEN_MESSAGE);
            info.showInfo(ERROR_MESSAGE);

            userInput = dialog.userInput();
        }

        var integerValues = userInput.trim().split("\\s+");
        coordinates = new Coordinates(Integer.parseInt(integerValues[0]), Integer.parseInt(integerValues[1]));

        return coordinates;
    }
}
