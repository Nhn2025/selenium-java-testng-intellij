package javaTester;

import org.testng.annotations.Test;

import java.util.Scanner;

// Class
public class Topic_09_While_Do_While {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        TC_03_Do_While();
    }

    @Test
    public static void TC_01_For() {
        int number = sc.nextInt();

        for (int i = number; i < 100 ; i++)
            if (i % 2 == 0)
                System.out.println(i);
    }

    @Test
    public static void TC_02_While() {
        int number = sc.nextInt();

        while(number < 100) {
            if (number % 2 == 0)
                System.out.println(number);
            number++;
        }
    }

    @Test
    public static void TC_03_Do_While() {
        int number = sc.nextInt();

        do {
            if (number % 2 == 0)
                System.out.println(number);
            number++;
        }
        while(number < 100);
    }

    @Test
    public static void TC_04_While() {
        int numberA = sc.nextInt();

        while (numberA < 100) {
            // Chia hết cho cả 3 và 5
            if (numberA % 3 == 0 && numberA % 5 ==0)
                System.out.println(numberA);
            numberA++;
        }
    }

    @Test
    public void TC_05_While() {
        int numberA = sc.nextInt();
        int i = 0;

        while (numberA > 0) {
            if (numberA % 2 != 0)
                i += numberA;
            numberA--;
        }

        System.out.println(i);
    }

}
