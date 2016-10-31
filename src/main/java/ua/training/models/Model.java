package ua.training.models;

import java.util.ArrayList;
import java.util.Random;

public class Model {

    private int secretNumber;
    private int minBarrier;
    private int maxBarrier;
    private ArrayList<Integer> statistics = new ArrayList<Integer>();

    public int isNumbersEqual(int userNumber) {
        statistics.add(userNumber);
        return (userNumber == secretNumber) ? 0 : (userNumber > secretNumber)
                ? 1 : -1;
    }

    public ArrayList<Integer> getStatistics() {
        return statistics;
    }

    public int getRandomNumber() {
        return minBarrier + new Random().nextInt(maxBarrier - minBarrier - 1) + 1;
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
