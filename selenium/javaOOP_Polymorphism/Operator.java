package javaOOP_Polymorphism;

public class Operator {

    public void sum(int a, int b) {
        System.out.println(a + b);
    }

    public void sum(double a, double b) {
        System.out.println(a + b);
    }

    public void sum(float a, float b) {
        System.out.println(a + b);
    }

    public void sum(long a, long b) {
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        Operator opr = new Operator();

        // Trình biên dịch nó sẽ chọn phương thức nào
        opr.sum(5, 8);
        opr.sum(500000L, 800000L);
        opr.sum(5.16d, 8.9d);
        opr.sum(5.16f, 8.9f);
    }

}
