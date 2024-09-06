package org.simulation.view.userinput.screen;

import org.simulation.view.userinput.usercontroller.UserControllerContext;

import org.simulation.view.userinput.Info;
import org.simulation.view.userinput.Dialog;
import org.simulation.view.userinput.UserInputValidation;
import org.simulation.view.userinput.ConsoleDialog;
import org.simulation.view.userinput.ConsoleInfo;

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
