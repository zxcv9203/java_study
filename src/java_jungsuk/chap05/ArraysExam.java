package java_jungsuk.chap05;

import java.util.Arrays;

public class ArraysExam {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        int[][] arr2D = {
                {11, 12},
                {21, 22}
        };
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.deepToString(arr2D));

        String[][] s2D = {
                {"aaa", "bbb"},
                {"AAA", "BBB"}
        };
        String[][] s2D2 = {
                {"aaa", "bbb"},
                {"AAA", "BBB"}
        };
        System.out.println(Arrays.deepEquals(s2D, s2D2));

        int[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = Arrays.copyOfRange(arr, 2, 4);
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {3, 4, 0, 1, 2};
        System.out.println(Arrays.toString(arr4));
        Arrays.sort(arr4);
        System.out.println(Arrays.toString(arr4));

    }
}
