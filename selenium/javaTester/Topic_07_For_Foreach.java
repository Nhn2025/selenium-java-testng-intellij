package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_07_For_Foreach {


    WebDriver driver;

    @Test
    public void TC_01_For_Iterate() {

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        // Vế 1: biến tạm dùng để tăng giá trị lên sau mỗi lần duyệt
        // DUùng để so sánh vs tổng giá trị
        // Vế 2: So sánh với tổng
        // Vế 3: Tăng i lên 1 đơn vị sau khi chạy vào thân vòng for

//        List<WebElement> links = driver.findElements(By.cssSelector(""));
//        links.size();

        // Array
        String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho"};

        // Array/ List/ Set/ Queue (index)
        // For kết hợp if: Thảo mãn điều kiện mới action
        // Biến đếm dùng để điều kiện filter
        for (int i = 0; i < cityName.length; i++) {
            if (cityName[i].equals("Da Nang")) {
                System.out.println("Do atcion"); //Action
                break;
            }
        }
    }

    @Test
    public void TC_02_Foreach() {
        // Array
        String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho"};

        // Java Cllection
        // Class: ArrayList/ LinkedList...
        // Interface: List/ Set/ Queue
        List<String> cityAddress = new ArrayList<String>();
        System.out.println(cityAddress.size());

        // Compile (Coding)
        cityAddress.add("Bac Giang");
        cityAddress.add("Ha Giang");
        cityAddress.add("Sa Pa");

        System.out.println(cityAddress.size());

        // Runtime (Running)
        for (String city : cityName) {
            cityAddress.add(city);
        }

        System.out.println(cityAddress.size());

        for (String cityAdd : cityAddress) {
            System.out.println(cityAdd);
        }

        // Java Generic
        List<WebElement> links = driver.findElements(By.xpath("//a"));

        // Xử lí dữ liệu/ get text/ value/ css/attributte
        for(WebElement link : links) {
            // Chuyển page
            // Refresh DOM, HTML
            // ko cần tồn tại
            // Fail -> StaleEmentException
        }
    }

}
