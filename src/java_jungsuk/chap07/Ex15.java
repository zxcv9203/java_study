package java_jungsuk.chap07;

public class Ex15 {
    public static void main(String[] args) {
        // 외부 클래스의 인스턴스를 먼저 생성해야 인스턴스 클래스의 인스턴스를 생성 가능
        Outer2 oc = new Outer2();
        Outer2.InstanceInner ii = oc.new InstanceInner();

        System.out.println("ii.iv : " + ii.iv);
        System.out.println("Outer2.StaticInner.cv : " + Outer2.StaticInner.cv);

        // 스태틱 내부 클래스의 인스턴스는 외부 클래스를 먼저 생성하지 않아도됩니다.
        Outer2.StaticInner si = new Outer2.StaticInner();
        System.out.println("si.iv : " + si.iv);
    }

}

class Outer2 {
    void myMethod() {
        class LocalInner {
            final int iv = 400;
        }
    }

    static class StaticInner {
        static int cv = 300;
        int iv = 200;
    }

    class InstanceInner {
        int iv = 100;
    }
}
