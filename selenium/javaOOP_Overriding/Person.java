package javaOOP_Overriding;

public abstract class Person {

    // Option
    public void eat() {
        System.out.println("Suất cơm 20.000 VND");
    }

    // Must (Template)
    public abstract void sleep();

    public final void walk() {
        System.out.println("Đi bộ");
    }

    public static void run() {
        System.out.println("Đi bộ");
    }

    void dating() {
        System.out.println("Hẹn hò");
    }

}
