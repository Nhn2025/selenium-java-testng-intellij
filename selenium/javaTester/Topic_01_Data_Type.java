package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Topic_01_Data_Type {
    // 1. Kiểu nguyên thủy
    // Số nguyên
    byte bNumber = 40;
    short sNumber = 3000;
    int iNumber = 15635658;
    long lNumber = 234343400;

    // Số thực
    float fNumber = 9.99f;
    double dNumber = 35.800789d;

    // Kí tự
    char c = '$';
    char d = 'i';

    // Logic
    boolean status = true;

    // 2. Kiểu tham chiếu
    // Class
    FirefoxDriver firefoxDriver = new FirefoxDriver();
    Select select = new Select((firefoxDriver.findElement(By.className(""))));
    Topic_01_Data_Type topic01 = new Topic_01_Data_Type();

    // Interface
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    // Object
    Object name = "Automation FC";

    // Array (nguyên thủy/ tham chiếu)
    int [] studentAge = {5, 6, 7};
    String[] studentName = {"Automation", "Testing"};

    //Colection
    List<String> studentAddress = new ArrayList<String>();
    List<String> studentCity = new LinkedList<>();
    List<String> studentFont = new Vector<>();
}
