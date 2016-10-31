package ua.training.controllers;

import ua.training.models.Model;
import ua.training.views.View;

import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        view.showMessage(view.INITIAL_MESSAGE);
        while (readAndCheckNumber());
    }

    private int readUserNumber() {
        Scanner scanner = new Scanner(System.in);
        int userNumber = -1;
        try {
            userNumber = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            view.showMessage(view.ERROR_INPUT_MESSAGE);
        }
        return userNumber;
    }

    private boolean readAndCheckNumber() {
        int userNumber = readUserNumber();
        if (userNumber != -1) {
            switch (model.isNumbersEqual(userNumber)) {
                case (0):
                    view.showMessage(view.CONGRATULATION_MESSAGE);
                    return false;
                case (1):
                    view.showMessage(view.HIGHER_NUMBER);
                    break;
                case (-1):
                    view.showMessage(view.LOWER_NUMBER);
                    break;
                default:
                    System.err.print("Unexpected error!");
                    break;
            }
        }
        return true;
    }


}
