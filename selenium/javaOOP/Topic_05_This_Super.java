package javaOOP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_05_This_Super extends  BaseOOP {
//    private int firstNumber;
//    private int secondNumber;
//
//    public Topic_05_This_Super() {
//        // This phải đứng đầu tiên
//        this(10, 15);
//    }
//
//    public Topic_05_This_Super(int firstNumber, int secondNumber) {
//        this.firstNumber = firstNumber;
//        this.secondNumber = secondNumber;
//    }
//
//    public void sumNumber() {
//        System.out.println(firstNumber + secondNumber);
//    }
//
//    public void showNumber() {
//        this.sumNumber();
//    }
//
//    public static void main(String[] args) {
//        Topic_05_This_Super topic = new Topic_05_This_Super(15, 7);
//        topic.sumNumber();
//    }
    private WebDriver driver;

    // Global
    private long shortTimeout = 15;
    private  long longTimeOut = 45;

    public Topic_05_This_Super() {
        // Luôn luôn gọi qua Constructor của Class cha
        // Có nghĩa khi tùy chọn gọi qua constructor nào
        super("Chrome");
        System.out.println("Constructor của Class con");
    }

    public void setImplicitWait() {
        // Local
//        long shortTimeout = 15;

        driver.manage().timeouts().implicitlyWait(super.longTimeOut, TimeUnit.SECONDS);

        System.out.println(super.browserName);
//        driver.manage().timeouts().implicitlyWait(shortTimeout, TimeUnit.SECONDS);
//
//        driver.manage().timeouts().implicitlyWait(this.shortTimeout, TimeUnit.SECONDS);
    }

    public void clickToElement() {
        // Ko dùng super nó sẽ gọi qua hàm ở Class con (hiện tại)
        setImplicitWait();

        // Gọi qua hàm ở lớp Cha
        super.setImplicitWait();
    }

    public static void main(String[] args) {
        Topic_05_This_Super topic = new Topic_05_This_Super();
    }

}
