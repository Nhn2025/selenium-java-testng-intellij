package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_02_Selenium_Locator_Exercise {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public void TC_01_ID() {
        driver.findElement(By.id("txtSearch"));
    }

    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("btn_face"));
    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("frmLogin"));
    }

    @Test
    public void TC_04_Link() {
        driver.findElement(By.linkText("chính sách"));
    }

    @Test
    public void TC_05_Partial_Link() {
        driver.findElement(By.partialLinkText("thỏa thuận"));
    }

    @Test
    public void TC_06_TagName() {
        driver.findElements(By.tagName("input"));
    }

    @Test
    public void TC_07_Css() {
        driver.findElement(By.cssSelector(".nopadding"));
    }

    @Test
    public void TC_08_Xpath() {
        driver.findElement(By.xpath("//input[@id='txtEmail']"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
