package org.simulation.view.userinput.screen;

import org.simulation.view.userinput.usercontroller.UserControllerContext;

import org.simulation.view.userinput.Info;
import org.simulation.view.userinput.Dialog;
import org.simulation.view.userinput.UserInputValidation;
import org.simulation.view.userinput.ConsoleDialog;
import org.simulation.view.userinput.ConsoleInfo;
import org.simulation.view.userinput.ConsoleUserInputValidation;

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
