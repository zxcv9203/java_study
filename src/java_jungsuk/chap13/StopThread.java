package java_jungsuk.chap13;

public class StopThread {
    public static void main(String[] args) {
        ST t1 = new ST("*");
        ST t2 = new ST("**");
        ST t3 = new ST("***");


        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(2000);
            t1.suspend();
            Thread.sleep(2000);
            t2.suspend();
            Thread.sleep(3000);
            t1.resume();
            Thread.sleep(3000);
            t1.stop();
            t2.stop();
            Thread.sleep(2000);
            t3.stop();
        } catch (InterruptedException ignored) {}
    }
}

class ST implements Runnable {
    volatile boolean suspended = false; // 쉽게 바뀌는 변수
    volatile boolean stopped = false;

    Thread t;

    ST(String name) {
        t = new Thread(this, name);
    }

    void start() {
        t.start();
    }

    void stop() {
        stopped = true;
    }
    void suspend() {
        suspended = true;
    }
    void resume() {
        suspended = false;
    }
    public void run() {
        while (!stopped) {
            if (!suspended) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
            }
        }
    }
}