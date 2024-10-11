package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_25_Wait_02_Find_Element {

    WebDriver driver;

    WebDriverWait explicitWait;

    FluentWait fluentWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        // Implicit Wait
        // Timeout = 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_FindElement() {
        // Case 1 - Element được tìm thấy chỉ có 1
        // Sẽ không cần chờ hết timeout
        // Tìm thấy sẽ trả về 1 WebElement
        // Qua step tiếp theo
        System.out.println("Start step: " + getDayTimeNow());
        driver.findElement(By.cssSelector("input#email"));
        System.out.println("End step: " + getDayTimeNow());

        // Case 2 - Element được tìm thấy nhưng có nhiều hơn 1
        // Sẽ không cần chờ hết timeout
        // Lấy cái element đầu tiên dù có cả n node
        // Qua step tiếp theo
        System.out.println("Start step: " + getDayTimeNow());
        driver.findElement(By.cssSelector("input[type='text'],[type='password']")).sendKeys("nhu@gmail.com");
        System.out.println("End step: " + getDayTimeNow());

        // Case 3 - ELement không được tìm thấy
        // Chờ hết timeout là 10s
        // Trong thời gian 10s này cứ mỗi "nửa s" sẽ tìm lại 1 lần (polling)
        // Nếu tìm lại mà thấy thì cũng trả về element rồi qua step tiếp theo
        // Nếu tìm lại mà ko thấy thì đánh fail testcase và throw exception: "NoSuchElementException"
        // Các step còn lại ko chạy nữa
        System.out.println("Start step: " + getDayTimeNow());
        driver.findElement(By.cssSelector("input#not-found"));
        System.out.println("End step: " + getDayTimeNow());
    }

    @Test
    public void TC_02_FindElements() {
        List<WebElement> elementList;

        // Case 1 - Element được tìm thấy chỉ có 1
        // Ko cần chờ hết timeout 10s
        // Trả về List Element chứa đúng 1 element
        System.out.println("Start step: " + getDayTimeNow());
        elementList = driver.findElements(By.cssSelector("input#email"));
        System.out.println("List have: " + elementList.size()); // 1
        System.out.println("End step: " + getDayTimeNow());

        // Case 2 - Element được tìm thấy nhưng có nhiều hơn 1
        // Ko cần chờ hết timeout 10s
        // Trả về List Element chứa nhiều element
        System.out.println("Start step: " + getDayTimeNow());
        elementList = driver.findElements(By.cssSelector("input[type='text'],[type='password']"));
        System.out.println("List have: " + elementList.size()); // 2
        System.out.println("End step: " + getDayTimeNow());

        // Case 3 - ELement không được tìm thấy
        // Chờ hết timeout là 10s
        // Mỗi "nửa s" cũng tìm lại 1 lần (polling)
        // Nếu trong thời gian tìm lại mà thấy element thì cũng trả về List chứa các element đó
        // Nếu hết thời gian tìm lại mà ko thấy thì trả về List rỗng (empty) và không đánh fail testcase
        // Qua step tiếp theo
        System.out.println("Start step: " + getDayTimeNow());
        elementList = driver.findElements(By.cssSelector("input#not-found"));
        System.out.println("List have: " + elementList.size()); //0
        System.out.println("End step: " + getDayTimeNow());
    }

    @AfterClass
    public void afterClass() {
        // driver.quit();
    }

    public String getDayTimeNow() {
        Date date = new Date();
        return date.toString();
    }
}
