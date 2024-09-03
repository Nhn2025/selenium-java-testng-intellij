package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class Topic_01_Sample {

    //Unit Test
    @Test
    public void testGetRamdomNumber() {
        Topic_01_Sample sample = new Topic_01_Sample();
        int randomNumber = sample.getRamdomNumber();
        Assert.assertTrue(randomNumber >= 0 && randomNumber < 1000000);
    }

    // Component
    private int getRamdomNumber() {
        return new Random().nextInt(1000000);
    }
}
