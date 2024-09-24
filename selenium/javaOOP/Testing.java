package javaOOP;

import com.beust.ah.A;

public class Testing {

//    public static void main(String[] args) {
//        // Truy cập trực tiếp từ tên Class
//        // Không cần phải tạo instance/ object
//        // Không nên lạm dụng tạo các biến static
//        System.out.println(Topic_04_Non_Access_Modifier.browserName);
//
//        // Khởi tạo các Class
//        Topic_04_Non_Access_Modifier.sendkeyToElement("Link");
//
//        Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
//        System.out.println(topic.colorCar);
//
//        String studnetName = "112225";
//
//        // Không báo lỗi trong quá trình compile
//        // Ko đúng convention/ ko đúng chuẩn/ vi phạm chuẩn của Java sẽ báo lỗi ngay
//
//        // 2 loại lỗi
//        // Lỗi Compiler: Trong quá trình viết code sẽ báo lỗi
//        // Lỗi Runtime: Trong quá trinhf run system/ run testcase
//    }
//
//    // Lớp Lồng
//    public static class NestedTesting {
//
//    }

    public static void main(String[] args) {
        Topic_06_Getter_Setter topic = new Topic_06_Getter_Setter();

        // Happy Case
        topic.setPersonName("Automation FC");
        System.out.println(topic.getPersonName());

        // Unhappy Case
        //topic.setPersonName(null);
        System.out.println(topic.getPersonName());

        topic.setPersonName("");
        System.out.println(topic.getPersonName());
    }

}
