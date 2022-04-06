package java_jungsuk.chap13;

public class ThreadExample2 {
    public static void main(String[] args) {
        ThreadEx02_1 t1 = new ThreadEx02_1();
        ThreadEx02_2 t2 = new ThreadEx02_2();

        t1.start();
        t2.start();
        long stTime = System.currentTimeMillis();
        try {
            t1.join();  // main 쓰레드가 t1 작업이 끝날때까지 기다림
            t2.join();  // main 쓰레드가 t2 작업이 끝날때까지 기다림
        } catch(InterruptedException ignored) {}
        System.out.println("\n소요시간 : " + (System.currentTimeMillis() - stTime));
    }
}
class ThreadEx02_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("-"));
        }
    }
}

class ThreadEx02_2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("|"));
        }
    }
}