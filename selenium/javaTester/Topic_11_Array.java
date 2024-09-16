package javaTester;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Topic_11_Array {
    int[] studentAge = {15, 10, 20, 22};

    int Age [] = {15, 10, 20, 22};

    int b[] = new int[5];

    static String[] studentName = {"Nguyễn Văn An", "Lê Văn Hoà"};

    public static void main(String[] args) {
        String[] studentAddress = new String[5];

        studentAddress[0] = "Đặng Ngọc Anh";
        studentAddress[1] = "Đào Duy Từ";
        studentAddress[2] = "Nguyễn Trãi";
        studentAddress[3] = "Nguyễn Du";
        studentAddress[4] = "Lê Lợi";

        String stdNewName[] = studentAddress.clone();

        // Trong hàm main là static thì biến đó phải static không thì phải qua đối tượng
        System.out.println(studentName[0]);
        System.out.println(studentName[1]);

        for (int i = 0; i < studentAddress.length; i++) {
            System.out.println(studentAddress[i]);

            if (i == 2)
                System.out.println(i);
        }

        // Ko biết được index (biết thì k chính thống)
        for (String sta : studentAddress) {
            System.out.println(sta);
        }

        List<String> names = Arrays.asList("Tom", "Jerry");
        for (String name : names)
            System.out.println("Name: " + name);

        // Gọi qua đối tượng
        // Topic_09_Array topic = new Topic_09_Array();
        // System.out.println(topic.studentAge[0]);
    }

    int number[] = {5, 8, 15, 7, 60, 1};

    @Test
    public void Tc_01_Find_Max_Number() {
        int x = 0;
        for (int i = 0; i < number.length; i++) {
            if (x < number[i])
                x = number[i];
        }

        System.out.println("Max number = " + x);
    }

    @Test
    public void TC_02_Sum_First_And_Last_Number() {
        System.out.println(number[0] + number[number.length - 1]);
    }

    @Test
    public void TC_03_Even_Number() {
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 == 0)
                System.out.println("Even number = " + number[i]);
        }
    }

    @Test
    public void TC_04() {
        for (int i = 0; i < number.length; i++) {
            if (number[i] >= 0 && number[i] <= 10)
                System.out.println("Number in (0 <= number <= 10) = " + number[i]);
        }
    }

    @Test
    public void TC_05() {
        int sum = 0;
        for (int i = 0; i < number.length; i++) {
            sum += number[i];
        }

        System.out.println("Sum all number = " + sum);

        float average = sum / number.length;
        System.out.println("Average all number = " + average);
    }

}
