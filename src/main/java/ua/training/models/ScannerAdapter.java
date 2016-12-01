package ua.training.models;

import java.util.Scanner;

public class ScannerAdapter {

    private Scanner scanner;

    public ScannerAdapter(Scanner scanner) {
        this.scanner = scanner;
    }

    public String next() {
        return scanner.next();
    }

}
