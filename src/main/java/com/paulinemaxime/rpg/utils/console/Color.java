package com.paulinemaxime.rpg.utils.console;

public enum Color {

    RESET ("\033[0m"),
    RED ("\033[0;31m"),
    BLUE ("\033[0;34m"),
    CYAN ("\033[0;36m"),
    GREEN ("\033[0;32m"),
    WHITE ("\033[0;37m"),
    PURPLE ("\033[0;35m"),
    YELLOW ("\033[0;33m"),
    BLACK ("\033[0;30m"),
    RED_BG ("\033[41m"),
    BLUE_BG ("\033[44m"),
    CYAN_BG ("\033[46m"),
    GREEN_BG ("\033[42m"),
    WHITE_BG ("\033[47m"),
    PURPLE_BG ("\033[45m"),
    YELLOW_BG ("\033[43m"),
    BLACK_BG ("\033[40m");

    private String name = "";

    Color(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
