package javaTester;

import org.testng.annotations.Test;

public class Topic_01_Exercise {

    @Test
    public void TC_01() {
        int a = 6, b = 2;

        System.out.println("Tong: " + (a + b));
        System.out.println("Hieu: " + (a - b));
        System.out.println("Tich: " + (a * b));
        System.out.println("Thuong: " + (a / b));
    }

    @Test
    public void TC_02() {
        float dai = 7.5f, rong = 3.8f;

        System.out.println("Dien tich: " + (dai * rong));
    }

    @Test
    public void TC_03() {
        String name = "Automation Testing";

        System.out.println("Hello " + name);
    }

}
