package com.paulinemaxime.rpg.utils.console;

import com.paulinemaxime.rpg.utils.ScannerProvider;

import java.util.Scanner;

public class AdvancedConsole {

    private static AdvancedConsole instance = null;
    private final Scanner scanner = ScannerProvider.getInstance().getScanner();
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

    public void loadingBar(double current, double max) {
        print.loadingBar(current, max);
    }

    public Menu createMenu() {
        return new Menu();
    }

    public Menu createMenu(String name) { return new Menu(name); }

    public Menu createMenu(String name, String description) { return new Menu(name, description); }

    public int verifInputInt(int min, int max) {
        int result = 0;
        do {
            while (!scanner.hasNextInt()) scanner.next();
            result = (int) scanner.nextInt();
        } while ( result < min || result > max );
        return result;
    }

}