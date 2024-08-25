package javaTester;

import java.util.Date;

public class Topic_13_Date {

    public static void main(String[] args) {
        System.out.println(getDayeTimeNow());
        System.out.println(getDayeTimeNow());
        System.out.println(getDayeTimeNow());
        System.out.println(getDayeTimeNow());
    }

    public static String getDayeTimeNow() {
        Date date = new Date();
        return date.toString();
    }
}
