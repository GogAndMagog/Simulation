package org.simulation.view.UserInput.Screens;

import org.simulation.view.UserInput.*;
import org.simulation.view.UserInput.UserController.UserControllerContext;

public class MapChooseScreen implements Screen {
    UserControllerContext userControllerContext;

    private final String SCREEN_MESSAGE = """
            Выбор карты:
            1. Песчаная карта
            2. Зелёная карта
            3. Индустриальная карта
            4. Назад""";
    private final String ERROR_MESSAGE = "Неверный ввод!";

    Info info;
    Dialog dialog;
    UserInputValidation validation;

    public MapChooseScreen(UserControllerContext userControllerContext) {
        this.userControllerContext = userControllerContext;
        this.dialog = ConsoleDialog.getInstance();
        this.info = ConsoleInfo.getInstance();
        this.validation = new ConsoleUserInputValidation();
        this.validation.setValidationPattern("[1-4]");
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
                if (YesNoConsoleScreen.getInstance().display()) {
                    userControllerContext.chooseSandyWorld();
                }
                userControllerContext.showScreen();
                break;
            case 2:
                if (YesNoConsoleScreen.getInstance().display()) {
                    userControllerContext.chooseGreenWorld();
                }
                userControllerContext.showScreen();
                break;
            case 3:
                if (YesNoConsoleScreen.getInstance().display()) {
                    userControllerContext.chooseIndustrialWorld();
                }
                userControllerContext.showScreen();
                break;
            case 4:
                userControllerContext.back();
                break;
            default:
                break;
        }
    }
}
