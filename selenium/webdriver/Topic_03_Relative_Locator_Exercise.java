package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_Relative_Locator_Exercise {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Relative_Locator() {
        driver.get("http://live.techpanda.org/index.php/catalogsearch/advanced/");

//        // 1 - Khai báo biến
//        // Khi dữ liệu này được sử dụng nhiều lần = tái sử dụng (Reuseable)
//        String emailAddress = "automationtest@gmail.com";
//        By emailTextboxBy = By.cssSelector("");
//        WebElement emailTextboxElement = driver.findElement(emailTextboxBy);
//
//        emailTextboxElement.clear();
//        emailTextboxElement.isDisplayed();
//        emailTextboxElement.sendKeys("");
//
//        // 2 - Không khai báo biến
//        // Khi chỉ dùng 1 lần
//        driver.findElement(emailTextboxBy).sendKeys("");

        WebElement priceFromELement = driver.findElement(RelativeLocator.with(By.tagName("input"))
                .toLeftOf(By.name("price[to]"))
                .below(By.id("sku"))
                .above(By.id("tax_class_id")));

        priceFromELement.sendKeys("100");
    }

    @Test
    public void TC_02_NopCommerce_Register() {
        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");

        // Gender
        driver.findElement(By.xpath("//label[contains(text(), 'Gender')]"));

        // Male
        driver.findElement(By.xpath("//span[@class='male']"));

        // Female
        driver.findElement(By.xpath("//span[@class='female']"));

        // First name Label
        driver.findElement(By.xpath("//label[contains(text(), 'First name')]"));

        // First name Text box
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        // Last name Label
        driver.findElement(By.xpath("//label[contains(text(), 'Last name')]"));

        // Last name Text box
        driver.findElement(By.xpath("//input[@id='LastName']"));

        // Date of birth Label
        // NopCommerce trên localhost khác UI trên web (web bổ sung ngày sinh)
        // driver.findElement(By.xpath("//label[contains(text(), 'Date of birth')]"));

        // Day Select
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));

        // Month Select
        // driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));

        // Year Select
        // driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));

        // Email Label
        driver.findElement(By.xpath("//label[contains(text(), 'Email')]"));

        // Email Text box
        driver.findElement(By.xpath("//input[@id='Email']"));

        // Company Label
        driver.findElement(By.xpath("//label[contains(text(), 'Company name')]"));

        // Company Text box
        driver.findElement(By.xpath("//input[@id='Company']"));

        // Newsletter Label
        driver.findElement(By.xpath("//label[contains(text(), 'Newsletter')]"));

        // Newsletter Checkbox
        driver.findElement(By.xpath("//input[@id='Newsletter']"));

        // Password Label
        driver.findElement(By.xpath("//label[contains(text(), 'Password')]"));

        // Password Text box
        driver.findElement(By.xpath("//input[@id='Password']"));

        // Confirm Password Label
        driver.findElement(By.xpath("//label[contains(text(), 'Confirm password')]"));

        // Confirm Password Text box
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));

        // Register button
        driver.findElement(By.xpath("//button[@id='register-button']"));
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
