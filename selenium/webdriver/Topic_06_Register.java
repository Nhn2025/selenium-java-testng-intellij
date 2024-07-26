package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_06_Register {

    WebDriver driver;

    String projectPath = System.getProperty("user.dir");

    String osName = System.getProperty("os.name");

    String username, password;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Register() {
        // Truy cập trang Register - https://demo.guru99.com/
        // Nhập vào 1 email bất kì (random)

        // Click Submit button
        // Get cái User/ Password lưu vào 1 biến
        username = driver.findElement(By.xpath("//td[text()=\"User ID :\"]/following-sibling::td")).getText();
        password = driver.findElement(By.xpath("//td[text()=\"Password :\"]/following-sibling::td")).getText();
    }

    @Test
    public void TC_02_Login() {
        // Truy cập trang login - https://demo.guru99.com/
        // Nhập Username/ Password ở màn hình Register
        driver.findElement(By.name("uid")).sendKeys(username);
        driver.findElement(By.name("uid")).sendKeys(password);

        // Click Login
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
