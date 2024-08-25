package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_12_Driver_Info {

    WebDriver driver;

    @Test
    public void testDriverInformation() {
        driver = new FirefoxDriver();
        // Ở trên OS nào
        // Browser nào
        // Browser class nào
        // ID của driver là gì
        System.out.println(driver.toString());
        // FirefoxDriver: firefox on windows (f696147a-2f9f-4f83-9aa1-5f81aa231124)

        driver = new ChromeDriver();
        System.out.println(driver.toString());
        // ChromeDriver: chrome on windows (88201f2672a0281cfa7efcebe55cb76e)

        if(driver.toString().contains("firefox")) {
            // Scroll
        }
        driver.quit();
    }
}
