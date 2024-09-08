package org.simulation.view.userinput.screen;

import org.simulation.view.userinput.usercontroller.UserControllerContext;

import org.simulation.view.userinput.*;

public class MainConsoleScreen implements Screen {

    UserControllerContext userControllerContext;

    private final String SCREEN_MESSAGE = """
            Стартовый экран:
            1. Выбрать карту
            2. Добавить животных
            3. Добавить объект ландшафта
            4. Сделать ход симуляции
            5. Запустить бесконечную симуляци
            6. Выйти""";
    private final String ERROR_MESSAGE = "Неверный ввод!";

    Info info;
    Dialog dialog;
    UserInputValidation validation;

    public MainConsoleScreen(UserControllerContext userControllerContext) {
        this.userControllerContext = userControllerContext;
        this.dialog = ConsoleDialog.getInstance();
        this.info = ConsoleInfo.getInstance();
        this.validation = new ConsoleUserInputValidation();
        this.validation.setValidationPattern("[1-7]");
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
                userControllerContext.chooseMap();
                break;
            case 2:
                userControllerContext.addCreatures();
                break;
            case 3:
                userControllerContext.addLandscapeObj();
                break;
            case 4:
                userControllerContext.makeSimulationMove();
                break;
            case 5:
                userControllerContext.runSimulation();
                break;
            case 6:
                userControllerContext.exit();
                break;
            default:
                break;
        }
    }
}
