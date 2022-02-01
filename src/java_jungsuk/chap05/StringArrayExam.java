package java_jungsuk.chap05;

import java.util.Arrays;

public class StringArrayExam {
    public static void main(String[] args) {
        String[] name = {"kim", "lee", "park"};
        System.out.println(Arrays.toString(name));

        for (int i = 0; i < 10; i++) {
            System.out.println(name[(int)(Math.random()*3)]);
        }
    }
}
