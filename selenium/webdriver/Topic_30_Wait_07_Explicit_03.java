package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Topic_30_Wait_07_Explicit_03 {

    WebDriver driver;

    WebDriverWait explicitWait;

    String projectPath = System.getProperty("user.dir");

    String hcmName = "tho.jpg";

    String hnName = "avatar.jpg";

    String dnName = "sua.jpg";

    String hcmFilePath = projectPath + File.separator + "uploadFiles" + File.separator + hcmName;

    String hnFilePath = projectPath + File.separator + "uploadFiles" + File.separator + hnName;

    String dnFilePath = projectPath + File.separator + "uploadFiles" + File.separator + dnName;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void TC_01_AjaxLoading() {
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        By selectedDate = By.cssSelector("span#ctl00_ContentPlaceholder1_Label1");

        Assert.assertEquals(driver.findElement(selectedDate).getText(), "No Selected Dates to display.");

        driver.findElement(By.xpath("//a[text()='12']")).click();

        // Wait cho Loading Icon biến mất
        // div[id*='RadCalender1']>div.raDiv
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("body.demo-page>div.RadAjax>div.raDiv")));

        // .....
        Assert.assertEquals(driver.findElement(selectedDate).getText(), "Monday, August 12, 2024");
    }

    @Test
    public void TC_02_Upload_File() {
        driver.get("https://gofile.io/?t=uploadFiles");

        // Wait + Verify Spinner icon biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-border"))));

        // Wait + Click
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ajaxLink>button"))).click();

        // Wait + Verify Spinner icon biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-border"))));

        // Upload file bằng sendKeys
        // Cần vào thẳng thẻ input
        driver.findElement(By.cssSelector("input[type='file']")).sendKeys(hcmFilePath + "\n" + hnFilePath + "\n" + dnFilePath);

        // Wait + Verify Spinner icon biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-border"))));

        // Wait Progress Bar biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.progress"))));

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mainUploadSuccessLink a.ajaxLink"))).click();

        // Wait + Verify button Upload có tại từng hình được upload
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[text()='" + hcmName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[text()='" + hnName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[text()='" + dnName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']"))).isDisplayed());

        // Wait + Verify button Play có tại từng hình được play
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[text()='" + hcmName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Play']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[text()='" + hnName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Play']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[text()='" + dnName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Play']"))).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
