package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_29_Wait_06_Explicit_02 {

    WebDriver driver;

    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_Equal_5_Second() {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        // Wait cho loading Icon biến mất trong vòng x giây
        // explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));

        // Wait cho cái HelloWord text xuất hiện
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
    }

    @Test
    public void TC_02_Less_Than_5_Second() {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        // Wait cho loading Icon biến mất trong vòng x giây
        // explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));

        // Wait cho cái HelloWord text xuất hiện
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
    }

    @Test
    public void TC_03_Getter_Than_5_Second() {
        // Nếu tìm thấy không chờ hết 100s
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(100));

        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        // Wait cho loading Icon biến mất trong vòng x giây
        // explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));

        // Wait cho cái HelloWord text xuất hiện
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
