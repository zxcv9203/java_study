package java_jungsuk.chap14;

public class LambdaExample2 {
    static void execute(MyFunction2 f) {
        f.run();
            }

    static MyFunction2 getMyFunction() {
        return () -> System.out.println("f3.run()");
    }

    public static void main(String[] args) {
        // 람다식으로 MyFunction 의 run() 을 구현
        MyFunction2 f1 = () -> System.out.println("f1.run()");

        MyFunction2 f2 = new MyFunction2() {
            @Override
            public void run() {     // public 을 반드시 붙여야 함
                System.out.println("f2.run()");
            }
        };

        MyFunction2 f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();
        execute(f1);
        execute(() -> System.out.println("run()"));
    }
}

@FunctionalInterface
interface MyFunction2 {
    void run(); //public abstract void run(); == void run(); (간소화)
}