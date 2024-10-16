package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Topic_31_Wait_08_Mix_Implicit_Explicit {

    WebDriver driver;

    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_Only_Implicit_Found() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://web.facebook.com/");

        // Khi vào tìm element thì nó tìm thấy ngay
        // Ko cần chờ hết timeout
        driver.findElement(By.cssSelector("input#email"));
    }

    @Test
    public void TC_02_Only_Implicit_Not_Found() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://web.facebook.com/");

        // Khi vào tìm element sẽ không tìm thấy
        // Polling mỗi nửa giây tìm lại 1 lần
        // Khi hết timeout sẽ đánh fail testcase và throw exception: NoSuchElementException
        driver.findElement(By.cssSelector("input#automation"));
    }

    @Test
    public void TC_03_Only_Explicit_Found() {
        driver.get("https://web.facebook.com/");

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
    }

    @Test
    public void TC_04_Only_Explicit_Not_Found_Param_By() {
        driver.get("https://web.facebook.com/");

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Khi vào tìm element sẽ không tìm thấy
        // Polling mỗi nửa giây tìm lại 1 lần
        // Khi hết timeout sẽ đánh fail testcase và throw exception: TimeoutException
        // TimeoutException: Expected condition failed: waiting for visibility of element located by By.cssSelector
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#automation")));
    }

    @Test
    public void TC_05_Only_Explicit_Not_Found_Param_WebElement() {
        driver.get("https://web.facebook.com/");

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Khi vào tìm element sẽ không tìm thấy
        // Polling mỗi nửa giây tìm lại 1 lần
        // Khi hết timeout sẽ đánh fail testcase và throw exception: NoSuchElementException

        System.out.println("Start time: " + getDateTimeNow());
        try {
            explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#automation"))));
        } catch (Exception e) {
            System.out.println("End time: " + getDateTimeNow());
            e.printStackTrace();
        }
    }

    @Test
    public void TC_06_Mix_Implicit_Explicit() {
        driver.get("https://web.facebook.com/");

        // < = > chung 1 công thức
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        System.out.println("Start time: " + getDateTimeNow());
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#automation")));
        } catch (Exception e) {
            System.out.println("End time: " + getDateTimeNow());
            e.printStackTrace();
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public String getDateTimeNow() {
        Date date = new Date();
        return date.toString();
    }
}
