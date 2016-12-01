package ua.training.views;

import java.util.ArrayList;

/**
 * View
 */
public class View {

    //Text constants
    public static final String BARRIER_MESSAGE = "Please, enter barriers of " +
            "range of numbers:";
    public static final String CONGRATULATION_MESSAGE = "Congratulations, " +
            "you winner!";
    public static final String LOWER_NUMBER = "Your number is lower than " +
            "hidden number.";
    public static final String HIGHER_NUMBER = "Your number is higher than " +
            "hidden number.";
    public static final String ERROR_INPUT_MESSAGE = "You have written not " +
            "correct values.";
    public static final String ERROR_AND_REPEAT_MESSAGE = ERROR_INPUT_MESSAGE
            + " Enter again";
    public static final String RANGE_MESSAGE = "Please, enter number in " +
            "range from ";

    /**
     * Outputs message in console stream
     * @param string message to output
     */
    public void showMessage(String string) {
        System.out.println(string);
    }

    /**
     * Outputs range message in console stream
     * @param string message to output
     * @param min min barrier of range
     * @param max max barrier of range
     */
    public void showMessageWithRange(String string, int min, int max) {
        System.out.println(string + min + " to " + max);
    }

    /**
     * Outputs statistics message in console stream
     * @param statistics list to output
     */
    public void showStatistics(ArrayList<Integer> statistics) {
        System.out.print("You have done " + statistics.size() + " approaches:");
        for (int number : statistics) {
            System.out.print(" " + number);
        }
    }

}
