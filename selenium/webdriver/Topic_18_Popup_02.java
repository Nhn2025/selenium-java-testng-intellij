package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_18_Popup_02 {

    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Random_Not_In_DOM() {
        driver.get("https://www.javacodegeeks.com/");
        // sleep cứng 10s để bật popup
        sleepInSeconds(10);

        By newsletterPopup = By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none'])");

        // Nếu hiển thị thì nhảy vào Close nó đi
        // Luôn luôn chạy vì element luôn có trong HTML/ DOM
        if (driver.findElements(newsletterPopup).size() > 0 && driver.findElements(newsletterPopup).get(0).isDisplayed()) { // > 0 nghĩa là đã được gender ra nhưng chưa biết hiển thị hay không
            System.out.println("Popup hiển thị");
            driver.findElement(By.cssSelector("#dismiss-button")).click();
            sleepInSeconds(3);
        }

        // Nhập vào field Search dữ liệu
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile Testing Explained");

        // Click Search
        driver.findElement(By.cssSelector("button#search-submit")).click();
        sleepInSeconds(3);

        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Agile Testing Explained']")).isDisplayed());
    }

    @Test
    public void TC_02_Random_Not_In_DOM() {
        // Trang web đã đổi thành Not In DOM
        driver.get("https://vnk.edu.vn/");

//        By marketingPopup = By.cssSelector("div.tve-leads-conversion-onject");

//        if (driver.findElements(marketingPopup).size() > 0 && driver.findElements(marketingPopup).get(0).isDisplayed()) {
//            // if (driver.findElement(marketingPopup).isDisplayed()) {
//            driver.findElement(By.cssSelector("div.tve_ea_thrive_leads_form_close")).click();
//            sleepInSeconds(3);
//            System.out.println("Popup hiển thị");
//        } else
//            System.out.println("Popup ko hiển thị");

        findELement(By.xpath("//button[text()='Danh sách khóa học']")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector(".title-content>h1")).getText(), "LỊCh Khai GiẢNg ThÁNg 08");
    }

    // Step nào thao tác ở màn hình Home mới gọi hàm này
    // Đang thao tác tìm kiếm mà popup hiển thị
    public WebElement findELement(By locator) {
        // Nếu popup xuất hiện thì nó sẽ close đi
        if (driver.findElements(By.cssSelector("div.tve-leads-conversion-onject")).size() > 0 && driver.findElements(By.cssSelector("div.tve-leads-conversion-onject")).get(0).isDisplayed()) {
            driver.findElement(By.cssSelector("div.tve_ea_thrive_leads_form_close")).click();
            sleepInSeconds(3);
            System.out.println("Popup hiển thị");
        }
        return driver.findElement(locator);
    }

    @Test
    public void TC_03_Random_In_DOM() {
        // Trang đã chuyển thành In DOM
        driver.get("https://dehieu.vn/");

        By marketingPopup = By.cssSelector(".modal-content");

        // Nếu hiển thị thì nhảy vào Close nó đi
        // Luôn luôn chạy vì element luôn có trong HTML/ DOM
        if (driver.findElement(marketingPopup).isDisplayed()) {
            System.out.println("Popup hiển thị");

            int heightBrowser = driver.manage().window().getSize().getHeight();
            System.out.println("Browser height = " + heightBrowser);
            if (heightBrowser < 1920)
                ((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[@class='modal-header']//button")));
            else
                driver.findElement(By.xpath("//div[@class='modal-header']//button")).click();

            sleepInSeconds(3);
        }

        if (false) // Vào được thân hàm if diều kiện phải là true
                sleepInSeconds(5);
    }

    @AfterClass
    public void cleanBrowser() {
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
