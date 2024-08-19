package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Popup_01 {

    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Fixed_Popup_In_DOM_01() {
        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        sleepInSeconds(2);

        By loginPopup = By.cssSelector(".MuiPaper-root");

        // Kiểm tra Login popup đang hiển thị
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        // driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#account-input")).sendKeys("automationfc");
        driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("automationfc");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("automationfc");
        driver.findElement(By.xpath("//div[@class='forgot-password']/following-sibling::div//button[@type='submit']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("#notistack-snackbar")).getText(), "Bạn đã nhập sai tài khoản hoặc mật khẩu!");

        // Close popup
        driver.findElement(By.xpath("//h2[text()='Đăng nhập']//child::button")).click();
        sleepInSeconds(2);

        // Kiểm tra Login popup không hiển thị
        // Lưu ý: Trang đã bị đổi thành NOT_IN_DOM nên không verify được bằng display()
        // Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.findElements(By.cssSelector(".MuiPaper-root")).size(), 0);
    }

    @Test
    public void TC_02_Fixed_Popup_In_DOM_02() {
        driver.get("https://skills.kynaenglish.vn/dang-nhap");

        Assert.assertTrue(driver.findElement(By.cssSelector("div#k-popup-account-login-mb div.modal-content")).isDisplayed());

        driver.findElement(By.cssSelector("input#user-login")).sendKeys("automationfc@gmail.com");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#btn-submit-login")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(), "Sai tên đăng nhập hoặc mật khẩu");

        // Lưu ý: đổi UI mất nút close button
        // driver.findElement(By.cssSelector("button.k-popup-account-close")).click();
        // sleepInSeconds(3);

        // Kiểm tra popup ko còn hiển thị (invisible/ hidden)
        // Assert.assertFalse(driver.findElement(By.cssSelector("div#k-popup-account-login-mb div.modal-content")).isDisplayed());
    }

    @Test
    public void TC_03_Fixed_Popup_Not_In_DOM_02() {
        driver.get("https://tiki.vn/");

        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();
        sleepInSeconds(3);

        // Kiểm tra popup hiển thị
        Assert.assertTrue(driver.findElement(By.cssSelector("div.ReactModal__Content")).isDisplayed());

        // Bị che khuất nên click bằng JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(By.cssSelector("p.login-with-email")));
        sleepInSeconds(2);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//button[text()='Đăng nhập']")));
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='email']/parent::div/following-sibling::span[1]")).getText(), "Email không được để trống");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='password']/parent::div/following-sibling::span")).getText(), "Mật khẩu không được để trống");

        // Đóng popup
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(By.cssSelector("button.btn-close")));
        sleepInSeconds(2);

        // Khi cái popup đóng lại thì HTML ko còn trong DOM nữa

        // Không dùng isDisPlayed() kiểm tra không nằm trong DOM do findElement()
        // findElement should not be used to look for non-present elements
        // Assert.assertFalse(driver.findElement(By.cssSelector("div.ReactModal__Content")).isDisplayed());

        // findElements(By) and asert zero length respone instead
        // step nào cần kiểm tra không hiển thị -> set timeout lại 5 giây tìm element không hiển thị
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.findElements(By.cssSelector("div.ReactModal__Content")).size(), 0);
    }


    @Test
    public void TC_04_Fixed_Popup_Not_In_DOM_02() {
        driver.get("https://www.facebook.com/");

        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/parent::div")).isDisplayed());

        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInSeconds(2);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.findElements(By.xpath("//div[text()='Sign Up']/parent::div/parent::div")).size(), 0);
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
