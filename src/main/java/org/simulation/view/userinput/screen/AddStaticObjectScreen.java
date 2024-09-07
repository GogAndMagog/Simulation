package org.simulation.view.userinput.screen;

import org.simulation.service.graph.entity.Coordinates;

import org.simulation.view.userinput.usercontroller.UserControllerContext;

import org.simulation.view.userinput.Info;
import org.simulation.view.userinput.Dialog;
import org.simulation.view.userinput.UserInputValidation;
import org.simulation.view.userinput.ConsoleDialog;
import org.simulation.view.userinput.ConsoleInfo;
import org.simulation.view.userinput.ConsoleUserInputValidation;

public class AddStaticObjectScreen implements Screen {
    UserControllerContext userControllerContext;

    private final String SCREEN_MESSAGE = """
            Добавить статичный объкт:
            1. Добавить камень
            2. Добавить дерево
            3. Добавить фабрику
            4. Назад""";
    private final String ERROR_MESSAGE = "Неверный ввод!";

    Info info;
    Dialog dialog;
    UserInputValidation validation;

    public AddStaticObjectScreen(UserControllerContext userControllerContext) {
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

        boolean passed = false;
        switch (Integer.parseInt(userInput)) {
            case 1:
                addRock();
                break;
            case 2:
                addTree();
                break;
            case 3:
                addFabric();
                break;
            case 4:
                userControllerContext.back();
                break;
            default:
                break;
        }
    }

    private void addRock() {
        try {
            Coordinates coordinates = CoordinatesConsoleScreen.getInstance().display();
            userControllerContext.addRock(coordinates);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            userControllerContext.showScreen();
        }
    }

    private void addTree() {
        try {
            Coordinates coordinates = CoordinatesConsoleScreen.getInstance().display();
            userControllerContext.addTree(coordinates);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            userControllerContext.showScreen();
        }
    }

    private void addFabric() {
        try {
            Coordinates coordinates = CoordinatesConsoleScreen.getInstance().display();
            userControllerContext.addFactory(coordinates);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            userControllerContext.showScreen();
        }
    }
}
