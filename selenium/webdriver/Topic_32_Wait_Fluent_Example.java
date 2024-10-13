package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Topic_32_Wait_Fluent_Example {

    WebDriver driver;

    WebDriverWait explicitWait;

    FluentWait<WebDriver> fluentDriver;

    FluentWait<WebElement> fluentElement;

    FluentWait<String> fluentString;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        // Time - Default Polling Time: 0.5s
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Time - Polling: 0.3s
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(300));
    }

    @Test
    public void TC_01_() {
        // KHOI TAO
        fluentDriver = new FluentWait<WebDriver>(driver);

        fluentElement = new FluentWait<WebElement>(driver.findElement(By.cssSelector("")));

        fluentString = new FluentWait<String>("Hello world!");

        // SETTING
        // Tổng thời gian
        fluentDriver.withTimeout(Duration.ofSeconds(10));

        // Polling time
        fluentDriver.pollingEvery(Duration.ofMillis(300));

        // Ignore NoSuchElement exception
        fluentDriver.ignoring(NoSuchElementException.class);

        // Ignore TimeoutException
        fluentDriver.ignoring(TimeoutException.class);

        // CONDITION
        fluentDriver.until(new Function<WebDriver, Object>() { // new Function <T, V>
            @Override
            public Object apply(WebDriver webDriver) {
                return null;
            }
        });

        fluentDriver.until(new Function<WebDriver, String>() {
            @Override
            public String apply(WebDriver webDriver) {
                return webDriver.findElement(By.cssSelector("")).getText();
            }
        });

        fluentDriver.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(400))
                .ignoring(java.util.NoSuchElementException.class, TimeoutException.class)
                .until(new Function<WebDriver, Boolean>() {
                    @Override
                    public Boolean apply(WebDriver webDriver) {
                        return webDriver.findElement(By.cssSelector("")).isDisplayed();
                    }
                });
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
