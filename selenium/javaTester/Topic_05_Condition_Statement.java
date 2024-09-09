package javaTester;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_05_Condition_Statement {

    WebDriver driver;

//    @Test
    public void TC_01_If() {
        boolean status = 5 > 3;
        System.out.println(status);

        // Hàm if sẽ nhận 1 điều kiện đúng
        // Kiểm tra duy nhất 1 điều kiện
        // Nếu điều kiện này đúng thì sẽ action (xxx) trong thân hàm
        if (status) {
            // Đúng thì vào thân của if
            // Sai thì bỏ qua
            System.out.println("Go to if");
        }

        // Gán (assign)
        int studentNumber = 10;

        // == So sánh
        status = (studentNumber == 10);
        System.out.println(status);

        WebDriver driver = new FirefoxDriver();

        WebElement salePopup = driver.findElement(By.id(""));
        // Element luôn luôn có trong DOM dù popup hiển thị hay không
        if (salePopup.isDisplayed()) {

        }

        // Element ko có trong DOM khi popup ko hiển thị
        List<WebElement> salePopups = driver.findElements(By.id(""));

        // Check element ko hiển thị
        if (salePopups.size() > 0 && salePopups.get(0).isDisplayed()) {

        }

        // Uncheck to checkbox
        WebElement languagesCheckbox = driver.findElement(By.id(""));
        if (languagesCheckbox.isSelected()) {
            languagesCheckbox.click();
        }

        // Check to checkbox
        if (!languagesCheckbox.isSelected()) {
            languagesCheckbox.click();
        }
    }

//    @Test
    public void TC_02_If_Else() {
        // Có tới 2 điều kiện: nếu đúng thì vào if, sai vào else

        // Nếu driver start vs browser như Chrome/ Frirefox/ Safari/ Edge thì dùng hàm click
        // thông ường (builtin) của Selenium Web

        // Nếu driver là IE thì dùng hàm click của JavascriptExecutor
        // driver = new InternetExplorerDriver();

        // System.out.println(driver.toString());

        driver = new ChromeDriver();

        if (driver.toString().contains("internet explorer")) {
            System.out.println("CLick by Javascript Executor");
        } else {
            System.out.println("Click by Selenium WebElement");
        }
    }

    // Chạy qua xml do không biết parameter
    @Parameters("browser")
    // @Test
    public void TC_03_If_Else_If_ELse(String browserName) {
        // Có nhiều điều kiện
        // Best Practice: ko nên if-else quá nhiều

        if (browserName.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else if (browserName.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        else if (browserName.equalsIgnoreCase("edge"))
            driver = new EdgeDriver();
        else if (browserName.equalsIgnoreCase("ie"))
            driver = new InternetExplorerDriver();
        else
            throw new RuntimeException("Please input correct the browser name");

        System.out.println(browserName);
        System.out.println(driver.toString());

        driver.quit();
    }

    @Test
    public void Tc_04_If_Else_If_Else() {
        // Page Object
        // Dynamic Page

        String pageName = "Login";

        if (pageName.equals("Login")) {
            // LoginPage loginPage = new LoginPage()
            // return loginPage;
        } else if (pageName.equals("Register")) {
            // RegisterPage registerPage = new RegisterPage()
            // return registerPage;
        } else if (pageName.equals("New Customer")) {
            // CustomerPage customerPage = new CustomerPage()
            // return customerPage;
        } else {
            // HomePage homePage = new HomePage()
            // return homePage;
        }

        // if-else
        int age = 20;
        String access = (age < 18) ? "You can not access" : "Welcome to our system";

        if (age < 18) {
            access = "You can not access";
        } else {
            access = "Welcome to our system!";
        }

        System.out.println(access);
    }
}
