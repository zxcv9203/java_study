package java_jungsuk.chap12;

public class AnnoDeprecated {
    public static void main(String[] args) {
        Child2 c = new Child2();
        c.parentMethod();
    }
}

class Parent2 {
    void parentMethod() {}
}

class Child2 extends Parent2 {
    @Override
    @Deprecated
    void parentMethod() {}
}
