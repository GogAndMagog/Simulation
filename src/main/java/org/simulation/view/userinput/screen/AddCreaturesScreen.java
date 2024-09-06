package org.simulation.view.userinput.screen;

import org.simulation.service.graph.entity.Coordinates;

import org.simulation.view.userinput.usercontroller.UserControllerContext;

import org.simulation.view.userinput.Info;
import org.simulation.view.userinput.Dialog;
import org.simulation.view.userinput.UserInputValidation;
import org.simulation.view.userinput.ConsoleDialog;
import org.simulation.view.userinput.ConsoleInfo;
import org.simulation.view.userinput.ConsoleUserInputValidation;

public class AddCreaturesScreen implements Screen {
    UserControllerContext userControllerContext;

    private final String SCREEN_MESSAGE = """
            Добавить существо:
            1. Волк
            2. Овца
            3. Назад""";
    private final String ERROR_MESSAGE = "Неверный ввод!";

    Info info;
    Dialog dialog;
    UserInputValidation validation;

    public AddCreaturesScreen(UserControllerContext userControllerContext) {
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
                    passed = addWolf();
                }
                break;
            case 2:
                while (!passed) {
                    passed = addSheep();
                }
                break;
            case 3:
                userControllerContext.back();
                break;
            default:
                break;
        }
    }

    private boolean addWolf() {
        try {
            Coordinates coordinates = CoordinatesConsoleScreen.getInstance().display();
            userControllerContext.addWolf(coordinates);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean addSheep() {
        try {
            Coordinates coordinates = CoordinatesConsoleScreen.getInstance().display();
            userControllerContext.addSheep(coordinates);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
