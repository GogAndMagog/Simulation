package org.simulation.view.UserInput.Screens;

import org.simulation.service.graphs.Entities.Coordinates;
import org.simulation.view.UserInput.*;

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

    public static void main(String[] args) {
        CoordinatesConsoleScreen screen = new CoordinatesConsoleScreen();
        screen.display();
    }

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
