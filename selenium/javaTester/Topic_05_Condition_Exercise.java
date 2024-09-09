package javaTester;

import org.checkerframework.checker.units.qual.m;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_05_Condition_Exercise {
    WebDriver driver;
    Scanner sc = new Scanner(System.in);

    //@Test
    public void TC_01() {
        int number = sc.nextInt();

        if (number % 2 ==0)
            System.out.println("So: " + number + " là số chẵn");
        else
            System.out.println("So: " + number + " là số lẻ");
    }

    //@Test
    public void TC_02() {
        int numberA = sc.nextInt();
        int numberB = sc.nextInt();

        if (numberA > numberB)
            System.out.println(numberA + " lớn hơn " + numberB);
        else if (numberA == numberB)
            System.out.println(numberA + " bằng " + numberB);
        else
            System.out.println(numberA + " nhỏ hơn " + numberB);
    }

    //@Test
    public void TC_03() {
        String firstStudent = sc.nextLine();
        String secondStudent = sc.nextLine();

        // Reference: String
        // Kiểm tra cái value của biến
        // Kiểm tra vị trí của biến trong vùng nhớ
        if (firstStudent.equals(secondStudent))
            System.out.println("Hai sinh viên giống tên nhau");
        else
            System.out.println("Hai sinh viên khác tên nhau");

        // Kiểu primitive type
        if (firstStudent == secondStudent)
            System.out.println("Hai sinh viên giống tên nhau");
        else
            System.out.println("Hai sinh viên khác tên nhau");
    }

    //@Test
    public void TC_04() {
        int numberA = sc.nextInt();
        int numberB = sc.nextInt();
        int numberC = sc.nextInt();

        if (numberA > numberB && numberA > numberC)
            System.out.println("A là số lớn nhất");
        else if (numberB > numberC)
            System.out.println("B là số lớn nhất");
        else
            System.out.println("C là số lớn nhất");
    }

    //@Test
    public void TC_05() {
        int numberA = sc.nextInt();

        if (numberA > 10 && numberA < 100 )
            System.out.println(numberA + "nằm trong khoảng [10, 100]");
        else
            System.out.println(numberA + "không nằm trong khoảng [10, 100]");
    }

    //@Test
    public void TC_06() {
        float studentPoint = sc.nextFloat();

        if (studentPoint <= 10 && studentPoint >= 8)
            System.out.println("Hệ số A");
        else if (studentPoint < 8.5 && studentPoint >= 7.5)
            System.out.println("Hệ số B");
        else if (studentPoint < 8.5 && studentPoint >= 7.5)
            System.out.println("Hệ số B");
        else if (studentPoint < 7.5 && studentPoint >= 5.5)
            System.out.println("Hệ số C");
        else if (studentPoint < 5 && studentPoint >= 0)
            System.out.println("Hệ số D");
        else
            System.out.println("Bạn vui lòng nhập điểm lại");
    }

    @Test
    public void TC_07() {
        int month = sc.nextInt();

        // 1 3 5 7 8 10 12
        if (month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12)
            System.out.println("Tháng này có 31 ngày");
        else if (month == 4 || month == 6 || month == 9 || month == 11)
            System.out.println("Tháng này có 30 ngày");
        else
            System.out.println("Tháng này có 28 ngày");
    }

}
