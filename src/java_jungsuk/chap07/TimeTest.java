package java_jungsuk.chap07;

public class TimeTest {
    public static void main(String[] args) {
        Time t = new Time();
        t.setHour(21);
        System.out.println(t.getHour());
        t.setHour(200);
        System.out.println(t.getHour());

    }
}

class Time {
    private int hour;
    private int minute;
    private int second;

    public void setHour(int hour) {
        if (!isValidHour(hour)) {
            System.out.printf("잘못된 시간입니다. 입력된 값 : %d\n", hour);
            return;
        }
        this.hour = hour;
    }

    public int getHour() { return hour; }
    private boolean isValidHour(int hour) {
        return hour > 0 && hour < 24;
    }
}