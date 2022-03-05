package java_jungsuk.chap10;

import java.util.Calendar;

public class Ex02 {
    public static void main(String[] args) {
        // 요일은 1부터 시작하기 때문에 DAY_OF_WEEK[0]은 비워둠
        final String[] DAY_OF_WEEK = {"", "일", "월", "화", "수", "목", "금", "토"};

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();

        // month의 경우 0부터 시작하기 때문에 4월인 경우 3으로 지정해야함
        // date.set(2019, Calendar.APRIL, 29); 와 같이 가능
        date1.set(2019, 3, 29);
        System.out.println("date1은 " + toString(date1) +
                DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일이고,");
        System.out.println("오늘(date2)은 " + toString(date2)
                + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일입니다.");
    
        /*
            두 날짜의 차이를 얻으려면 getTimeInMillis()로 밀리초 단위로 변경한 후 계산 간단함
         */
        long diff = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
        System.out.println("date1부터 date2까지의 걸린 초 : " + diff);
        System.out.println("date1부터 date2까지 걸린 일 : " + diff / (24 * 60 * 60));
    }
    public static String toString(Calendar date) {
        return date.get(Calendar.YEAR) + "년 " +
                (date.get(Calendar.MONTH) + 1) + "월 " +
                date.get(Calendar.DATE) + "일 ";
    }
}
