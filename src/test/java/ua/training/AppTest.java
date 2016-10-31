package ua.training;

import org.junit.Test;
import ua.training.models.Model;

import org.junit.Assert;

/**
 * Unit test for JavaGame.
 */
public class AppTest {

    @Test
    public void testRandomNumber() {
        Model model = new Model();
        model.setMinBarrier(0);
        model.setMaxBarrier(100);
        boolean checkRandom = true;
        for (int i = 0; i < 10000; i++) {
            int randomNumber = model.getRandomNumber();
            if ((randomNumber <= 0) || (randomNumber >= 100)) {
                checkRandom = false;
            }
        }
        Assert.assertTrue(checkRandom);
    }
}
