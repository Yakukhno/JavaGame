package ua.training.views;

import java.util.ArrayList;

public class View {

    public final String BARRIER_MESSAGE = "Please, enter barriers of range of numbers ";
    public final String CONGRATULATION_MESSAGE = "Congratulations, you winner!";
    public final String LOWER_NUMBER = "Your number is lower than hidden number.";
    public final String HIGHER_NUMBER = "Your number is higher than hidden number.";
    public final String ERROR_INPUT_MESSAGE = "You have written not correct values.";
    public final String RANGE_MESSAGE = "Please, enter number in range from ";

    public void showMessage(String string) {
        System.out.println(string);
    }

    public void showMessageWithRange(String string, int min, int max) {
        System.out.println(string + min + " to " + max);
    }

    public void showStatistics(ArrayList<Integer> statistics) {
        System.out.print("You have done " + statistics.size() + " approaches:");
        for (int number : statistics) {
            System.out.print(" " + number);
        }
    }

}
