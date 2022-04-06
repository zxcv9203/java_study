package java_jungsuk.chap07;

public class Ex13 {
    static StaticInner cv = new StaticInner();      // static 멤버끼리는 직접 접근 가능
    InstanceInner iv = new InstanceInner();         // 인스턴스 멤버끼리는 직접 접근 가능

    static void staticMethod() {
//        InstanceInner obj1 = new InstanceInner(); // static 멤버는 인스턴스 멤버에 직접 접근 불가
        StaticInner obj2 = new StaticInner();
        Ex13 outer = new Ex13();                    // 인스턴스 클래스는 외부 클래스를 먼저 선언한 후 사용가능
        InstanceInner obj1 = outer.new InstanceInner();
    }

    void instanceMethod() {
        InstanceInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();
//        LocalInner lv = new LocalInner();   // 지역 내부 클래스는 외부에서 접근할 수 없습니다.
    }

    void myMethod() {
        class LocalInner {
        }
        LocalInner lv = new LocalInner();
    }

    static class StaticInner {
    }

    class InstanceInner {
    }
}
