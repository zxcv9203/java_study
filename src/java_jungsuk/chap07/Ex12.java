package java_jungsuk.chap07;

public class Ex12 {
    public static void main(String[] args) {
        System.out.println(InstanceInner.CONST);
        System.out.println(StaticInner.cv);
        System.out.println(InstanceInner.CONST);
    }

    void myMethod() {
        class LocalInner {
            final static int CONST = 300;               // final static은 상수이므로 허용
            //            static final int cv = 300; //에러! static 변수를 선언할 수 없습니다.
            final int iv = 300;
        }
    }

    static class StaticInner {
        static int cv = 200;            // static 클래스만 static 멤버를 정의할 수 있습니다.
        int iv = 200;
    }

    class InstanceInner {
        final static int CONST = 100;   // final static은 상수이므로 허용합니다.
        //        static int cv = 100;  // 에러! static 변수를 선언할 수 없습니다.
        int iv = 100;
    }
}
