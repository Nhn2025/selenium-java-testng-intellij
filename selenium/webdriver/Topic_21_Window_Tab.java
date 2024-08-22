package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_21_Window_Tab {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Basic_Form() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInSeconds(3);

        // Switch để qua trang Google
        switchToWindowByTitle("Google");

        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Selenium");
        sleepInSeconds(3);

        // Switch để quay lại trang Basic form
        switchToWindowByID("Selenium WebDriver");

        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        sleepInSeconds(3);

        // Switch để quay lại trang Facebook
        switchToWindowByID("Facebook - login in or sign up");

        driver.findElement(By.cssSelector("input#email")).sendKeys("dam@gmail.com");
        sleepInSeconds(3);

        // Switch để quay lại trang Basic form
        switchToWindowByID("Selenium WebDriver");
    }

    // Làm với tính chất tham khảo - trang dừng hoạt động
  /*  @Test
    public void TC_02_KyaEnglish() {
        driver.get("https://skills.kynaenglish.vn/");

        driver.findElement(By.cssSelector("div.hotline img[alt='facebook']")).click();
        sleepInSeconds(3);

        switchToWindowByTitle("Kyan.vn | Ho Chi Minh City | Facebook");

        driver.findElement(By.cssSelector("form#login_popup_cta_form input[name='email']")).sendKeys("dam@gmail.com");
        sleepInSeconds(3);

        switchToWindowByTitle("Kyan.vn - Học online cùng chuyên gia");

        driver.findElement(By.cssSelector("div.hotline img[alt='facebook']")).click();
        sleepInSeconds(3);

        switchToWindowByTitle("Kyan.vn - Youtube");

        Assert.assertEquals(driver.findElements(By.cssSelector("div#inner-header-container yt-formatted-string#text")), "Kyna.vn");
    } */

    @Test
    public void TC_03_TechPanda() {
        driver.get("http://live.techpanda.org");

        String parentID = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        sleepInSeconds(3);

        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Samsung Galaxy has been added to comparison list.");

        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Sony Xperia has been added to comparison list.");

        driver.findElement(By.xpath("//a[text()='IPhone']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product IPhone has been added to comparison list.");

        driver.findElement(By.xpath("//span[text()='Compare']")).click();
        sleepInSeconds(3);

        switchToWindowByTitle("Product comparisons List - Magento Commerce");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.page-title>h1")).getText(),"COMPARE PRODUCTS");

        switchToWindowByTitle("Mobile");

        driver.findElement(By.cssSelector("input#search")).sendKeys("Samsung Galaxy");
        sleepInSeconds(3);

        closeAllWindowWithoutParent(parentID);
        sleepInSeconds(3);

        //...
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    // Switch đối với 2 tab hoặc 2 window
    public void switchToWindowByID(String expectedID) {
        // Lấy ra hết tất cả tab/ window ID
        Set<String> allIDs = driver.getWindowHandles();

        // Dùng vòng lapwh duyệt qua từng ID trong Set ở trên
        for (String id : allIDs)
            // Kiểm tra điều kiện trước
            if (!id.equals(expectedID)) {

                // Rồi mới switch sau
                driver.switchTo().window(id);
                break;
            }
    }

    // Switch đối với nhiều hơn 2 tab hoặc nhiều hơn 2 window
    public void switchToWindowByTitle(String expectedTitle) {
        // Lấy hết tất cả các ID của các window/ tab
        Set<String> allIDs = driver.getWindowHandles();

        // Dùng vòng lặp duyệt qua Set ID ở trên
        for (String id : allIDs) {
            // Cho switch vào từng cái ID trước
            driver.switchTo().window(id);
            sleepInSeconds(2);

            // Lấy ra title của tab window hiện tại
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle))
                break;
        }
    }

    public void closeAllWindowWithoutParent(String parentID) {
        Set<String> allIDs = driver.getWindowHandles();

        for (String id : allIDs)
            if (!id.equals(parentID))  {
                driver.switchTo().window(id);
                driver.close();
            }
        // Lần switch cuối ko đứng ở parent
        driver.switchTo().window(parentID);
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
