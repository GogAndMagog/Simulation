package org.simulation.view.userinput.screen;

import org.simulation.service.graph.entity.Coordinates;
import org.simulation.view.userinput.*;
import org.simulation.view.userinput.usercontroller.UserControllerContext;

public class AddStaticObjectScreen implements Screen{
    UserControllerContext userControllerContext;

    private final String SCREEN_MESSAGE = """
            Добавить статичный объкт:
            1. Добавить камень
            2. Добавить дерево
            3. Назад""";
    private final String ERROR_MESSAGE = "Неверный ввод!";

    Info info;
    Dialog dialog;
    UserInputValidation validation;

    public AddStaticObjectScreen(UserControllerContext userControllerContext) {
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

        boolean passed = false;
        switch (Integer.parseInt(userInput)) {
            case 1:
                while (!passed) {
                    passed = addRock();
                };
                break;
            case 2:
                while (!passed) {
                    passed = addTree();
                };
                break;
            case 3:
                userControllerContext.back();
                break;
            default:
                break;
        }
    }

    private boolean addRock() {
        try {
            Coordinates coordinates = CoordinatesConsoleScreen.getInstance().display();
            userControllerContext.addRock(coordinates);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean addTree() {
        try {
            Coordinates coordinates = CoordinatesConsoleScreen.getInstance().display();
            userControllerContext.addTree(coordinates);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean addRoad() {
        try {
            Coordinates coordinates = CoordinatesConsoleScreen.getInstance().display();
            userControllerContext.addRoad(coordinates);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
