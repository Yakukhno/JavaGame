package ua.training.views;

public class View {

    public final String INITIAL_MESSAGE = "Hello, please, enter number between 0 and 100.";
    public final String CONGRATULATION_MESSAGE = "Congratulations, you winner!";
    public final String LOWER_NUMBER = "Your number is lower than hidden number.";
    public final String HIGHER_NUMBER = "Your number is higher than hidden number.";
    public final String ERROR_INPUT_MESSAGE = "You have written not integer number.";

    public void showMessage(String string) {
        System.out.println(string);
    }

}
