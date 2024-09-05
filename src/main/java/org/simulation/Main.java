package org.simulation;

import org.simulation.view.userinput.usercontroller.UserControllerConsoleController;
import org.simulation.view.userinput.usercontroller.UserControllerContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UserControllerContext userControllerContext = new UserControllerConsoleController();
        userControllerContext.showScreen();
    }
}