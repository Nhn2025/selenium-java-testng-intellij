package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class Topic_01_Data_Type {
    // 1. Kiểu nguyên thủy - Primitive type/ value type (8 loại)
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

    // 2. Kiểu tham chiếu - Reference type
    // Class
    FirefoxDriver firefoxDriver = new FirefoxDriver();
    Select select = new Select((firefoxDriver.findElement(By.className(""))));
    Topic_01_Data_Type topic01 = new Topic_01_Data_Type();

    // Interface
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    // Kiểu Object (đại diện cho các kiểu dữ liệu khác)
    // Đối tượng -> chuyển đổi qua các kiểu dữ liệu khác
    Object name = "Automation FC";
    Object age = 15;

    // String
    String address = "Ho Chi Minh";

    // Array (nguyên thủy/ tham chiếu)
    int[] studentAge = {5, 6, 7};
    String[] studentName = {address, "Testing"};

    //Colection
    // List/ Set/ Queue/ Map
    List<WebElement> homePageLinks = driver.findElements(By.cssSelector(""));
    Set<String> allWindows = driver.getWindowHandles();
    List<String> studentAddress = new ArrayList<String>();
    List<String> studentCity = new LinkedList<>();
    List<String> studentFont = new Vector<>();

    // Biến toàn cục
    static int studentID;
    // final không cho phép overide (gán) giá trị
    static final String BROWSER_NAME = "Chrome"; // constant

    static String teacherName = "Automation FC";

    // Class kế thừa class: ĐÚNG (extends)
    // Class kế thừa interface ĐÚNG (implements)
    // Interface kế thừa Interface: ĐÚNG (extends)
    // Interface kết thừa class: SAI
    public static void main(String[] args) {
        // Cục bộ: SỬ̉ dụng trong phạm vi testcase/ hàm
        // Biến local không có giá trị MẶC ĐỊNH
        String homePageUrl = "";
        System.out.println(studentID);
        // browserName = "Edge"; // Báo lỗi

        teacherName.toLowerCase();

        // Cách gọi
        System.out.println(Topic_01_Data_Type.BROWSER_NAME);
        System.out.println(BROWSER_NAME);

        // Cần khởi tạo đối tượng do biến không khai báo static
        Topic_01_Data_Type topic = new Topic_01_Data_Type();
        System.out.println(topic.teacherName);

        // Block code
        if (3 < 5) {
            // Cục bộ nằm trong khối lệnh
            String homePageTitle = "";
        }
    }

    // Getter: getCurrentURL/ getTitle/ getAttribute/ getCssValue/...
    public int getStudentName() {
        return this.studentID;
    }

    // Setter: click/ sendKey/ clear/ select/ back/ forward/ refresh/ get/...
    public void getStudentName(int id) {
        this.studentID = id;
    }
}
