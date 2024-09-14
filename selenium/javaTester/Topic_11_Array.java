package javaTester;

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
}
