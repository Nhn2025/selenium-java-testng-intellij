package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_06_Switch_Case {

    Scanner sc = new Scanner(System.in);
    WebDriver driver;

    // Chạy qua xml do không biết parameter
    @Parameters("browser")
    //@Test
    public void TC_03_If_Else_If_ELse(String browserName) {
        driver = getBrowserDriver(browserName);
        System.out.println(browserName);

        driver.quit();
    }

    //@Test
    public void TC_02() {
        int month = sc.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng này có 31 ngày");
                break;
            case 2:
                System.out.println("Tháng này có 28 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng này có 30 ngày");
                break;
            default:
                System.out.println("Vui lòng nhập tháng trong khoảng 1-12");
                break;
        }
    }

    //@Test
    public void TC_03() {
        int number = sc.nextInt();
        switch (number) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("Nine");
                break;
            case 10:
                System.out.println("Ten");
                break;
        }
    }

    // Ưu điểm và ngược điểm của if và switch-case
    // If: Khó để đọc code (readable)
    // Ko check trùng lặp
    // Switch-case: chỉ nhận int/ string/ enum
    // Ko dùng với toán tử trong case: = <> != ==

    @Test
    public void TC_04() {
        String opertor = sc.nextLine();
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();

        System.out.println(firstNumber);
        System.out.println(secondNumber);
        System.out.println("--" + opertor + "--");

        switch (opertor) {
            case "+":
                System.out.println(" A + B = " + (firstNumber + secondNumber));
                break;
            case "-":
                System.out.println(" A - B = " + (firstNumber - secondNumber));
                break;
            case "*":
                System.out.println(" A * B = " + (firstNumber * secondNumber));
                break;
            case "/":
                System.out.println(" A / B = " + (firstNumber / secondNumber));
                break;
            case "%":
                System.out.println(" A % B = " + (firstNumber % secondNumber));
                break;
        }
    }

    public WebDriver getBrowserDriver(String browserName) {
        switch(browserName) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            default:
                new RuntimeException("Please input correct the browser name");
                break;
        }
        return driver;
    }

}
