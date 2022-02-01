package java_jungsuk.chap05;

import java.util.Arrays;

public class PrintArrayExam {
    public static void main(String[] args) {
        int[] arr = {100, 95, 80, 70, 60};
        char[] chArr = {'a', 'b', 'c', 'd'};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println(chArr);
        System.out.println(Arrays.toString(arr));
    }
}
