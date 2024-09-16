package javaTester;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_12_String {

    public static  void main(String[] args) {
        String firstName = "Automation";
        String lastName = "FC";

        String fullName = firstName + " " + lastName;
        System.out.println(fullName);

        fullName = firstName.concat("").concat(lastName);
        System.out.println(fullName);

        String hotelMsg = "Welcome " +fullName + " to InterContiental Hotel";
        System.out.println(hotelMsg);

        // Trả về true/ false
        hotelMsg.endsWith("Hotel");

        String s1 = "Cat";
        // Chuỗi không thể thay đổi được
        // Dog sẽ tạo ra vùng nhớ mới
        s1 = "Dog";
        String s2 = s1;
        String s3 = new String("Cat");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
        System.out.println(s2.equals(s3));

        WebDriver driver = new FirefoxDriver();
        String schoollName = "Automation Testing";
        String courseName = "AUTOMATION TESTING";
        String schoollAddress = "Ho Chi Minh City";

        System.out.println("Độ dài = " + schoollName.length());
        System.out.println("Lấy ra 1 kí tự = " + schoollName.charAt(0));
        System.out.println("Nối 2 chuỗi = " + schoollName.concat(schoollAddress));
        System.out.println("Nối 2 chuỗi = " + schoollName + schoollAddress);

        // Tuyệt đối
        System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoollName.equals(schoollAddress));

        // Multi browser
        System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoollName.equalsIgnoreCase(schoollAddress));

        // Startswith/ EndsWith/ contains
        System.out.println("Có bắt đầu bằng 1 kí tự/ chuỗi kí tự = " + schoollName.startsWith("T"));
        System.out.println("Có kết thúc bằng 1 kí tự/ chuỗi kí tự = " + schoollName.endsWith("T"));
        System.out.println("Có chứa 1 kí tự/ chuỗi kí tự = " + schoollName.contains("T"));

        // Index
        System.out.println("Vị trí của 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoollName.indexOf("Testing"));

        // Cắt/ Tách chuỗi
        System.out.println("Tách 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoollName.substring(11, 15));

        // Split: Tách chuỗi thành 1 mảng dựa vào kí tự/ chuỗi kí tự
        // Alert
        String result = "Viewing 48 of 132 results";
        String results[] = result.split(" ");
        System.out.println(results[1]);

        // Replace
        String productPrice = "$100.00";
        productPrice = productPrice.replace("$", "");
        System.out.println(productPrice);

        float productPriceF = Float.parseFloat(productPrice);
        System.out.println(productPriceF);

        productPrice = String.valueOf(productPriceF);
        System.out.println(productPrice);

        String osName = System.getProperty("os.name");
        System.out.println(osName);
        // Windows 10 = windows 10
        // Handle multiple OS: MAC/ Windows (Actions - keys - Ctrl/ Command)
        Keys key;
        if (osName.toLowerCase().contains("windows"))
            key = Keys.CONTROL;
        else
            key = Keys.COMMAND;

        // Multiple browser: toUpperCase
        // firefox = FIREFOX (Enum)

        String driverInstanceName = driver.toString();
        System.out.println(driverInstanceName);
        // FirefoxDriver: firefox on WINDOWS (113f9926...)
        // Close browser/ driver
        if (driverInstanceName.contains("internetexplorer")) {
            // Sleep cứng thêm 5s sau mỗi sự kiện chuyển page
        }

        // Khoảng trắng/ xuống dòng/ tab
        String helloWorld = " \n \t     Hello World!";
        System.out.println(helloWorld);
        System.out.println(helloWorld.trim());

        helloWorld = "";

        System.out.println("Empty = " + helloWorld.isEmpty());
        System.out.println("Empty = " + helloWorld.isBlank());

        // Dynamic locator
        // Đại diện cho 1 chuỗi: %s
        // %b %t %d
        String dynamicButtonXpath = "//button[@id='%s']";
        System.out.println("Click to Login button = " + dynamicButtonXpath.format(dynamicButtonXpath, "login"));
        System.out.println("Click to Search button = " + dynamicButtonXpath.format(dynamicButtonXpath, "search"));
        System.out.println("Click to Register button = " + dynamicButtonXpath.format(dynamicButtonXpath, "register"));
    }

}
