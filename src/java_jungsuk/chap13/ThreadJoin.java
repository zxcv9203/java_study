package java_jungsuk.chap13;

public class ThreadJoin {
    public static void main(String[] args) {
        TJ1 t1 = new TJ1();
        TJ2 t2 = new TJ2();
        t1.start();
        t2.start();
        long stTime = System.currentTimeMillis();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ignored) {}
        System.out.println("\n소요시간 : " + (System.currentTimeMillis() - stTime));
    }
}

class TJ1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
    }
}

class TJ2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
        }
    }
}