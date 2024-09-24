package javaOOP_Overriding;

public class Employee extends Person implements IWork {

    @Override
    public void eat() {
        System.out.println("Suất cơm 50.000 VND");
    }

    @Override
    public void sleep() {
        System.out.println("Ngủ 7 tiếng");
    }

    @Override
    public void workingTime() {
        System.out.println("Làm việc 8 tiếng");
    }

}
