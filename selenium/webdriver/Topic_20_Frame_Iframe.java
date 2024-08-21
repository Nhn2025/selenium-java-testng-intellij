package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_Frame_Iframe {

    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TC_01_Form_Site() {
        // Trang A
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        driver.findElement(By.cssSelector("div#imageTemplateContainer>img")).click();
        sleepInSeconds(5);

        // Iframe Element
        WebElement formIframe = driver.findElement(By.cssSelector("div#formTemplateContainer>iframe"));

        Assert.assertTrue(formIframe.isDisplayed());

//        Switch vào frame/ iframe trước khi thao tác với các element bên trong
//        driver.switchTo().frame(0);  index-không chính xác
//        driver.switchTo().frame("frame-one85593366"); id/name...-con số không có nghĩa

        driver.switchTo().frame(formIframe); // Dùng element

        // Ko tìm thấy element (element nằm trong iframe)
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Sophomore");
        sleepInSeconds(5);

        // Switch ra lại trang A
        driver.switchTo().defaultContent();

        // Thao tác với 1 element bên ngoài iframe (trong A)
        driver.findElement(By.cssSelector("nav.header--desktop-floater a[title='Log in']")).click();

        sleepInSeconds(3);

        driver.findElement(By.cssSelector("button#login")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(), "Username and password are both required.");

//        Chứa iframe - trang B
//        Từ A vào B
//        driver.switchTo().frame("frame-one85593366");
//        driver.findElement(By.cssSelector("")).click();
//
//        Từ B vào C
//        driver.switchTo().frame("frame-23232");
//        driver.findElement(By.cssSelector("")).click();
//
//        Từ C quay lại B
//        driver.switchTo().parentFrame();
//
//        Đang ở B
//
//        Từ B quay lại A
//        driver.switchTo().defaultContent();
    }

    @Test
    public void TC_02_KynaEnglish() {
        // Lưu ý: Trang web ngừng hoạt động (làm với tính chất tham khảo)
        /* driver.get("https://skills.kynaenglish.vn/");

        // Switch vào iframe chứa FanPage
        driver.switchTo().frame(driver.findElement(By.cssSelector("div.face-content>iframe")));

        // Verify followers number
        Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Kya.vn']/parent::div/following-sibling::div")).getText(), "169K followers");

        // Switch về trang Default/ Parent chứa iframe
        driver.switchTo().defaultContent();

        // Switch vào iframe WeChat
        driver.switchTo().frame("cs_chat_iframe");

        driver.findElement(By.cssSelector("div.button_bar")).click();
        sleepInSeconds(3);

        driver.findElement(By.cssSelector("input.input_name")).sendKeys("Join Wick");
        driver.findElement(By.cssSelector("input.input_phone")).sendKeys("09214287365");
        new Select(driver.findElement(By.cssSelector("select#serviceSelect"))).selectByVisibleText("TƯ VẤN TUYỂN SINH");
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("Đăng ký khoá học JAVA");
        sleepInSeconds(3);

        // Switch về trang Default/ Parent chứa iframe
        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys("Java");
        sleepInSeconds(3);
        driver.findElement(By.cssSelector("button.search-button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.content>h4")).getText(), "Lập trình Java trong 4 tuần");
        */
    }

    @Test
    public void TC_03_Frame_HDFC_Bank() {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");

        // Switch vào frame
        driver.switchTo().frame("login_page"); // Bằng name

        // Nhập vào User ID
        driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("luis_suarez");
        sleepInSeconds(3);

        // Click Continue
        driver.findElement(By.cssSelector("a.login-btn")).click();
        sleepInSeconds(3);

        // Switch về trang Default/ Parent chứa iframe
        // Do nhấn vào continue chuyển sang 1 trang khác
        // "CÓ" switch hay "KHÔNG" đều chạy được
        driver.switchTo().defaultContent();

        // Verify password hiển thị
        Assert.assertTrue(driver.findElement(By.id("keyboard")).isDisplayed());

        driver.findElement(By.cssSelector("input#keyboard")).sendKeys("123456789");
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
