package javaOOP_Overriding;

public class Student extends Person implements IWork {

    @Override
    public void eat() {
        System.out.println("Suất cơm 15.000 VND");
    }

    @Override
    public void sleep() {
        System.out.println("Ngủ 12 tiếng");
    }

    @Override
    public void workingTime() {
        System.out.println("Làm việc 3 tiếng");
    }


}
