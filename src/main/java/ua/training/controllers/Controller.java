package ua.training.controllers;

import ua.training.models.Model;
import ua.training.views.View;

import java.util.Scanner;

/**
 * Controller
 */
public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Initial method
     */
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        view.showMessage(view.BARRIER_MESSAGE);
        setRange(scanner);
        model.setSecretNumber(model.getRandomNumber());
        while (!checkNumberForEquality(scanner));
    }

    /**
     * Reads barriers of range from user and checks it for valid form
     * @param scanner scanner from console
     */
    public void setRange(Scanner scanner) {
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

    /**
     * Reads number from user and checks it for valid form
     * @param scanner scanner from console
     * @return user's number if number has parsed properly
     * or -1 if some problems occurs
     */
    public int readUserNumber(Scanner scanner) {
        int userNumber = -1;
        try {
            userNumber = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            view.showMessage(view.ERROR_INPUT_MESSAGE);
        }
        return userNumber;
    }

    /**
     * Checks user's number for equality and shows messages
     * @param scanner scanner from console
     * @return true if user's number and secret number are equal,
     * false if user's number and secret number aren't equal
     */
    public boolean checkNumberForEquality(Scanner scanner) {
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
                    return true;
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
        return false;
    }


}
