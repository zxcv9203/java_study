package java_jungsuk.chap10;

import java.util.Calendar;

public class Ex01 {
    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
        System.out.println("연 : " + today.get(Calendar.YEAR));
        // 월은 0에서 11까지 존재하기 때문에 1을 더해주어야 현재 달이 됨
        System.out.println("월 : " + today.get(Calendar.MONTH) + 1);
        System.out.println("올해 몇주차 인지 : " + today.get(Calendar.WEEK_OF_YEAR));
        System.out.println("이 달의 몇째 주인지 : " + today.get(Calendar.WEEK_OF_MONTH));
        System.out.println("일 : " + today.get(Calendar.DATE));
        System.out.println("이 달에 몇 일인지 : " + today.get(Calendar.DAY_OF_MONTH));
        System.out.println("이 해의 몇 일인지 : " + today.get(Calendar.DAY_OF_YEAR));
        // 1 == 일요일 ~ 7 == 토요일
        System.out.println("무슨 요일인지 : " + today.get(Calendar.DAY_OF_WEEK));
        System.out.println("현재 달의 무슨 요일인지 : " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("오전 오후 (0 : 오전, 1 : 오후) : " + today.get(Calendar.AM_PM));
        System.out.println("시(0 ~ 11) : " + today.get(Calendar.HOUR));
        System.out.println("시(0 ~ 23) : " + today.get(Calendar.HOUR_OF_DAY));
        System.out.println("분(0 ~ 59) : " + today.get(Calendar.MINUTE));
        System.out.println("초(0 ~ 59) : " + today.get(Calendar.SECOND));
//        밀리초 == 1/1000 초
        System.out.println("밀리초(0 ~ 999) : " + today.get(Calendar.MILLISECOND));
//          타임존은 초로 나오기 때문에 시간으로 바꾸어주어야 함
        System.out.println("타임존(-12 ~ +12) : " + today.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000));
        System.out.println("이 달의 마지막 날 : " + today.getActualMaximum(Calendar.DATE));

    }
}
