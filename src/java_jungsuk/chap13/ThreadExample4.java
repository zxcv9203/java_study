package java_jungsuk.chap13;

import javax.swing.*;

public class ThreadExample4 {
    public static void main(String[] args) throws Exception {
        String input = JOptionPane.showInputDialog("input");
        System.out.println("입력하신 값은 " + input + "입니다.");

        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);     // 1초간 시간을 지연시킵니다.
            } catch(Exception ignored) {}
        }
    }
}
