package javaTester;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_03_Exercise {

    public static void main(String[] args) {
        nameAndAge();
    }

    public static void nameAndAge() {
        Scanner sc = new Scanner(System.in);
        String name;
        int age;

        System.out.print("Mời bạn nhập tên: ");
        name = sc.nextLine();

        System.out.print("Mời bạn nhập tuồi: ");
        age = sc.nextInt();

        System.out.println(name + " " + age);

        sc.close();
    }

    @Test
    public void swapNumber() {
       int a = 5;
       int b = 6;

       a = a + b;
       b = a - b;
       a = a -b;

       System.out.println(a + " " + b);
   }

    @Test
    public void compare() {
        int a = 7, b = 8;

        String result = (a > b) ? "true" : "false";
        System.out.println(result);
    }

}
