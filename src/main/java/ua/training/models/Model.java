package ua.training.models;

import java.util.Random;

/**
 * Created by Ivan on 30.10.2016.
 */
public class Model {

    private int hiddenNumber;

    public Model() {
        hiddenNumber = getRandomNumber(1, 100);
    }

    public int isEqual(int userNumber) {
        return (userNumber == hiddenNumber) ? 0 : (userNumber > hiddenNumber) ? 1 : -1;
    }

    public int getRandomNumber(int min, int max) {
        return min + new Random().nextInt(max - min);
    }

}
