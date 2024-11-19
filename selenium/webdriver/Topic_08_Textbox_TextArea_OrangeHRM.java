package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_08_Textbox_TextArea_OrangeHRM {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void Login_01_OrangeHRM() {
        String firstName = "Automation", lastName = "FC";
        String userName = "auto" + new Random().nextInt(9999);
        String password = "Auto137^&*";

        String passportNumber = "555-666-777-8888";
        String passportComment = "Automation Fc\n Best T";

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Admin Employee
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        sleepInSeconds(4);

        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        sleepInSeconds(3);

        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        sleepInSeconds(3);
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);

        String employeeID = driver.findElement(By.xpath(
                "//label[text()='Employee Id']//parent::div/following-sibling::div/input")).getAttribute("value");

        driver.findElement(By.xpath("//p[text()='Create Login Details']/following-sibling::div//label")).click();
        sleepInSeconds(2);

        driver.findElement(By.xpath("//label[text()='Username']//parent::div/following-sibling::div/input")).sendKeys(userName);
        driver.findElement(By.xpath("//label[text()='Password']//parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//label[text()='Confirm Password']//parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(string(), 'Save')]")).click();
        sleepInSeconds(8);

        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']//parent::div/following-sibling::div/input")).getAttribute("value"), employeeID);

        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        sleepInSeconds(2);

        driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']//following-sibling::button[contains(string(), 'Add')]")).click();

        driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(passportNumber);
        driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).sendKeys(passportComment);

        driver.findElement(By.xpath("//button[contains(string(), 'Save')]")).click();
        sleepInSeconds(3);

        driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
        sleepInSeconds(2);

        Assert.assertEquals( driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"), passportNumber);
        Assert.assertEquals( driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"), passportComment);

        driver.findElement(By.cssSelector("span.oxd-userdropdown-tab")).click();
        sleepInSeconds(2);
        driver.findElement((By.xpath("//a[text()='Logout']"))).click();
        sleepInSeconds(2);

        // Normal Employee
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        sleepInSeconds(4);

        driver.findElement(By.xpath("//span[text()='My Info']")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']//parent::div/following-sibling::div/input")).getAttribute("value"), employeeID);

        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Employee Id']//parent::div/following-sibling::div/input")).isEnabled());

        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
        sleepInSeconds(2);

        Assert.assertEquals( driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"), passportNumber);
        Assert.assertEquals( driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"), passportComment);
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

    public String getmailAddress() {
        Random rand = new Random();
        return "automation" + rand.nextInt(99999) + "@gmail.net";
    }
}
