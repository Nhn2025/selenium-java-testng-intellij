package javaOOP;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseOOP extends SeleniumWebDriver {
    public long shortTimeout = 15;
    protected long longTimeOut = 45;
    private WebDriver driver;

    public BaseOOP() {
        System.out.println("Constructor tại Class cha: ");
    }

    public BaseOOP(String name) {
        System.out.println("Constructor tại Class cha: " + name);
    }

    public BaseOOP(int number) {
        System.out.println("Constructor tại Class cha: " + number);
    }

    public void setImplicitWait() {
        driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
    }

}
