package java_jungsuk.chap07;

public class Ex14 {
}

class Outer {
    static int outerCv = 0;
    private final int outerIv = 0;

    void myMethod() {
        int lv = 0;
        final int LV = 0;   // JDK 1.8부터 final 생략가능 (변수인데 값이 안바뀌는 것 -> 상수로 간주)

        class LocalInner {
            final int liv = outerIv;
            final int iiv2 = outerCv;

            // 외부 클래스의 지역변수는 final이 붙은 변수(상수)만 접근가능합니다.
            // 메서드가 종료되는 것보다 클래스가 더 오래 남아있을 수 있기때문
            final int liv3 = lv;      // JDK 1.8이전 버전은 에러
            final int llv4 = LV;
        }
    }

    static class StaticInner {
        //        int siv = outerIv;          // 스태틱 클래스는 외부 클래스의 인스턴스 멤버에 접근할 수 없습니다.
        static int scv = outerCv;
    }

    class InstanceInner {
        int iiv = outerIv;          //외부 클래스의 private 멤버도 접근 가능
        int iiv2 = outerCv;
    }
}
