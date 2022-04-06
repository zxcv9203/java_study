package java_jungsuk.chap10;


import java.util.Calendar;

/*
    달력 출력하기
 */

public class CalendarTest {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error");
            return;
        }
        int year = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        int START_DAY_OF_WEEK;
        int END_DAY;

        Calendar sDay = Calendar.getInstance();     // 시작일
        Calendar eDay = Calendar.getInstance();     // 말일

        // 월의 경우 0부터 11까지의 값을 가지므로 1을 빼주어야 합니다.
        // 2019년 11월 1일의 경우 sDay.set(2019, 10, 1);
        sDay.set(year, month -1, 1);
        eDay.set(year, month, 1);

        // 다음달의 첫날에서 하루를 빼면 현재달의 마지막날이 나옴
        eDay.add(Calendar.DATE, -1);

        // 첫 번째 요일이 무슨 요일인지 알아냅니다.
        START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);

        // eDay에 지정된 날짜를 얻어옵니다.
        END_DAY = eDay.get(Calendar.DATE);

        System.out.println("       " + year + "년 " + month + "월");
        System.out.println(" SU MO TU WE TH FR SA");

        // 1일의 요일 전까지 공백을 출력합니다.
        for (int i = 1; i < START_DAY_OF_WEEK; i++) {
            System.out.print("   ");
        }
        for (int i = 1, n = START_DAY_OF_WEEK; i <= END_DAY; i++, n++) {
            System.out.print((i < 10) ? "  " + i : " " + i);
            if (n % 7 == 0) {
                System.out.println();
            }
        }
    }
}
