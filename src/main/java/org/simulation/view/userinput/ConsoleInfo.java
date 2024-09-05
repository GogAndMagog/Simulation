package org.simulation.view.userinput;

public class ConsoleInfo implements Info {

    static private ConsoleInfo instance = new ConsoleInfo();

    private ConsoleInfo() {
    }

    public static ConsoleInfo getInstance() {
        return instance;
    }

    @Override
    public void showInfo(String info) {
        System.out.println(info);
    }
}
