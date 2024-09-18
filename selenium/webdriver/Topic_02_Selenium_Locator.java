package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {

    WebDriver driver;

    String projectPath = System.getProperty("user.dir");

    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demo.nopcommerce.com/register");
    }

    @Test
    public void TC_01_ID() {
        // Tìm elemnent có id là FirstName
        driver.findElement(By.id("FirstName"));
    }

    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("DateOfBirthDay"));
    }

    @Test
    public void TC_04_TagName() {
        // Tìm nhiều element giống nhau
        driver.findElements(By.tagName("Input"));
    }

    @Test
    public void TC_05_LinkText() {
        //Độ chính xác cao = tuyệt đối = toàn bộ
        driver.findElements(By.linkText("Shipping & returns"));
    }

    @Test
    public void TC_06_Partial_LinkText() {
        // Chỉ dùng với đường link có text
        // Truyền hết cả chuỗi text vào cũng chạy được
        // Truyền 1 phần chuỗi text vào cũng chạy được
        // Độ chính xác không cao = tương đối = 1 phần (đầu, giữa, cuối)
        driver.findElements(By.partialLinkText("vendor account"));
    }

    @Test
    public void TC_07_CSS() {
        // Css vs ID
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));

        // Css vs Class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        // NGOẠI LỆ (class nhiều giá trị bên trong phân cách khoảng trắng)
        // Nhiều class chỉ lấy 1 class (khi viết tắt)
        // Nghĩ " " đi qua nhiều thẻ
        // Hoặc cách nhau bằng .
        driver.findElement(By.cssSelector(".input-text.required-entry"));

        // Css vs Name
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        // Css vs TagName
        driver.findElement(By.cssSelector("input"));

        // Css vs Link
        // Css ko dùng được với text
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));

        // Css vs Partial Link
        driver.findElement(By.cssSelector("a[href*='addresses']"));
//        driver.findElement(By.cssSelector("a[href^='addresses']"));
        driver.findElement(By.cssSelector("a[href$='addresses']"));
    }

    @Test
    public void TC_08_XPath() {
        // XPath vs ID
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        // XPath vs Class
        driver.findElement(By.xpath("//div[@class='page-title']"));

        // XPath vs Name
        driver.findElement(By.xpath("//input[@name='FirstName']"));

        // XPath vs TagName
        driver.findElement(By.xpath("//input"));

        // XPath vs Link
        driver.findElement(By.xpath("//a[@href='/customer/addresses']"));
        driver.findElement(By.xpath("//a[text()='Addresses']"));

        // XPath vs Partial Link
        // Xpath không support với ends-with (Css có)
        driver.findElement(By.xpath("//a[contains(@href,'addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
