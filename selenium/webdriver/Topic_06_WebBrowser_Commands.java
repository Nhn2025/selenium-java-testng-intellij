package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
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
        checkboxs.get(1).click();

        driver.findElement(By.cssSelector("button#login")).click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
