package javaOOP;

public class Person {
    public String personName;

    // Nested class/ inner class
    public class Pupil {
        String name = "";
    }

    public static void main(String[] args) {
        Person person = new Person();
        // Person = Class
        // Person = intance/ biến/ object

        Person.Pupil pupil = person.new Pupil();
        pupil.name = "";
    }

}
