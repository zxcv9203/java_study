package java_jungsuk.chap13;

public class ThreadPriority {
    public static void main(String[] args) {
        TP1 t1 = new TP1();
        TP2 t2 = new TP2();

        t1.setPriority(1);
        t2.setPriority(10);

        System.out.println("Priority of t1 : " + t1.getPriority());
        System.out.println("Priority of t2 : " + t2.getPriority());
        t1.start();
        t2.start();
    }
}

class TP1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
            for (int x = 0; x < 10000000; x++); // 시간 지연용 for 문
        }
    }
}

class TP2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
            for (int x = 0; x < 10000000; x++);
        }
    }
}