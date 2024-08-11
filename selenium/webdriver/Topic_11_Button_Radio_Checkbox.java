package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;

import java.awt.*;
import java.time.Duration;

public class Topic_11_Button_Radio_Checkbox {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Egov_Button() {
        driver.get("https://egov.danang.gov.vn/reg");

        WebElement registerButton = driver.findElement(By.cssSelector("input.egov-button"));

        // Verify button bị disible khi chưa click vào checkbox
        Assert.assertFalse(registerButton.isEnabled());

        driver.findElement(By.cssSelector("input#chinhSach")).click();
        sleepInSeconds(2);

        // Verify button khi enable khi click vào checkbox
        Assert.assertTrue(registerButton.isEnabled());

        // Lấy ra mã màu nền của button
        String registerBackgroundRGB = registerButton.getCssValue("background-color");
        System.out.println("Background color RGB = " + registerBackgroundRGB);

        //  Convert từ kiểu String (mã RGB) qua kiểu Color
        Color registerBackgroundColor = Color.fromString(registerBackgroundRGB);

        // Convert qua kiểu Hexa
        String registerBackgroundHexa = registerBackgroundColor.asHex();
        System.out.println("Background color Hexa = " + registerBackgroundHexa);
        System.out.println("Background color Hexa = " + registerBackgroundHexa.toUpperCase());
        System.out.println("Background color Hexa = " + registerBackgroundHexa.toLowerCase());

        // Convert qua viết thường
        registerBackgroundHexa = registerBackgroundHexa.toLowerCase();

        Assert.assertEquals(registerBackgroundHexa, "#ef5a00");

        // Rút gọn thành 1 dòng duy nhất
        Assert.assertEquals(Color.fromString(registerButton.getCssValue("background-color")).asHex().toLowerCase(), "#ef5a00");

        // 1 - Viết 1 hàm để tự convert qua Hexa
        // 2 - Dùng thư viện (Selenium Color) - thư viện khác Java
    }

    @Test
    public void TC_02_Fahasa_Button() {
        driver.get("https://www.fahasa.com/customer/account/create");

        // Chuyển qua tab Đăng nhập
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        sleepInSeconds(2);

        WebElement loginButton = driver.findElement(By.cssSelector("button.fhs-btn-login"));

        // Verify login button is disable
        Assert.assertFalse(loginButton.isEnabled());

        // Verify login button = background color
        System.out.println(loginButton.getCssValue("background-color"));
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(), "#000000");

        // Nhập Email/ Pass
        driver.findElement(By.cssSelector("input#login_username")).sendKeys("nhu@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");
        sleepInSeconds(2);

        // Verify login button is enable
        Assert.assertTrue(loginButton.isEnabled());

        // verify login button = background
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(), "#c92127");
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
