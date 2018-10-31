package com.paulinemaxime.rpg.utils.console;


import com.paulinemaxime.rpg.utils.ScannerProvider;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Supplier;

public class Menu {

    private static final Print print = Print.getInstance();
    private static final Scanner scanner = ScannerProvider.getInstance().getScanner();

    private String name = null;
    private String description = "";
    private ArrayList<Choice> choices = new ArrayList<>();

    private final int MAX_WIDTH = AdvancedConsole.MAX_WIDTH;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Menu(String name) {
        this.name = name;
    }

    public Menu() {}

    public void addName(String name) {
        this.name = name;
    }

    public void addChoice(String name, Supplier<Void> function) {
        choices.add(new Choice(name, function));
    }

    public void addDescription(String description) {
        this.description = description;
    }

    public void print() {
        ArrayList<String> result = new ArrayList<>();
        if (name != null) {
            result.add(constructName());
        }
        result.add("\n" + description + "\n");
        result.addAll(constructChoice());

        print.print(true, result);
        scanChoice();
    }

    private String constructName() {
        int size = name.length() + 4;
        int max = ( MAX_WIDTH - size )/2;
        String bar = "";
        for (int i = 0; i < max; i++) {
            bar += "=";
        }
        return bar + "[ " + name + " ]" + bar;
    }

    private ArrayList<String> constructChoice() {
        ArrayList<String> result = new ArrayList<>();
        if (choices.size() >= 40) {

            for (int i = 0; i < choices.size(); i = i+2) {
                if ((choices.get(i).getTitle().length() + choices.get(i).getTitle().length()) < (MAX_WIDTH - 31)) {
                    result.add("     " + (i+1) + ". " + choices.get(i).getTitle() + "§0               " + (i+2) + ". " + choices.get(i).getTitle());
                }
            }

        } else {
            for (int i = 0; i < choices.size(); i++) {
                result.add("     " + (i+1) + ". " + choices.get(i).getTitle());
            }
        }
        return result;
    }

    private void scanChoice() {
        int choice = 1000;
        do {
            while (!scanner.hasNextInt()) scanner.next();
            choice = scanner.nextInt();
        } while (choice < 1 || choice > choices.size());
        choices.get(choice-1).getAction().get();
    }
}
