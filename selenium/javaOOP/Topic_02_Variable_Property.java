package javaOOP;

public class Topic_02_Variable_Property {
    static int studentNumber;
    static float studentPrice;
    static String studentCountry;
    static Boolean studentStatus;

    // Access Modifier
    // Data Type
    // Variable name
    // Variable value
    private String studentName = "Automation FC"; // Biến toàn cục (global variable)

    // Static variable: dùng và gán lại được
    public static String studentAddress = "Ho Chi Minh";

    // Dùng trong phạm vi Class này (cho tất cả instance/ object dùng)
    private static String studentPhone = "03778267282";

    // Final variable: Ko cho phép gán lại/ override
    // Dữ liệu cố định không thay đổi trong quá trình chạy
    final String country = "Viet Nam";

    // Static final variable: Hằng số (Constant)
    // Nó ko được ghi đè
    // Có thể truy cập rộng rãi cho tất cả các instance/ thread
    static final float PI_NUMBER = 3.143444f;

    // Access midifier: default
    int studentID = 100056;

    // Hàm (method) - static
    public static void main(String[] args) {
        // Local variable - biến cục bộ: hàm/ block code/ constructor
        String studentName = "Automation FC";

        if (studentName.startsWith("Automation")) {
            // Local variable - biến cục bộ: block code
            int number = 100;
        }

        studentAddress = "Da Nang";
        studentPhone = "0388829";

        // Local variable: bắt buộc phải khởi tạo mới được sử dụng
        int studentNumber = 1;

        System.out.println(studentNumber);
        System.out.println(studentCountry);
        System.out.println(studentPrice);
        System.out.println(studentStatus);
    }

    // Constructor
    public Topic_02_Variable_Property() {
        // Local variable - biến cục bộ: constructor
        String studentName = "Automation FC";

        if (studentName.startsWith("Automation")) {

        }
    }

    // Hàm (Method) - non static
    public void display() {
        // Local variable - biến cục bộ: hàm
        String studentName = "Automation FC";
    }
}
