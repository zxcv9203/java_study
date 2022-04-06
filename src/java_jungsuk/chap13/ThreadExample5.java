package java_jungsuk.chap13;

import javax.swing.*;

public class ThreadExample5 {
    public static void main(String[] args) {
        ThreadEx5 t = new ThreadEx5();
        t.start();

        String input = JOptionPane.showInputDialog("input plz");
        System.out.println("입력하신 값은 " + input + "입니다.");
    }


}

class ThreadEx5 extends Thread {
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (Exception ignored) {}
        }
    }
}