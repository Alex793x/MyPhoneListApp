package application_modules;

import Controller.AppLogic;

public class RunApp {

    public static void run() {
        AppLogic myApp = new AppLogic();
        myApp.runMenu();
    }

    public static void main(String[] args) {
        RunApp.run();
    }

}