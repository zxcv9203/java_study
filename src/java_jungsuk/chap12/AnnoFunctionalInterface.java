package java_jungsuk.chap12;

public class AnnoFunctionalInterface {
}

@FunctionalInterface    // 함수형 인터페이스는 하나의 추상 메서드만 사용 가능
interface Testable {
    void test();    // 추상 메서드
//    void check();   // 추상 메서드
}