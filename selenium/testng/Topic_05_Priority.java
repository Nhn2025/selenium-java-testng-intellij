package testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Priority {

    @BeforeClass
    public void init() {
        System.out.println("Pre-Condition for below testcases");
    }

    // @Test(priority = 1) - (KHÔNG DÙNG)
    // Hoặc đặt tên theo alphabet (DÙNG)
    @Test
    public void Priority_01_SearchWithDate() {

    }

    @Test
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
