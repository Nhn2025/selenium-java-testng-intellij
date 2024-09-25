package javaOOP_Inheritance;

public class Dog extends Annimal {

    private int age;

    public void run() {
        System.out.println("Running...");
    }

    public void setAge(int age) {
        if (age > 0)
            this.age = age;
        else
            this.age = 0;
    }

    public int getAge() {
        return this.age;
    }

}
