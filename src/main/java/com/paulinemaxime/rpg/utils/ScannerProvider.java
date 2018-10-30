package com.paulinemaxime.rpg.utils;

import java.util.Scanner;

public class ScannerProvider {

    private static ScannerProvider instance = null;
    private Scanner scanner;

    private ScannerProvider() {
        this.scanner = new Scanner(System.in);
    }

    public static ScannerProvider getInstance() {
        if ( instance == null) {
            instance = new ScannerProvider();
        }
        return instance;
    }

    public Scanner getScanner() {
        return scanner;
    }
}

