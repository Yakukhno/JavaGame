package ua.training.models;

import java.util.ArrayList;
import java.util.Random;

/**
 * Model
 */
public class Model {

    /**
     * Number, which user have to guess
     */
    private int secretNumber;

    /**
     * Minimal barrier of range
     */
    private int minBarrier;

    /**
     * Maximal barrier of range
     */
    private int maxBarrier;

    /**
     * List of integers, which consists user's approaches
     */
    private ArrayList<Integer> statistics = new ArrayList<Integer>();

    /**
     * Checks for user and secret number equality
     * @param userNumber number, which user have inputted
     * @return 0 if numbers are equal,
     * 1 if user's number more than secret number,
     * -1 if user's number less than secret number
     */
    public int isNumbersEqual(int userNumber) {
        statistics.add(userNumber);
        return (userNumber == secretNumber) ? 0 : (userNumber > secretNumber)
                ? 1 : -1;
    }

    /**
     * Generates random number in specified range
     * @return random number in range between minBarrier and maxBarrier
     */
    public int getRandomNumber() {
        return minBarrier + new Random().nextInt(maxBarrier - minBarrier - 1) + 1;
    }

    //Getters, setters

    public ArrayList<Integer> getStatistics() {
        return statistics;
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public void setMinBarrier(int minBarrier) {
        this.minBarrier = minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public void setMaxBarrier(int maxBarrier) {
        this.maxBarrier = maxBarrier;
    }

    public void setSecretNumber(int secretNumber) {
        this.secretNumber = secretNumber;
    }
}
