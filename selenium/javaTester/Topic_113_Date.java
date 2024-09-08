package javaTester;

import java.util.Date;

public class Topic_113_Date {

    public static void main(String[] args) {
        System.out.println(getDayTimeNow());
        System.out.println(getDayTimeNow());
        System.out.println(getDayTimeNow());
        System.out.println(getDayTimeNow());
    }

    public static String getDayTimeNow() {
        Date date = new Date();
        return date.toString();
    }
}
