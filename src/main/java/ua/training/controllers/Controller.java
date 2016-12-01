package ua.training.controllers;

import ua.training.models.Model;
import ua.training.models.ScannerAdapter;
import ua.training.views.View;

import java.util.Scanner;

/**
 * Controller
 */
public class Controller {

    private Model model;
    private View view;
    private ScannerAdapter scanner = new ScannerAdapter(new Scanner(System.in));

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Initial method
     */
    public void startGame() {
        view.showMessage(View.BARRIER_MESSAGE);
        setRange();
        model.setSecretNumber(model.getRandomNumber());
        while (!checkNumberForEquality());
    }

    /**
     * Reads barriers of range from user and checks it for valid form
     */
    void setRange() {
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
            view.showMessage(View.ERROR_AND_REPEAT_MESSAGE);
            setRange();
        }
    }

    /**
     * Reads number from user and checks it for valid form
     * @return user's number if number has parsed properly
     * or -1 if some problems occurs
     */
    int readUserNumber() {
        int userNumber = -1;
        try {
            userNumber = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            view.showMessage(View.ERROR_INPUT_MESSAGE);
        }
        return userNumber;
    }

    /**
     * Checks user's number for equality and shows messages
     * @return true if user's number and secret number are equal,
     * false if user's number and secret number aren't equal
     */
     boolean checkNumberForEquality() {
        view.showMessageWithRange(View.RANGE_MESSAGE,
                model.getMinBarrier(), model.getMaxBarrier());
        int userNumber = readUserNumber();
        if ((userNumber != -1)
                && !(userNumber <= model.getMinBarrier())
                && !(userNumber >= model.getMaxBarrier())) {
            int comparingResult = model.isNumbersEqual(userNumber);
            if (comparingResult == 0) {
                view.showMessage(View.CONGRATULATION_MESSAGE);
                view.showStatistics(model.getStatistics());
                return true;
            } else if (comparingResult > 0) {
                view.showMessage(View.HIGHER_NUMBER);
                model.setMaxBarrier(userNumber);
            } else {
                view.showMessage(View.LOWER_NUMBER);
                model.setMinBarrier(userNumber);
            }
        }
        return false;
    }

    public void setScanner(ScannerAdapter scanner) {
        this.scanner = scanner;
    }
}
