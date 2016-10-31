package ua.training.models;

import java.util.Random;

public class Model {

    private int hiddenNumber;
    private int minMark;
    private int maxMark;

    public Model() {
        hiddenNumber = getRandomNumber(0, 100);
        minMark = 0;
        maxMark = 100;
    }

    public int isNumbersEqual(int userNumber) {
        return (userNumber == hiddenNumber) ? 0 : (userNumber > hiddenNumber)
                ? 1 : -1;
    }

    public int getRandomNumber(int min, int max) {
        return min + new Random().nextInt(max - min);
    }

    public int getMinMark() {
        return minMark;
    }

    public void setMinMark(int minMark) {
        this.minMark = minMark;
    }

    public int getMaxMark() {
        return maxMark;
    }

    public void setMaxMark(int maxMark) {
        this.maxMark = maxMark;
    }
}
