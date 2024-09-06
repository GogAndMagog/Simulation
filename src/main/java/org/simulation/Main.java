package org.simulation;

import org.simulation.view.userinput.usercontroller.UserControllerConsoleController;
import org.simulation.view.userinput.usercontroller.UserControllerContext;

public class Main {
    public static void main(String[] args) {
        UserControllerContext userControllerContext = new UserControllerConsoleController();
        userControllerContext.showScreen();
    }
}