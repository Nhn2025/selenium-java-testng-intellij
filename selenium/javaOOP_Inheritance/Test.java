package javaOOP_Inheritance;

public class Test extends Annimal {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setAge(-15);
        System.out.println(dog.getAge());

        dog.setAge(15);
        System.out.println(dog.getAge());
    }

}
