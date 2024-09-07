package javaTester;

public class Topic_01_Compare_02 {
    int number;

    public static void main(String[] args) {
        // 1 vùng nhớ cho biến x
        int x = 5;

        // 1 vùng nhớ cho biến y
        int y = x;

        System.out.println("x = " + x);
        System.out.println("y = " + y);

        // 2 giá trị khác nhau, k cập nhật
        y = 10;
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        Topic_01_Compare_02 firstVariable = new Topic_01_Compare_02();
        Topic_01_Compare_02 secondVariable = firstVariable;

        System.out.println("Before = " + firstVariable.number);
        System.out.println("Before = " + secondVariable.number);

        secondVariable.number = 15;

        // Cùng 1 giá trị do tham chiếu cập nhật
        System.out.println("After = " + firstVariable.number);
        System.out.println("After = " + secondVariable.number);
    }

}
