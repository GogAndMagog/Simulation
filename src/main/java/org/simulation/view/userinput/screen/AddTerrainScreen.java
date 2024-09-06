package org.simulation.view.userinput.screen;

import org.simulation.service.graph.entity.Coordinates;

import org.simulation.view.userinput.usercontroller.UserControllerContext;

import org.simulation.view.userinput.Info;
import org.simulation.view.userinput.Dialog;
import org.simulation.view.userinput.UserInputValidation;
import org.simulation.view.userinput.ConsoleDialog;
import org.simulation.view.userinput.ConsoleInfo;
import org.simulation.view.userinput.ConsoleUserInputValidation;

public class AddTerrainScreen implements Screen {
    UserControllerContext userControllerContext;

    private final String SCREEN_MESSAGE = """
            Добавить террейн:
            1. Добавить траву
            2. Добавить песок
            3. Добавить дорогу
            4. Назад""";
    private final String ERROR_MESSAGE = "Неверный ввод!";

    Info info;
    Dialog dialog;
    UserInputValidation validation;

    public AddTerrainScreen(UserControllerContext userControllerContext) {
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
                while (!passed) {
                    passed = addHerb();
                };
                break;
            case 2:
                while (!passed) {
                    passed = addSand();
                };
                break;
            case 3:
                while (!passed) {
                    passed = addRoad();
                };
                break;
            case 4:
                userControllerContext.back();
                break;
            default:
                break;
        }
    }

    private boolean addHerb() {
        try {
            Coordinates coordinates = CoordinatesConsoleScreen.getInstance().display();
            userControllerContext.addHerb(coordinates);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean addSand() {
        try {
            Coordinates coordinates = CoordinatesConsoleScreen.getInstance().display();
            userControllerContext.addSand(coordinates);
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
