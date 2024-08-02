package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowser_Commands {
    // Các câu lệnh để thao tác vs Browser
    // driver.

    WebDriver driver;

    // Các câu lệnh thao tác vs Element
    // element.
    WebElement element;

    @BeforeClass
    public void beforeClass() {
        // Muốn dùng được thì phải khởi taọ
        // Nếu ko khởi tạo sẽ gặp lỗi: NullPointerException
        driver = new FirefoxDriver();
        driver =  new ChromeDriver();
        driver = new SafariDriver();
        driver = new InternetExplorerDriver();

        // driver = new OperaDriver(); Selenium 4 không support
        // driver = new HTMLUnit(); Headless browser
        // Từ năm 2016: Chrome/ Firefox có support chạy dạng headless
        // Headless: Crawl data (Data Analyst)/ Dev FE

        // Selenium ver 3/2/1
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Selenium ver 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_() {
        // Mở ra 1 URL bất kỳ
        driver.get("https://www.facebook.com/");

        // Nhiều hơn 1 thì nó sẽ đóng cái nó đang active
        driver.close();

        // Đóng browser (ko care bao nhiêu tab/ window)
        driver.quit();

        // 2 hàm này bị ảnh hưởng timeout của implicitWait
        // findElement/ findElements

        // Nó sẽ đi tìm vs loại By nào và trả về 1 element nếu như được tìm thấy
        // ko được tìm thấy: Fail tại step này - throw exception: NoSuchElement
        // Trả về 1 elemnt - nhiều thì chỉ trả thằng đầu tiên
        WebElement emailAddressTextbox = driver.findElement(By.id("email"));

        // Nó sẽ đi tìm vs loại By nào và trả về nhiều element nếu như được tìm thấy (List WebElement)
        // ko được tìm thấy - ko bị fail - trả về 1 List rỗng (0 element)
        List<WebElement> checkboxs = driver.findElements(By.xpath("//input[@type='checkbox']"));

        // Tại sao lại cần lấy dữ liệu ra làm gì ?
        // Dùng để lấy ra Url của màn hình/ page hiện tại đang dùng
        // Home Page
        driver.getCurrentUrl();

        // Lấy ra page sourse HTML/ CSS/ JS của page hiện tại
        // Verify 1 cách tương đối
        driver.getPageSource();
        driver.getPageSource().contains("The Apple and Google Play logos are trademarks of their respective owners");
        Assert.assertTrue( driver.getPageSource().contains("The Apple and Google Play logos are trademarks of their respective owners"));

        // Lấy ra title của page hiện tại
        driver.getTitle();

        // Lấy ra ID của cửa sổ/ tab hiện tại
        // Handle Window/ Tab
        driver.getWindowHandle();
        driver.getWindowHandles();

        // Cookies - Framwork
        driver.manage().getCookies();

        // Get ra những log ở Dev Tool - Framwork
        driver.manage().logs().get(LogType.DRIVER);

        // Apply cho việc tìm element (findElement và findElements)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Chờ cho page được load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // Set trước khi dùng vs thư viện JavascriptExecute
        // Inject 2 đoạn code JS vào trong Browser/ Element
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        // Selenium 4 mới có
        driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().timeouts().getScriptTimeout();
        driver.manage().timeouts().getPageLoadTimeout();

        // Chạy full màn hình
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        driver.manage().window().minimize();

        // Test Responsive (Resolution)
        driver.manage().window().setSize(new Dimension(1366, 768));

        driver.manage().window().getSize();

        // Set cho browser ở vị trí nào so với độ phân giải màn hình (run trên màn hình có kích thước bao nhiêu)
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().getPosition();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
