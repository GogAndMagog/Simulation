package org.simulation.view.userinput.screen;

import org.simulation.view.userinput.ConsoleDialog;
import org.simulation.view.userinput.Dialog;
import org.simulation.view.userinput.Info;
import org.simulation.view.userinput.UserInputValidation;
import org.simulation.view.userinput.ConsoleInfo;
import org.simulation.view.userinput.ConsoleUserInputValidation;

public class YesNoConsoleScreen implements BooleanScreen {

    private static YesNoConsoleScreen instance = new YesNoConsoleScreen();

    public static YesNoConsoleScreen getInstance() {
        return instance;
    }

    private final String SCREEN_MESSAGE = """
        Выбрать?
        1. Да
        2. Нет""";
    private final String ERROR_MESSAGE = "Неверный ввод!";

    Info info;
    Dialog dialog;
    UserInputValidation validation;

    private YesNoConsoleScreen() {
        this.dialog = ConsoleDialog.getInstance();
        this.info = ConsoleInfo.getInstance();
        this.validation = new ConsoleUserInputValidation();
        this.validation.setValidationPattern("[1-2]");
    }

    @Override
    public boolean display() {
        info.showInfo(SCREEN_MESSAGE);

        String userInput = dialog.userInput();

        while (!validation.isValid(userInput)) {
            info.showInfo(SCREEN_MESSAGE);
            info.showInfo(ERROR_MESSAGE);

            userInput = dialog.userInput();
        }

        return switch (Integer.parseInt(userInput)) {
            case 1 -> true;
            case 2 -> false;
            default -> false;
        };
    }
}
