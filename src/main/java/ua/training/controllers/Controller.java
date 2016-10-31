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
        view.showMessageWithRange(view.RANGE_MESSAGE,
                model.getMinMark(), model.getMaxMark());
        int userNumber = readUserNumber();
        if ((userNumber != -1)
                && !(userNumber < model.getMinMark())
                && !(userNumber > model.getMaxMark())) {
            switch (model.isNumbersEqual(userNumber)) {
                case (0):
                    view.showMessage(view.CONGRATULATION_MESSAGE);
                    return false;
                case (1):
                    view.showMessage(view.HIGHER_NUMBER);
                    model.setMaxMark(userNumber);
                    break;
                case (-1):
                    view.showMessage(view.LOWER_NUMBER);
                    model.setMinMark(userNumber + 1);
                    break;
                default:
                    System.err.print("Unexpected error!");
                    break;
            }
        }
        return true;
    }


}
