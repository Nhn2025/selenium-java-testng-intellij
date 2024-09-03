package testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Skip {

    @BeforeClass
    public void init() {
        System.out.println("Pre-Condition for below testcases");
    }

    @Test(enabled = false)
    // Hoặc xoá luôn annotations
    public void Priority_01_SearchWithDate() {

    }

    @Test(enabled = false)
    public void Priority_02_SearchWithBilling() {

    }

    @Test
    public void Priority_03_SearchWithProduct() {

    }

    @AfterTest
    public void after() {
        System.out.println("Post-Condition for above testcases");
    }
}
