package javaTester;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

public class Topic_12_Exercise {
    String courseName = "Automation TeSting 9 20 21 Advanced";

    @Test
    public void TC_01() {
        char courseNameArr[] = courseName.toCharArray();
        int countUpper = 0;
        int countLower = 0;
        int countNumber = 0;

        for (char character : courseNameArr) {
            // Uppercase
            if (character <= 'Z' && character >= 'A')
                countUpper++;

            // Lowercase
            if (character <= 'z' && character >= 'a')
                countLower++;

            // Number
            if (character <= '9' && character >= '0')
                countNumber++;
        }

        System.out.println("Sum of uppercase = " + countUpper);
        System.out.println("Sum of lowerCase = " + countLower);
        System.out.println("Sum of number = " + countNumber);
    }

    @Test
    public void TC_02() {
        char courseNameArr[] = courseName.toCharArray();
        int count = 0;
        for (char c : courseNameArr)
            if (c == 'a')
                count++;
        System.out.println("Count: " + count);
    }

    @Test
    public void TC_03() {
        char courseNameArr[] = courseName.toCharArray();

        for (int i = courseNameArr.length - 1; i >= 0 ; i--)
            System.out.print(courseNameArr[i]);
    }
}
