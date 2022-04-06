package java_jungsuk.chap11;

import java.util.Arrays;
import java.util.Comparator;

public class CompareExample1 {
    public static void main(String[] args) {
        String[] strArr = {
                "cat", "Dog", "lion", "tiger"
        };

        Arrays.sort(strArr);
        System.out.println("strArr = " + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);     // 대소문자 구별없이 sort
        System.out.println("strArr = " + Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending());          // 역순 정렬
        System.out.println("strArr = " + Arrays.toString(strArr));

    }

    static class Descending implements Comparator<Object> {
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Comparable && o2 instanceof Comparable) {
                Comparable c1 = (Comparable) o1;
                Comparable c2 = (Comparable) o2;
                return c1.compareTo(c2) * -1;       // -1을 곱해서 역순 정렬로 만듬 (c1과 c2의 위치를 변경해도 가능)
            }
            return -1;
        }
    }
}
