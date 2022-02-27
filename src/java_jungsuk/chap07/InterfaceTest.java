package java_jungsuk.chap07;

interface I {
    void method();
}

public class InterfaceTest {
    public static void main(String[] args) {
        A a = new A();
        a.method(new B()); // A가 B를 사용(의존)
    }
}

class A {
    public void method(I i) { // interface I를 구현한 클래스만 들어오도록 하게함
        i.method();
    }
}

class B implements I {
    public void method() {
        System.out.println("B class");
    }
}

class C implements I {
    public void method() {
        System.out.println("C class");
    }
}