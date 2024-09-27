package javaException;

import org.openqa.selenium.By;

public class TryCatchException {

    public static void main(String[] args) throws InterruptedException {
        int number = 10;

        try {
            // Đúng: Chạy hết đoạn code trong try không qua catch
            // Sai: Gặp exception - nhảy qua catch
            number = number / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(number);

        String[] browserName = {"Chrome", "Firefox", "IE"};

        try {
            browserName[0] = "Edge Chromium";
            browserName[3] = "Safari";
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        for (String browser : browserName)
            System.out.println(browser);

        try {
            int array[] = new int[10];
            array[9] = 30 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Không thể chia cho 0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index vượt ngoài độ dài của mảng");
        }

        // Do sleepInSecond throws nên hàm sử dụng nó cũng phải throws
        sleepInSecond(5);

        // Có thể có nhiều catch nhưng chỉ có 1 finally
        try {
            int array[] = new int[10];
            array[9] = 30 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Không thể chia cho 0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index vượt ngoài độ dài của mảng");
        } finally {
            // Khối này sẽ luôn được thực thi, bất kể có ngoại lệ hay không
            System.out.println("Khối finally luôn được thực thi.");
        }
    }

    public static void sleepInSecond(long timeout) throws InterruptedException {
        Thread.sleep(timeout * 1000);
    }

    // e.getMessage()
    // Trả về một String mô tả về Exception vừa xảy ra

    // e.toString()
    // Trả về tên của lớp Exception đang tung ra lỗi - kèm với nội dung của phương thức getMessage()

    // e.printStackTrace()
    // in ra một nội dung của phương thức toString() kèm với các dòng log (StackTrace)

}
