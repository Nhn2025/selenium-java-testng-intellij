package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_19_Shadow_DOM {

    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_shadow_DOM() {
        driver.get("https://automationfc.github.io/shadow-dom/");
        sleepInSeconds(5);

        // Đi theo đúng cấu trúc của HTML (từ HTML bên ngoài)
        // 1. Get cái chứa shadow host (div#shadow_host)
        // 2. Từ cái get ra tìm vào (tính những cái thuộc shadow root)

        // driver = đại diện cho cái Real DOM (DOM bên ngoài)
        WebElement shadowHostElement = driver.findElement(By.cssSelector("div#shadow_host"));

        // shadowRootContext = đại diện cho cái shadow DOM 1 bên trong
        // Trả về Search Context
        SearchContext shadowRootContext = shadowHostElement.getShadowRoot();

        String someText = shadowRootContext.findElement(By.cssSelector("span#shadow_content span")).getText();
        System.out.println(someText);
        Assert.assertEquals(someText, "some text");

        WebElement checkboxShadow = shadowRootContext.findElement(By.cssSelector("input[type='checkbox']"));
        Assert.assertFalse(checkboxShadow.isSelected());

        // shadowRootContext không support xpath
        // Phải dùng với locator là cssSelector
        List<WebElement> allInput = shadowRootContext.findElements(By.cssSelector("input"));
        System.out.println(allInput.size());

        // nestedShadowHostElement đại diện cho cái nested shadow DOM 2 (nằm bên trong shadow DOM 1)
        WebElement nestedShadowHostElement = shadowRootContext.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext nestedShadowRootContext = nestedShadowHostElement.getShadowRoot();

        String nestedText = nestedShadowRootContext.findElement(By.cssSelector("div#nested_shadow_content>div")).getText();
        Assert.assertEquals(nestedText, "nested text");
    }

    @Test
    public void TC_02_shadow_DOM_Shopee() {
      /*  driver.get("https://shopee.vn/");
        sleepInSeconds(5);

        WebElement shadowHostElement = driver.findElement(By.cssSelector("shopee-banner-popup-stateful"));
        SearchContext shadowRootContext = shadowHostElement.getShadowRoot();

        // 2 trường hợp có thể xảy ra
        // Nếu có popup hiển thị thì close đi và qua step tiếp theo
        // Nếu ko có popup hiển thị thì qua step tiếp theo luôn

        // Verify popup hiển thị
        if (shadowRootContext.findElements(By.cssSelector("div.home-popup__content")).size() > 0
                && shadowRootContext.findElements(By.cssSelector("div.home-popup__content")).get(0).isDisplayed()) {
            // Click để close popup
            shadowRootContext.findElement(By.cssSelector("div.shopee-popup__close-btn")).click();
            sleepInSeconds(3);
        }

        // Ko hiển thị/ đã bị đóng rồi qua step Search dữ liệu
        // Ko còn nằm trong shadow nên dùng driver bình thường
        driver.findElement(By.cssSelector("input.shopee-searchbar-input__input")).sendKeys("iPhone 15 Pro Max");
        sleepInSeconds(3);

        driver.findElement(By.cssSelector("button.shopee-searchbar__search-button")).click();
        sleepInSeconds(3);
       */
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
