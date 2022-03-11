package java_jungsuk.chap14;

public class LambdaExample {
    public static void main(String[] args) {
//        MyFunction f = new MyFunction() {
//            public int max(int a, int b) {  // 오버라이딩 -접근제어자는 좁게 못바꿉니다.
//                return a > b ? a : b;
//            }
//        };

        // 람다식(익명 객체)를 다루기 위한 참조변수의 타입은 함수형 인터페이스로 해야합니다.
        MyFunction f = (a, b) -> a > b ? a : b; // 람다식
        int value = f.max(7, 5);    // 함수형 인터페이스
        System.out.println("value = " + value);
    }
}

@FunctionalInterface    // 함수형 인터페이스는 단 하나의 추상 메서드만 가져야함
interface MyFunction {
    public abstract int max(int a, int b);
}