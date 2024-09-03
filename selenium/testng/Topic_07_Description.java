package testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Description {

    @BeforeClass
    public void init() {
        System.out.println("Pre-Condition for below testcases");
    }

    @Test(description = "JIRA#44559 - Search new Users")
    // Hiển thị ở trong Log/ Report HTML
    public void Priority_01_SearchWithDate() {

    }

    @Test(description = "JIRA#44560 - Add new User and Search")
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
