package com.paulinemaxime.rpg.utils.console;

import java.util.function.Supplier;

public class Choice {

    private String title;
    private Supplier<Void> action;

    public Choice(String title, Supplier<Void> action) {
        this.title = title;
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public Supplier<Void> getAction() {
        return action;
    }
}
