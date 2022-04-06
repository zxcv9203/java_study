package java_jungsuk.chap13;

public class ThreadSleep {
    public static void main(String[] args) {
        TS1 t1 = new TS1();
        TS2 t2 = new TS2();

        t1.start();
        t2.start();

        try {
            // 주의! sleep 은 현재 쓰레드를 일시정지 시키는 함수이기 때문에
            // t1 쓰레드가 일시정지 되지 않고 메인 쓰레드가 정지됨
            t1.sleep(2000);       
        } catch (InterruptedException ignored) {}
        delay(100);
        System.out.println("main 종료");
    }
    static void delay(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException ignored) {}
        System.out.println("일시정지 종료");
    }
}

class TS1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
        System.out.println("thread 1 종료");
    }
}

class TS2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
        }
        System.out.println("thread 2 종료");
    }
}