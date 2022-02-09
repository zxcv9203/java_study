package java_jungsuk.chap06;

public class ClassVariable {
    public static void main(String[] args) {
        test t = new test();

        t.a = 5;
        System.out.println(test.a);
        test.a = 4;
        System.out.println(test.a);
    }
}

class test {
    static int a = 3;
    int b= 10;
}
