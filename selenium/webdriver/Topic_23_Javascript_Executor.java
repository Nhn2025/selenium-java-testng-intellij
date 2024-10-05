package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_23_Javascript_Executor {

    WebDriver driver;

    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        jsExecutor = (JavascriptExecutor) driver; // Ép kiểu

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Javascript_Executor() {
        // executeForBrowser("window.location = 'http://live.techpanda.org/'");
        navigateToUrlByJS("http://live.techpanda.org/");
        sleepInSeconds(5);

        String techPandaDomain = (String) executeForBrowser("return document.domain;");
        Assert.assertEquals(techPandaDomain, "live.techpanda.org");

        String homePageUrl = (String) executeForBrowser("return document.URL;");
        Assert.assertEquals(homePageUrl, "http://live.techpanda.org/");

        hightlightElement("//a[text()='Mobile']");

        // Không giống hành vi thực của End User
        clickToElementByJS("//a[text()='Mobile']");

        // Giả lập những hành vi thực của End User
        // driver.findElement(By.xpath("//a[text()='Mobile']")).click();

        hightlightElement("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");
        clickToElementByJS("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");

        Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));

        hightlightElement("//a[text()='Customer Service']");
        clickToElementByJS("//a[text()='Customer Service']");

        String customerTitle = (String) executeForBrowser("return document.title;");
        Assert.assertEquals(customerTitle, "Customer Service");

        scrollToBottomPage();

        hightlightElement("//input[@id='newsletter']");
        sendkeyToElementByJS("//input[@id='newsletter']", getEmailAddress());

        hightlightElement("//button[@title='Subscribe']");
        clickToElementByJS("//button[@title='Subscribe']");

        // Không nên dùng trong dự án
        // Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));
        Assert.assertTrue(isExpectedTextInInnerText("Thank you for your subscription."));

        navigateToUrlByJS("https://www.facebook.com/");

        // Tự động ép qua string
        Assert.assertEquals(executeForBrowser("return document.domain;"), "facebook.com");
    }

    @Test
    public void TC_02_HTML5_Message() {
        driver.get("https://sieuthimaymocthietbi.com/account/register");
        driver.findElement(By.xpath("//button[text()='Đăng ký']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(getElementValidationMessage("//input[@id='lastName']"), "Please fill out this field.");

        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Automation");
        driver.findElement(By.xpath("//button[text()='Đăng ký']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(getElementValidationMessage("//input[@id='firstName']"), "Please fill out this field.");

        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Testing");
        driver.findElement(By.xpath("//button[text()='Đăng ký']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(getElementValidationMessage("//input[@id='email']"), "Please fill out this field.");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("aa@bb@cc");
        driver.findElement(By.xpath("//button[text()='Đăng ký']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(getElementValidationMessage("//input[@id='email']"), "Please enter an email address.");
    }
    @Test
    public void TC_03_Techpanda_Create_Account() {
        navigateToUrlByJS("http://live.techpanda.org/");
        sleepInSecond(2);

        hightlightElement("//button[@title='Subscribe']");
        clickToElementByJS("//div[@id='header-account']//a[text()='My Account']");

        hightlightElement("//button[@title='Subscribe']");
        clickToElementByJS("//a[@title='Create an Account']");

        hightlightElement("//input[@id='firstname']");
        sendkeyToElementByJS("//input[@id='firstname']", "Nhu");

        hightlightElement("//input[@id='middlename']");
        sendkeyToElementByJS("//input[@id='middlename']", "Huynh");

        hightlightElement("//input[@id='lastname']");
        sendkeyToElementByJS("//input[@id='lastname']", "Duong");

        hightlightElement("//input[@id='email_address']");
        sendkeyToElementByJS("//input[@id='email_address']", getEmailAddress());

        hightlightElement("//input[@id='password']");
        sendkeyToElementByJS("//input[@id='password']", "123456789");

        hightlightElement("//input[@id='confirmation']");
        sendkeyToElementByJS("//input[@id='confirmation']", "123456789");

        hightlightElement("//span[text()='Register']");
        clickToElementByJS("//span[text()='Register']");

        Assert.assertTrue(isExpectedTextInInnerText("Thank you for registering with Main Website Store."));

        hightlightElement("//a[text()='Log Out']");
        clickToElementByJS("//a[text()='Log Out']");

        Assert.assertEquals(executeForBrowser("return document.domain;"), "live.techpanda.org");
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

    public Object executeForBrowser(String javaScript) {
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText() {
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void sleepInSecond(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor.executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
        sleepInSecond(3);
    }

    public void scrollToElementOnTop(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void scrollToElementOnDown(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
        return status;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public String getEmailAddress() {
        Random rand = new Random();
        return "kevinlamp" + rand.nextInt(99999) + "@gmail.net";
    }
}
