package org.simulation.view.userinput.screen;

import org.simulation.view.userinput.*;
import org.simulation.view.userinput.usercontroller.States.MainScreenState;
import org.simulation.view.userinput.usercontroller.UserControllerContext;

public class InterruptSimulationScreen implements Screen{
    UserControllerContext userControllerContext;

    private final String SCREEN_MESSAGE = """
            Нажмите любой ввод, чтобы прервать.""";

    Info info;
    Dialog dialog;
    UserInputValidation validation;

    public InterruptSimulationScreen(UserControllerContext userControllerContext) {
        this.userControllerContext = userControllerContext;
        this.dialog = ConsoleDialog.getInstance();
        this.info = ConsoleInfo.getInstance();
    }

    @Override
    public void display() {
        info.showInfo(SCREEN_MESSAGE);
        dialog.userInput();
        userControllerContext.pauseSimulation();
    }
}
