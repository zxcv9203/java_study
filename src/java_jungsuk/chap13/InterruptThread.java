package java_jungsuk.chap13;

import javax.swing.*;

public class InterruptThread {
    public static void main(String[] args) {
        IT t1 = new IT();

        t1.start();

        String input = JOptionPane.showInputDialog("input plz");
        System.out.println("입력하신 값은 " + input + "입니다.");
        t1.interrupt(); // interrupt()를 호출하면, interrupted 상태가 true 가 됩니다.
        System.out.println("isInterrupted() : " + t1.isInterrupted());
    }
}

class IT extends Thread {
    public void run() {
        int i = 10;
        while (i != 0 && !isInterrupted()) {
            System.out.println(i--);
            for (long x = 0; x < 2500000000L; x++); // 시간 지연 용도
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}