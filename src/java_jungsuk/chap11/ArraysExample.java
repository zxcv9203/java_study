package java_jungsuk.chap11;

import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        int[][] arr2D = {
                {11, 12, 13},
                {21, 22, 23}
        };

        // 배열을 문자열로 변환하여 출력합니다.
        System.out.println("arr = " + Arrays.toString(arr));
        // 다차원 배열을 문자열로 변환하여 출력합니다.
        System.out.println("arr2D = " + Arrays.deepToString(arr2D));

        // 배열을 0부터 특정 길이만큼 복사합니다. (길이는 -1 됨)
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, 3);
        int[] arr4 = Arrays.copyOf(arr, 7);
        // 배열을 시작점과 끝점 만큼 복사합니다. (끝 인덱스는 -1 됨)
        int[] arr5 = Arrays.copyOfRange(arr, 2, 4);
        int[] arr6 = Arrays.copyOfRange(arr, 0, 7);

        System.out.println("arr2 = " + Arrays.toString(arr2));
        System.out.println("arr3 = " + Arrays.toString(arr3));
        System.out.println("arr4 = " + Arrays.toString(arr4));
        System.out.println("arr5 = " + Arrays.toString(arr5));
        System.out.println("arr6 = " + Arrays.toString(arr6));

        int[] arr7 = new int[5];
        // 배열을 특정 값으로 채웁니다.
        Arrays.fill(arr7, 9);
        System.out.println("arr7 = " + Arrays.toString(arr7));

        // 람다식을 사용하여 배열의 값을 설정합니다.
        Arrays.setAll(arr7, i -> (int) (Math.random()*6)+1);
        System.out.println("arr7 = " + Arrays.toString(arr7));

        // 배열에 들어간 수만큼 별을 출력하는 반복문
        for (int i : arr7) {
            char[] graph = new char[i];
            Arrays.fill(graph, '*');
            System.out.println(new String(graph) + " " + i);
        }

        String[][] str2D = new String[][]{
                {"aaa", "bbb"},
                {"AAA", "BBB"}
        };
        String[][] str2D2 = new String[][]{
                {"aaa", "bbb"},
                {"AAA", "BBB"}
        };

        // 다차원 배열의 비교시에는 반드시 deepEquals를 사용해야 합니다.
        System.out.println(Arrays.equals(str2D, str2D2));
        System.out.println(Arrays.deepEquals(str2D, str2D2));

        char[] chArr = {'A', 'D', 'C', 'B', 'E'};

        // 이진 탐색을 하려면 반드시 배열이 정렬된 상태여야 합니다.
        System.out.println("chArr = " + Arrays.toString(chArr));
        System.out.println("index of B = " + Arrays.binarySearch(chArr, 'B'));
        System.out.println("= After sorting =");
        Arrays.sort(chArr);
        System.out.println("index of B = " + Arrays.binarySearch(chArr, 'B'));

    }
}
