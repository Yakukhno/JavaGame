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
        Scanner scanner = new Scanner(System.in);
        view.showMessage(view.BARRIER_MESSAGE);
        setRange(scanner);
        model.setSecretNumber(model.getRandomNumber());
        while (readAndCheckNumber(scanner));
    }

    private void setRange(Scanner scanner) {
        try {
            int minBarrier = Integer.parseInt(scanner.next());
            int maxBarrier = Integer.parseInt(scanner.next());
            if (maxBarrier > minBarrier + 1) {
                model.setMinBarrier(minBarrier);
                model.setMaxBarrier(maxBarrier);
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            view.showMessage(view.ERROR_INPUT_MESSAGE + " Enter again");
            setRange(scanner);
        }
    }

    private int readUserNumber(Scanner scanner) {
        int userNumber = -1;
        try {
            userNumber = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            view.showMessage(view.ERROR_INPUT_MESSAGE);
        }
        return userNumber;
    }

    private boolean readAndCheckNumber(Scanner scanner) {
        view.showMessageWithRange(view.RANGE_MESSAGE,
                model.getMinBarrier(), model.getMaxBarrier());
        int userNumber = readUserNumber(scanner);
        if ((userNumber != -1)
                && !(userNumber <= model.getMinBarrier())
                && !(userNumber >= model.getMaxBarrier())) {
            switch (model.isNumbersEqual(userNumber)) {
                case (0):
                    view.showMessage(view.CONGRATULATION_MESSAGE);
                    view.showStatistics(model.getStatistics());
                    return false;
                case (1):
                    view.showMessage(view.HIGHER_NUMBER);
                    model.setMaxBarrier(userNumber);
                    break;
                case (-1):
                    view.showMessage(view.LOWER_NUMBER);
                    model.setMinBarrier(userNumber);
                    break;
                default:
                    System.err.print("Unexpected error!");
                    break;
            }
        }
        return true;
    }


}
