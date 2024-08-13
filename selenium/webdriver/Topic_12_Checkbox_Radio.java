package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Checkbox_Radio {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Default_Telerik_Checkbox() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");

        // Xác định phần tử checkbox (kiểu dữ liệu By)
        By dualSideheckbox = By.xpath("//label[text()='Rear side airbags']/preceding-sibling::span/input");
        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");

        // Chọn 2 checkbox này
        // Case 1: Nếu như app này mở ra mà checkbox đã chọn thì sao
        checkToElement(dualSideheckbox);

        // Case 2: Nếu như app mở ra mà checkbox chưa được chọn
        checkToElement(dualZoneCheckbox);

        // Verify checkbox đã được chọn thành công
        Assert.assertTrue(driver.findElement(dualSideheckbox).isSelected());
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());

        // Bỏ chọn 2 checkbox này
        uncheckToElement(dualSideheckbox);
        uncheckToElement(dualZoneCheckbox);

        // Verify checkbox đã được bỏ chọn thành công
        Assert.assertFalse(driver.findElement(dualSideheckbox).isSelected());
        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());
    }

    @Test
    public void TC_02_Default_Telerik_Radio() {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");

        By twoPetrolRadio = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        By twoDieselRadio = By.xpath("//label[text()='2.0 Diesel, 103kW']/preceding-sibling::span/input");

        // Click chọn 1 trong 2
        checkToElement(twoPetrolRadio);

        // Verify
        Assert.assertTrue(driver.findElement(twoPetrolRadio).isSelected());
        Assert.assertFalse(driver.findElement(twoDieselRadio).isSelected());

        // Click chọn 1 trong 2
        checkToElement(twoDieselRadio);

        // Verify
        Assert.assertFalse(driver.findElement(twoPetrolRadio).isSelected());
        Assert.assertTrue(driver.findElement(twoDieselRadio).isSelected());
    }

    @Test
    public void TC_03_Select_All_Checkbox() {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");

        List<WebElement> allCheckboxs = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));
        // 29

        // Chọn hết tất cả các checkbox trong màn hình đó
        for (WebElement checkbox : allCheckboxs) {
            if (!checkbox.isSelected()) {
                checkbox.click();
                sleepInSeconds(1);
            }
        }

        // Verify hết tất cả các checkbox
        for (WebElement checkbox : allCheckboxs) {
            Assert.assertTrue(checkbox.isSelected());
        }

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        // Sau khi refresh thì phải tìm lại các elements (fix StaleElementReferenceException)
        allCheckboxs = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));

        // Chọn 1 checkbox/ radio nào đó trong tất cả checkbox/ radio
        for (WebElement checkbox : allCheckboxs) {
            if (checkbox.getAttribute("value").equals("Heart Attack") && !checkbox.isSelected()) {
                checkbox.click();
                sleepInSeconds(1);
            }
        }
    }

    @Test
    public void TC_04_Custom_Radio() {
        driver.get("https://login.ubuntu.com/");

        // Case 1:
        // Dùng thẻ input để click => Thẻ input bị che bởi 1 element khác => FAILED
        // Webdriver click(): The elemnet must be visible, and ut must have a height and width greater than 0
        // isSelected only applies to input elements

        // Case 2:
        // Dùng thẻ div bên ngoài để click => Passed
        // Dùng thẻ div để verify => Failed

        // Case 3:
        // Dùng thẻ div bên ngoài để click => Passed
        // Dùng input để verify => Passed
        // 1 element mà cần define tới 2 locator thì sau này => Maintain mất nhiều thời gian hơn

        // Case 4:
        // Dùng thẻ input để click => JavascriptExecutor (JS)
        // Dùng input để verify => isSelected: only applies to input elements
        // Chỉ cần 1 locator
        // arguments[0] đại diện cho element
        By registerRadio = By.cssSelector("#id_new_user");

        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(registerRadio));
        sleepInSeconds(3);

        Assert.assertTrue(driver.findElement(registerRadio).isSelected());

        // interface Webdriver
        // interface JavascriptExecutor
        // Ép kiểu interfce qua kiểu interface khác
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void checkToElement(By byXpath) {
        // Nếu như element chưa được chọn thì mới click
        if (!driver.findElement(byXpath).isSelected()) {
            // Sử dụng JavaScript để click vào checkbox
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(byXpath));
            sleepInSeconds(2);
        }
    }

    public void uncheckToElement(By byXpath) {
        // Nếu như element được chọn rồi thì vào click lần nữa cho nó thành bỏ chọn
        if (driver.findElement(byXpath).isSelected()) {
            // Sử dụng JavaScript để click vào checkbox
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(byXpath));
            sleepInSeconds(2);
        }
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
