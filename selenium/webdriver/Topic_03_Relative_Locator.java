package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_03_Relative_Locator {

    WebDriver driver;

    String projectPath = System.getProperty("user.dir");

    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Relative() {
        driver.get("http://demo.nopcommerce/login");

        // Login button
        By loginButtonBy = By.cssSelector("button.login-button");
        WebElement loginButtonElement = driver.findElement(By.cssSelector("button.login-button"));

        // Remember Me checkbox
        By rememberMeCheckboxBy = By.id("RememberMe");

        // Forget password link
        WebElement forgotPasswordElement = driver.findElement(By.cssSelector("span.forgot-password"));

        // Password textbox
        By passwordTextBoxBy = By.cssSelector("input#Password");

       //   GUI (location/ position)
        WebElement rememberMeTextElement = driver
                .findElement(RelativeLocator.with(By.tagName("label"))
                .above(loginButtonBy)
                .toRightOf(rememberMeCheckboxBy)
                .toLeftOf(forgotPasswordElement)
                .below(passwordTextBoxBy)
                .near(forgotPasswordElement));
        System.out.println(rememberMeTextElement.getText());

        List<WebElement> allLinks = driver.findElements(RelativeLocator.with(By.tagName("a")));
        System.out.println(allLinks.size());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
