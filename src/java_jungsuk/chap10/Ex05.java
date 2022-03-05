package java_jungsuk.chap10;

import java.util.Calendar;

public class Ex05 {
    static int getDayDiff(String yyyymmdd1, String yyyymmdd2) {
        int diff;

        try {
            int year1 = Integer.parseInt(yyyymmdd1.substring(0, 4));
            int month1 = Integer.parseInt(yyyymmdd1.substring(4, 6)) - 1;
            int day1 = Integer.parseInt(yyyymmdd1.substring(6, 8));
            int year2 = Integer.parseInt(yyyymmdd2.substring(0, 4));
            int month2 = Integer.parseInt(yyyymmdd2.substring(4, 6)) - 1;
            int day2 = Integer.parseInt(yyyymmdd2.substring(6, 8));

            Calendar date1 = Calendar.getInstance();
            Calendar date2 = Calendar.getInstance();
            date1.clear();
            date2.clear();
            date1.set(year1, month1, day1);
            date2.set(year2, month2, day2);
            diff = (int) ((date1.getTimeInMillis() - date2.getTimeInMillis())
                    / (24 * 60 * 60 * 1000));
            System.out.println(date1.getTimeInMillis());
            System.out.println(date2.getTimeInMillis());
        } catch (Exception e) {
            diff = 0;
        }
        return diff;
    }
    public static void main(String[] args) {
        System.out.println(getDayDiff("20010103", "20010101"));
    }
}
