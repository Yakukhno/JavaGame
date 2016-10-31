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
        int randomNumber = model.getRandomNumber(1, 5);
        Assert.assertTrue((1 <= randomNumber) && (randomNumber < 5));
    }
}
