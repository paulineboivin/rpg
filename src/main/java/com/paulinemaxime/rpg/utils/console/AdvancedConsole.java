package com.paulinemaxime.rpg.utils.console;

public class AdvancedConsole {

    private static AdvancedConsole instance = null;
    public static final int MAX_WIDTH = 100;

    private Print print;

    private AdvancedConsole() {
        this.print = Print.getInstance();
    }

    public static AdvancedConsole getInstance() {
        if (instance == null) {
            instance = new AdvancedConsole();
        }
        return instance;
    }

    public void print(boolean reduce, String msg) {
        print.print(reduce,msg);
    }

    public void print(String msg) {
        print.print(msg);
    }

    public void print(String[] msg) {
        print.print(msg);
    }

    public void loadingBarColor(double current, double max) {
        print.loadingBarColor(current,max);
    }

    public Menu createMenu() {
        return new Menu();
    }

    public Menu createMenu(String name) { return new Menu(name); }

    public Menu createMenu(String name, String description) { return new Menu(name, description); }

}