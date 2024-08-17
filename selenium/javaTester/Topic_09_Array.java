package javaTester;

public class Topic_09_Array {
    int[] studentAge = {15, 10, 20, 22};

    static String[] studentName = {"Nguyễn Văn An", "Lê Văn Hoà"};

    public static void main(String[] args) {
        String[] studentAddress = new String[5];

        studentAddress[0] = "Đặng Ngọc Anh";
        studentAddress[1] = "Đào Duy Từ";
        studentAddress[2] = "Nguyễn Trãi";
        studentAddress[3] = "Nguyễn Du";
        studentAddress[4] = "Lê Lợi";

        // Trong hàm main là static thì biến đó phải static không thì phải qua đối tượng
        System.out.println(studentName[0]);
        System.out.println(studentName[1]);

        for (int i = 0; i < studentAddress.length; i++) {
            System.out.println(studentAddress[i]);
        }

        // Gọi qua đối tượng
        // Topic_09_Array topic = new Topic_09_Array();
        // System.out.println(topic.studentAge[0]);
    }
}
