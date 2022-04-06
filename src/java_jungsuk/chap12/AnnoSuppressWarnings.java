package java_jungsuk.chap12;

public class AnnoSuppressWarnings {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Test t = new Test();

        t.test();
    }
}

class Test {
    @Deprecated
    static void test() {
        System.out.println("Deprecated Method");
    }
}