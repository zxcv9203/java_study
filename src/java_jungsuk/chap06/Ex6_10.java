package java_jungsuk.chap06;

public class Ex6_10 {
    public static void main(String[] args) {
        MyMath3 mm = new MyMath3();
//        mm.add(3, 3); -> 어떤 것을 호출할지 모호함
    }
}

class MyMath3 {
    long add(int a, long b) { return a + b; }
    long add(long a, int b) { return a + b; }
}