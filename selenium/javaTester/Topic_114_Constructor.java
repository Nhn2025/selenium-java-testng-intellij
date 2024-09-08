package javaTester;

public class Topic_114_Constructor {
    // Là 1 cái hàm trùng tên với class
    // Ko có kiểu dữ liệu trả về
    // Trong 1 class có thể có nhiều constructor
    // 1 class nếu ko define thì cái constructor cụ thể thì nó sẽ có 1 constructor rỗng (default)
    // Nếu mình define thì khi khởi tạo nó nắt buộc phải gọi tới constructor mà mình define

    public Topic_114_Constructor(String name) {
        System.out.println(name);
    }
    public Topic_114_Constructor(int numberStudent) {
        System.out.println(numberStudent);
    }

    public static void main(String[] args) {
        Topic_114_Constructor topic1 = new Topic_114_Constructor("Automation FC");
        Topic_114_Constructor topic2 = new Topic_114_Constructor(15);
    }

}
