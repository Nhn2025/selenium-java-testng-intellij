package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_22_New_Driver {

    WebDriver userDriver; // User site

    WebDriver adminDriver; // Admin site

    String firstName = "Kevin", lastName = "Lamping", emailAddress = getmailAddress();

    String companyName = "Selenium WebDriver", password = "123456";

    String day = "15", month = "November", year = "1950";

    @BeforeClass
    public void beforeClass() {
        // Khi 1 driver/ browser được new lên thì ko nhận setting nào từ User
        // Profile empty (ko extension/ plugin/ setting)
        userDriver = new FirefoxDriver();
        System.out.println(userDriver.toString());
        userDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        adminDriver = new EdgeDriver();
        System.out.println(adminDriver.toString());
        adminDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Register() {
        // User
        userDriver.get("https://demo.nopcommerce.com/register");
        userDriver.findElement(By.cssSelector("a.ico-register")).click();

        userDriver.findElement(By.id("FirstName")).sendKeys(firstName);
        userDriver.findElement(By.id("LastName")).sendKeys(lastName);

        // Day Dropdown
        Select dayDropdown = new Select(userDriver.findElement(By.name("DateOfBirthDay")));

        // Chọn ngày
        dayDropdown.selectByVisibleText(day);

        // Verify dropdown này là Single (ko phải Multiple)
        Assert.assertFalse(dayDropdown.isMultiple());

        // Verify số lượng item trong Dropdown này là 32 item
        Assert.assertEquals(dayDropdown.getOptions().size(), 32);

        new Select(userDriver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(month);
        new Select(userDriver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(year);

        userDriver.findElement(By.id("Email")).sendKeys(emailAddress);
        userDriver.findElement(By.id("Company")).sendKeys(companyName);
        userDriver.findElement(By.id("Password")).sendKeys(password);
        userDriver.findElement(By.id("ConfirmPassword")).sendKeys(password);

        userDriver.findElement(By.cssSelector("button#register-button")).click();
        sleepInSeconds(3);

        Assert.assertEquals(userDriver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");

        // Admin
        adminDriver.get("https://admin-demo.nocommerce.com");

        adminDriver.findElement(By.cssSelector("input#Email")).clear();
        adminDriver.findElement(By.cssSelector("input#Email")).sendKeys("admin@yourstore.com");

        adminDriver.findElement(By.cssSelector("input#Password")).clear();
        adminDriver.findElement(By.cssSelector("input#Password")).sendKeys("admin");

        adminDriver.findElement(By.cssSelector("button.login-button")).clear();
        sleepInSeconds(5);

        // Check
        // ....

        // User
        userDriver.get("https://demo.nopcommerce.com/register");

        // Login
        userDriver.findElement(By.cssSelector("a.icon-login")).click();
        userDriver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        userDriver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        userDriver.findElement(By.cssSelector("button.login-button")).click();
        sleepInSeconds(5);
    }

    @Test
    public void TC_02_Login() {
        userDriver.get("https://demo.nopcommerce.com/");

        // Logout
        userDriver.findElement(By.cssSelector("a.ico-logout")).click();

        // Login
        userDriver.findElement(By.cssSelector("a.ico-login")).click();
        sleepInSeconds(2);
        userDriver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        userDriver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        userDriver.findElement(By.cssSelector("button.login-button")).click();
        sleepInSeconds(2);

        // Verify
        userDriver.findElement(By.className("ico-account")).click();
        sleepInSeconds(2);

        Assert.assertEquals(userDriver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), firstName);
        Assert.assertEquals(userDriver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), lastName);

        Assert.assertEquals(new Select(userDriver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), day);
        Assert.assertEquals(new Select(userDriver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(), month);
        Assert.assertEquals(new Select(userDriver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(), year);

        Assert.assertEquals(userDriver.findElement(By.cssSelector("input#Email")).getAttribute("value"), emailAddress);
        Assert.assertEquals(userDriver.findElement(By.cssSelector("input#Company")).getAttribute("value"), companyName);
    }

    @AfterClass
    public void afterClass() {
        adminDriver.quit();
        userDriver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getmailAddress() {
        Random rand = new Random();
        return "kevinlamp" + rand.nextInt(99999) + "@gmail.net";
    }
}
