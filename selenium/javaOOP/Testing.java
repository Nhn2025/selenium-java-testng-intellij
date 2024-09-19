package javaOOP;

public class Testing {

    public static void main(String[] args) {
        Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student();

        // Instance variable
        firstStudent.studentID = 1564564;

        System.out.println(Topic_02_Variable_Property.studentAddress);

        Topic_02_Variable_Property.studentAddress = "Ha Noi";

        Topic_03_Method.showCarColor();
    }

}
