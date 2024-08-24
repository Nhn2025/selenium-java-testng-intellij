package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic_24_Upload_File {

    WebDriver driver;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Single_File() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadBy = By.cssSelector("input[name='files[]']");

        driver.findElement(uploadBy).sendKeys(hcmFilePath);
        sleepInSeconds(2);

        driver.findElement(uploadBy).sendKeys(hnFilePath);
        sleepInSeconds(2);

        driver.findElement(uploadBy).sendKeys(dnFilePath);
        sleepInSeconds(2);

        // Verify file loaded success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + hcmName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + hnName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + dnName + "']")).isDisplayed());

        List<WebElement> startButtons = driver.findElements(By.cssSelector("td>button.start"));

        // For-each
        for (WebElement starButton : startButtons) {
            starButton.click();
            sleepInSeconds(3);
        }

        // Classic for - cần kiểm tra điều kiện trước thì dùng
        /*
            for (int i = 0; i < startButtons.size(); i++) {
                startButtons.get(i).click();
                    sleepInSeconds(3);
            }
        */

        // Verify file uploaded success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + hcmName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + hnName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + dnName + "']")).isDisplayed());
    }

    @Test // 2 file = multiple file
    public void TC_02_Multiple_File() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadBy = By.cssSelector("input[name='files[]']");

        // Load 3 file cùng lúc - firefox bản mới có support
        // Lưu ý: Giới hạn tối đa kí tự
        driver.findElement(uploadBy).sendKeys(hcmFilePath + "\n" + hnFilePath + "\n" + dnFilePath);
        sleepInSeconds(2);

        // Verify file loaded success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + hcmName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + hnName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + dnName + "']")).isDisplayed());

        List<WebElement> startButtons = driver.findElements(By.cssSelector("td>button.start"));

        // For-each
        for (WebElement starButton : startButtons) {
            starButton.click();
            sleepInSeconds(3);
        }

        // Verify file uploaded success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + hcmName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + hnName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + dnName + "']")).isDisplayed());
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
