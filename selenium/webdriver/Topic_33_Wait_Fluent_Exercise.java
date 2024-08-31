package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Topic_33_Wait_Fluent_Exercise {

    WebDriver driver;

    WebElement webElement;

    FluentWait<WebDriver> fluentDriver;

    FluentWait<WebElement> fluentElement;

    private long fullTimeOutInSecond = 30;

    private long pollingTimeOutInMiliSecond = 300;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        fluentDriver = new FluentWait<WebDriver>(driver);

        // FluentWait<WebELement> sau khi mở lên chạy mới có -> khởi tạo phía dưới
    }

    @Test
    public void TC_01_Fluent_Wait() {
        driver.get("https://automationfc.github.io/dynamic-loading/");

        // driver.findElement(By.cssSelector("div#start>button")).click();

        waitAndFindElement(By.cssSelector("div#start>button")).click();

        // Chờ cho HelloWorld text hiển thị trong vòng 20s
        // Setting
//        fluentDriver.withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofMillis(100))
//                // không đánh fail sẽ quay lại tìm lại
//                .ignoring(NoSuchElementException.class);

        // Condition
//        fluentDriver.until(new Function<WebDriver, Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                return driver.findElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")).isDisplayed();
//            }
//        });

        // Condition
//        String helloText = fluentDriver.until(new Function<WebDriver, String>() {
//            @Override
//            public String apply(WebDriver driver) {
//                String text = driver.findElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")).getText();
//                System.out.println("Get text = " + text);
//                return text;
//            }
//        });

        String helloText = waitAndFindElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")).getText();
        Assert.assertEquals(helloText, "Hello World!");
    }

    @Test
    public void TC_02_Page_Ready() {
        driver.get("https://automationfc.github.io/fluent-wait/");

        WebElement countDownTime = driver.findElement(By.cssSelector("div#javascript_countdown_time"));

        fluentElement = new FluentWait<WebElement>(countDownTime);

        fluentElement.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .until(new Function<WebElement, Boolean>() {
                    @Override
                    public Boolean apply(WebElement webElement) {
                        String text = webElement.getText();
                        System.out.println(text);
                        return text.endsWith("00");
                    }
                });
    }

    public WebElement waitAndFindElement(By locator) {
        FluentWait<WebDriver> fluentDriver = new FluentWait<WebDriver>(driver);
        fluentDriver.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);

        return fluentDriver.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(locator);
            }
        });
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
