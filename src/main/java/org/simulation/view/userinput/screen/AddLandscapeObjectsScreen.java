package org.simulation.view.UserInput.Screens;

import org.simulation.view.UserInput.*;
import org.simulation.view.UserInput.UserController.UserControllerContext;

public class AddLandscapeObjectsScreen implements Screen{
    UserControllerContext userControllerContext;

    private final String SCREEN_MESSAGE = """
            Добавить объект ландшафта:
            1. Добавить террейн
            2. Добавить статичный объект
            3. Назад""";
    private final String ERROR_MESSAGE = "Неверный ввод!";

    Info info;
    Dialog dialog;
    UserInputValidation validation;

    public AddLandscapeObjectsScreen(UserControllerContext userControllerContext) {
        this.userControllerContext = userControllerContext;
        this.dialog = ConsoleDialog.getInstance();
        this.info = ConsoleInfo.getInstance();
        this.validation = new ConsoleUserInputValidation();
        this.validation.setValidationPattern("[1-3]");
    }

    @Override
    public void display() {
        info.showInfo(SCREEN_MESSAGE);

        String userInput = dialog.userInput();

        while (!validation.isValid(userInput)) {
            info.showInfo(SCREEN_MESSAGE);
            info.showInfo(ERROR_MESSAGE);

            userInput = dialog.userInput();
        }

        switch (Integer.parseInt(userInput)) {
            case 1:
                userControllerContext.addTerrain();
                break;
            case 2:
                userControllerContext.addStaticObj();
                break;
            case 3:
                userControllerContext.back();
                break;
            default:
                break;
        }
    }
}
