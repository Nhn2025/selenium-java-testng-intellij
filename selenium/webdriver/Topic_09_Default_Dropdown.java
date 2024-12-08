package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Topic_09_Default_Dropdown {

    WebDriver driver;

    Select select;

    String firstName = "Kevin", lastName = "Lamping", emailAddress = getmailAddress();

    String companyName = "Selenium WebDriver", password = "123456";

    String day = "15", month = "November", year = "1950";

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();

//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--user-data-dir=C:/Users/ADMIN/AppData/Local/Google/Chrome/User Data/");
//        chromeOptions.addArguments("--profile-directory=Profile 27");
//        driver = new ChromeDriver(chromeOptions);

//        EdgeOptions edgeOptions = new EdgeOptions();
//        edgeOptions.addArguments("--user-data-dir=C:/Users/ADMIN/AppData/Local/Microsoft/Edge/User Data/");
//        edgeOptions.addArguments("--profile-directory=Profile 3");
//        driver = new EdgeDriver(edgeOptions);

        // Tắt location hiện lên
//        ChromeOptions option = new ChromeOptions();
//        options.addArguments("--disable-geolocation");
//        driver = new ChromeDriver(options);

//        FirefoxOptions option = new FirefoxOptions();
//        option.addPreference("geo.enabled", false);
//        option.addPreference("geo.provider.use_corelocation", false);
//        driver = new FirefoxDriver(option);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Register() {
        driver.get("https://demo.nopcommerce.com/register");
        driver.findElement(By.cssSelector("a.ico-register")).click();

        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);

        // Day Dropdown
        Select dayDropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));

        // Chọn ngày
        dayDropdown.selectByVisibleText(day);

        // Verify dropdown này là Single (ko phải Multiple)
        Assert.assertFalse(dayDropdown.isMultiple());

        // Verify số lượng item trong Dropdown này là 32 item
        Assert.assertEquals(dayDropdown.getOptions().size(), 32);

        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(month);
        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(year);

        driver.findElement(By.id("Email")).sendKeys(emailAddress);
        driver.findElement(By.id("Company")).sendKeys(companyName);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);

        driver.findElement(By.cssSelector("button#register-button")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
    }

    @Test
    public void TC_02_Login() {
        driver.get("https://demo.nopcommerce.com");

        // Logout
        driver.findElement(By.cssSelector("a.ico-logout")).click();

        // Login
        driver.findElement(By.cssSelector("a.ico-login")).click();
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("button.login-button")).click();
        sleepInSeconds(2);

        // Verify
        driver.findElement(By.className("ico-account")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), lastName);

        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), day);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(), month);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(), year);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), emailAddress);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), companyName);
    }

    @Test
    public void TC_03_Egov() {
        driver.get("https://egov.danang.gov.vn/reg");

        select = new Select(driver.findElement(By.cssSelector("select#thuongtru_tinhthanh")));
        select.selectByVisibleText("tỉnh Bình Thuận");
        sleepInSeconds(4);

        // Lấy ra được item vừa chọn và verify
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "tỉnh Bình Thuận");

        // Kiểm tra 1 dropdown là single hay multiple
        Assert.assertFalse(select.isMultiple());

        // Lấy ra tất cả các item bên trong dropdown quận/ huyện
        select = new Select(driver.findElement(By.cssSelector("select#thuongtru_quanhuyen")));
        List<WebElement> districtElements = select.getOptions();
        List<String> districtText = new ArrayList<String>();

        for (WebElement district : districtElements)
            districtText.add(district.getText());

        Assert.assertTrue(districtText.contains("thành phố Phan Thiết"));
        Assert.assertTrue(districtText.contains("huyện Tuy Phong"));
    }

    @Test
    public void TC_06_Rode() {
        driver.get("https://rode.com/en/support/where-to-buy");

        new Select(driver.findElement(By.cssSelector("select#country")))
                .selectByVisibleText("Vietnam");
        sleepInSeconds(3);

        driver.findElement(By.cssSelector("inout#map_search_query")).sendKeys("Ho Chi Minh");
        driver.findElement(By.xpath("//button[text()='Search']")).click();
        sleepInSeconds(3);

        List<WebElement> dealerBranches = driver.findElements(By.cssSelector("div.dealer_branch h4"));
        Assert.assertEquals(dealerBranches.size(), 16);

        //For-each
        for (WebElement dealerName : dealerBranches)
            System.out.println(dealerName.getText());

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
        return "kevinlamp" + rand.nextInt(99999) + "@gmail.net";
    }
}
