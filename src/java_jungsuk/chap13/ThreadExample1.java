package java_jungsuk.chap13;

public class ThreadExample1 {
    public static void main(String[] args) {
        ThreadEx01_1 t1 = new ThreadEx01_1();
        Runnable r = new ThreadEx01_2();
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}

class ThreadEx01_1 extends Thread {
    // 쓰레드가 수행할 작업을 작성
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName());  // 조상인 Thread 의 getName() 호출
        }
    }
}

class ThreadEx01_2 implements Runnable {
    // 쓰레드가 수행할 작업을 작성
    public void run() {
        for (int i = 0; i < 100; i++) {
            // 현재 실행중인 Thread 를 반환합니다.
            System.out.println(Thread.currentThread().getName());
        }
    }
}