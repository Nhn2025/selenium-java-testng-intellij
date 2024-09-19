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
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
        // Css vs ID
        driver.findElement(By.cssSelector("#chkRight"));
        driver.findElement(By.cssSelector("input#chkRight"));
        driver.findElement(By.cssSelector("input[id='chkRight']"));

        // Css vs Class
        driver.findElement(By.cssSelector(".nopadding"));
        driver.findElement(By.cssSelector("div.nopadding"));
        driver.findElement(By.cssSelector("div[class='nopadding']"));

        // Css vs Name
        driver.findElement(By.cssSelector("input[name='txtPhone']"));

        // Css vs TagName
        driver.findElements(By.cssSelector("div"));

        // Css vs Link
        driver.findElement(By.cssSelector("a[href='https://alada.vn/chinh-sach-bao-mat.html']"));

        // Css vs Partial Link
        driver.findElement(By.cssSelector("a[href^='https://alada.vn']"));
    }

    @Test
    public void TC_08_Xpath() {
        // Xpath vs ID
        driver.findElement(By.xpath("//input[@id='txtEmail']"));

        // Xpath vs Class
        driver.findElement(By.xpath("//div[@class='nopadding']"));

        // Xpath vs Name
        driver.findElement(By.xpath("//input[@name='txtPhone']"));

        // Xpath vs TagName
        driver.findElements(By.xpath("//div"));

        // Xpath vs Link
        driver.findElement(By.xpath("//a[@href='https://alada.vn/chinh-sach-bao-mat.html']"));
        driver.findElement(By.xpath("//a[text()='Hợp tác giảng dạy']"));

        // Xpath vs Partial Link
        driver.findElement(By.xpath("//a[contains(@href, 'chinh-sach')]"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
