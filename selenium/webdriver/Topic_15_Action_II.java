package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_15_Action_II {

    WebDriver driver;
    Actions action;
    String osName = System.getProperty("os.name");
    Keys keys;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        action = new Actions(driver);
        keys = osName.startsWith("Windows") ?  Keys.CONTROL : Keys.COMMAND;
    }

    @Test
    public void TC_01_Click_And_Hold_Block () throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNumber = driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(allNumber.size(), 20);

        // Thao tác với nhiều element
        // System.out.println(allNumber.get(0).getText());

        action.clickAndHold(allNumber.get(0)) // Click vào số 1 và giữ chuột
                .moveToElement(allNumber.get(3)) // Di chuột tới số 4
                .release() // Nhả chuột trái ra - kết thúc cho sự kiện ClickAndHold()
                .perform(); // Thực thi các câu lệnh trên (nếu ko có thì ko thực thi)
        Thread.sleep(4000);

        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(allNumberSelected.size(), 4);
    }

    @Test
    public void TC_02_Click_And_Hold_Random() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNumber = driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(allNumber.size(), 20);

        // Nhấn phím Ctrl xuống (chưa nhả ra)
        action.keyDown(keys).perform();

        action.click(allNumber.get(0))
                .click(allNumber.get(3))
                .click(allNumber.get(7))
                .click(allNumber.get(10))
                .click(allNumber.get(13))
                .click(allNumber.get(17))
                .pause(Duration.ofSeconds(3))
                .perform();
        // 1 4 8 11 14 18

        // Nhả phím Ctrl ra
        action.keyUp(keys).perform();

        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(allNumberSelected.size(), 6);
    }

    @Test
    public void TC_03_Double_Click() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        // Cuộn trang để đưa phần tử vào vùng nhìn thấy
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[text()='Double click me']")));

        action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");
    }

    @Test
    public void TC_04_Right_Click() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        // Click chuột phải vào button
        action.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
        Thread.sleep(3000);

        By quitContextBy = By.cssSelector("li.context-menu-icon-quit");

        Assert.assertTrue(driver.findElement(quitContextBy).isDisplayed());

        // Hover mouse
        action.moveToElement(driver.findElement(quitContextBy)).perform();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-visible.context-menu-hover")).isDisplayed());

        // Click Quit
        action.click(driver.findElement(quitContextBy)).perform();
        Thread.sleep(3000);

        // Đóng alert
        driver.switchTo().alert().accept();

        Assert.assertFalse(driver.findElement(quitContextBy).isDisplayed());
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
