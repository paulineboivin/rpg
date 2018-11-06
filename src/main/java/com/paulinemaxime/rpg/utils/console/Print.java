package com.paulinemaxime.rpg.utils.console;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Print {

    private static Print instance = null;

    private Map<String,Color> color = new HashMap<>();
    private final int MAX_WIDTH = AdvancedConsole.MAX_WIDTH;

    public static Print getInstance() {
        if (instance == null) {
            instance = new Print();
        }
        return instance;
    }

    private Print() {
        init();
    }

    private void init() {
        color.put("§0",Color.RESET);
        color.put("§r",Color.RED);
        color.put("§b", Color.BLUE);
        color.put("§c",Color.CYAN);
        color.put("§g",Color.GREEN);
        color.put("§w",Color.WHITE);
        color.put("§f",Color.BLACK);
        color.put("§p",Color.PURPLE);
        color.put("§y",Color.YELLOW);
        color.put("§R",Color.RED_BG);
        color.put("§B",Color.BLUE_BG);
        color.put("§C",Color.CYAN_BG);
        color.put("§G",Color.GREEN_BG);
        color.put("§W",Color.WHITE_BG);
        color.put("§F",Color.BLACK_BG);
        color.put("§P",Color.PURPLE_BG);
        color.put("§Y",Color.YELLOW_BG);
    }

    public void print(boolean reduce, String msg) {
        for(Map.Entry<String, Color> entry : color.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            msg = msg.replaceAll(key, value);
        }
        if (reduce) {
            msg = reduceString(msg);
        }
        System.out.println(msg);
    }

    public void print(String msg) {
        for(Map.Entry<String, Color> entry : color.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            msg = msg.replaceAll(key, value);
        }
        System.out.println(msg);
    }

    public void print(String[] msg) {
        for (int i = 0; i < msg.length; i++) {
            print(msg[i]);
        }
    }

    public void print(Collection<String> lines) {
        for (String msg: lines) {
            print(msg);
        }
    }

    public void print(boolean reduce, Collection<String> lines) {
        for (String msg: lines) {
            print(reduce, msg);
        }
    }

    private String reduceString(String lines) {
        int i = 0;
        String buff1 ="";
        String buff2 ="";
        while (i+MAX_WIDTH < lines.length()) {
            buff1 = lines.substring(i, i+MAX_WIDTH);
            buff2 = lines.substring(i+MAX_WIDTH, lines.length());
            lines = buff1 + "\n " + buff2;
            i = i+MAX_WIDTH;
        }
        return lines;
    }

    public void loadingBarColor(double current, double max) {
        int percent = (int) (current / max * 100);
        String out = "";
        if (percent > 60) {
            out = Color.GREEN.toString();
        } else if (percent > 30) {
            out = Color.YELLOW.toString();
        } else {
            out = Color.RED.toString();
        }
        for (int i = 0; i < percent; i++) {
            out += "|";
        }
        out += Color.WHITE.toString();
        for (int j = 0; j < 100-percent; j++) {
            out += "|";
        }
        out += "  §0" + percent + "%";
        print(out);
    }

    public void loadingBar(double current, double max) {
        int percent = (int) (current / max * 100);
        String out = "";
        for (int i=0; i < 100; i++) {
            if (i <= percent) {
                out+= "|";
            } else {
                out+= ".";
            }
        }
        out += " " + percent + "%";
        print(out);
    }
}