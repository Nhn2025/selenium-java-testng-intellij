package webdriver;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;

import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Headers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Topic_13_Alert {

    WebDriver driver;

    WebDriverWait explicitWait;

    String projectLocation = System.getProperty("user.dir");
    String username = "admin";
    String password = "admin";

    By resultText = By.cssSelector("p#result");

    @BeforeClass
    public void beforeClass() {
        // driver = new FirefoxDriver();
         driver = new ChromeDriver();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Accept_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        // Chờ cho alert present
        // Nếu trong thời gian chờ mà xuất hiện thì tự switch vào
        // Nếu hết thời gian mà chưa xuất hiện thì mới fail
        // Vừa chờ + vừa switch
        // Tốt hơn không wait
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        sleepInSeconds(3);

        // Switch vào không có chờ
        // Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS Alert");

        // Khi mình accept/ cancel rồi thì alert sẽ mất luôn
        alert.accept();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(resultText).getText(), "You clicked an alert successfully");

        // Cancel alert: void dismiss();
        // Accept alert: void accept();
        // Get text trong Alert ra: String getText();
        // Nhập text vào Alert: void sendKeys(String keysToSend);

        // Phải switch mới thao tác được
        // driver.switchTo().alert();
        // driver.switchTo().frame(1);
        // driver.switchTo().window("");
    }

    @Test
    public void TC_02_Confirm_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        sleepInSeconds(2);

        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(alert.getText(), "I am a JS Confirm");

        alert.dismiss();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(resultText).getText(), "You clicked: Cancel");
    }

    @Test
    public void TC_03_Prompt_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        sleepInSeconds(3);

        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(alert.getText(), "I am a JS prompt");

        String text = "Selenium WebDriver";
        alert.sendKeys(text);
        sleepInSeconds(3);

        alert.accept();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(resultText).getText(), "You entered: " + text);
    }

    @Test
    public void TC_04_Authentication_ByPass_To_URL() {
        // Cách 1: Truyền thẳng user/ pass vào url
        // Trick - By pass
        // driver.get("https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth");
        // Assert.assertTrue(driver.findElement(
        //         By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());

        // Cách 2: Từ page A thao tác lên 1 element nó sẽ qua page B (cần phải thao tác vs Authen Alert trước)
        driver.get("https://the-internet.herokuapp.com/");

        String authenLinkUrl = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
        // https://the-internet.herokuapp.com/basic_auth

        // String[] authenArray = authenLinkUrl.split("//");
        // driver.get(authenArray[0] + "//" + username + ":" + password + "@" + authenArray[1]);
        driver.get(getAuthenAlertByUrl(authenLinkUrl, username, password));

        Assert.assertTrue(driver.findElement(
                 By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
    }

    @Test
    public void TC_05_Authentication_AutoIT() throws IOException {
        // Cách 2: Chỉ chạy được trên windows (AutoIT)
        // Không chạy trên Mac/ Linux (ko có AutoIT)
        // Mỗi browser cần 1 đoạn script khác nhau
        // Thực thi đoạn code AutoIT để chờ Alert xuất hiện
        // Sử dụng bắt buộc phải sử dụng ngoại lệ (throw hoặc try/ catch)
        Runtime.getRuntime().exec(new String[] { projectLocation + "\\autoIT\\authen_firefox.exe", "admin", "admin"});

        driver.get("https://the-internet.herokuapp.com/basic_auth");
        sleepInSeconds(5);

        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
    }

    @Test
    public void TC_06_Authentication_Selenium_4x() {
        // Cách 3:
        // Thư viện Alert ko sử dụng cho Authentication Alert được
        // Chrome DevTools Protocol (CDP) - Chrome/ Edge (Chromium)
        // Cốc cốc/ Opera/ Brave (Chromium) - Work Around
        // Get DevTool object
        DevTools devTools = ((HasDevTools) driver).getDevTools();

        // Start new session
        devTools.createSession();

        // Enable the Network domain of devtools
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Enable username/ password
        Map<String, Object> headers = new HashMap<String , Object>();
        String basicAuthen = "Basic" + new String(new Base64().encode(String.format("%s:%s", username, password).getBytes()));
        headers.put("Authozixation", basicAuthen);

        // Set to Header
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        driver.get("https://the-internet.herokuapp.com/basic_auth");

        Assert.assertTrue(driver.findElement(By.xpath(
                "//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public String getAuthenAlertByUrl(String url, String username, String password) {
        String[] authenArray = url.split("//");
        return authenArray[0] + "//" + username + ":" + password + "@" + authenArray[1];
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
