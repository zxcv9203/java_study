package DevCourse.CodingTest;

import java.util.Arrays;

public class Ex01 {
    static int solution(int[] arr) {
        int answer = -1;
        int diff = 1000000;
        for (int i = 0; i <= 255; i++) {
            int a = 0;
            int b = 0;
            for (int n : arr) {
                if (n >= i) {
                    a++;
                } else {
                    b++;
                }
            }
            if (diff > Math.abs(a - b)) {
                diff = Math.abs(a - b);
                answer = Math.abs(i);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] arr = {
               0, 0, 0
        };
        System.out.println(solution(arr));
    }
}
