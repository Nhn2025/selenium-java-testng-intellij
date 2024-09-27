package javaException;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.*;
import java.time.Duration;

public class ExceptionType {

    FirefoxDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        // NullPointerException
        String name = null;
        System.out.println(name.length());

        // NumberFormatException
        String name2 = "Automation Testing";
        int number = Integer.parseInt(name2);

        int i = Integer.parseInt("10");
        float f = Float.parseFloat("4.5a");

        System.out.println(i);
        System.out.println(f);

        // FileNotFoundException
        // File không tồn tại
        File file = new File("");
        FileReader fr = new FileReader(file);
        fr.close();
    }

    @Test
    public void TC_01() {
        // NoSuchELement
        driver = new FirefoxDriver();
        driver.get("http://live.techpanda.org/index.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//a[text()='Auto']")).click();

        // ElementNotInteractableException
        // Element có trong DOM nhưng bị che bởi 1 element khác
        driver.findElement(By.xpath("//div[@id='header-account']//a[text()='My Account']"));

        // StaleELementReferenceException
        // ELement vẫn còn xuất hiện trong DOM nhưng bị chang state (DOM bị render lại)

        // ElementNotVisibleException
        // ELement không visible được

        // NoAlertPresentException
        // Alert ko hiển thị để thao tác
        driver.switchTo().alert().accept();

        // InvalidSelectorException
        driver.findElement(By.cssSelector("//div[@id='header-account']//a[text()='My Account']"));
    }

    @Test
    public void TC_02() {
        driver = new FirefoxDriver();
        driver.get("https://automationfc.github.io/basic-form/");
        // ElementNotSelectableException
        // Element bị disable ko thể tương tác
        driver.findElement(By.cssSelector("#disbale_password")).sendKeys("Auto");

        // NoSuchFrameException
        // Frame/ iframe ko hiển thị để thao tác

        // NoSuchWindowException
        // Windows ko hiển thị để thao tác (đã bị đóng nhưng vẫn action tiếp)

        // SessionNotFoundException
        // Vẫn tương tác với element sau khi browser đã bị đóng

        // TimeoutException
        // Liên quan đến WebDriverWait and FluentWait
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

}
