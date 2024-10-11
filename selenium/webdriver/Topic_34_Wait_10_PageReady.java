package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_34_Wait_10_PageReady {

    WebDriver driver;

    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Fail do trang mới thêm captcha
    @Test
    public void TC_01_Admin_NopCommerce() {
        driver.get("http://demo.nopcommerce/login?returnUrl=%2F");

        driver.findElement(By.cssSelector("input#Email")).clear();
        driver.findElement(By.cssSelector("input#Email")).sendKeys("nhu@automationfc.vn");

        driver.findElement(By.cssSelector("input#Password")).clear();
        driver.findElement(By.cssSelector("input#Password")).sendKeys("nhu@automationfc.vn");
        driver.findElement(By.cssSelector("button.login-button")).click();
        // Sleep cho hiện loading icon
        sleepInSeconds(2);

        Assert.assertTrue(isPageLoadedSuccess());

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".administration"))).click();
        Assert.assertTrue(isPageLoadedSuccess());

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[contains(@class,'fa-user')]/following-sibling::p"))).click();
        driver.findElement(By.xpath("//li[contains(@class,'menu-is-opening')]/a/p[contains(string(),'Customers')]")).click();
        Assert.assertTrue(isPageLoadedSuccess());

        driver.findElement(By.xpath("//i[contains(@class,'fa-book')]/following-sibling::p")).click();
        driver.findElement(By.xpath("//li[contains(@class,'menu-is-opening')]//p[contains(string(),'Products')]")).click();
        Assert.assertTrue(isPageLoadedSuccess());

        driver.findElement(By.xpath("//i[contains(@class,'fa-shopping-cart')]/following-sibling::p")).click();
        driver.findElement(By.xpath("//li[contains(@class,'menu-is-opening')]//p[contains(string(),'Orders')]")).click();
        Assert.assertTrue(isPageLoadedSuccess());

        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).isDisplayed());
    }

    // Tại sao dùng implicit cũng pass
    // Do nó có sẵn trong DOM
    // Chỉ cần wait tìm element
    @Test
    public void TC_02_OrangeHRM_API_Document() {
        driver.get("https://api.orangehrm.com/");

        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h1[text()='OrangeHRM REST API Documentation']"))));

        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='OrangeHRM REST API Documentation']")).isDisplayed());
    }

    public boolean waitAjaxLoadingInvisible() {
        return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ajaxBusy")));
    }

    public boolean isPageLoadedSuccess() {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        });
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
