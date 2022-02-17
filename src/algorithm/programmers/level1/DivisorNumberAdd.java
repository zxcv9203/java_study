package algorithm.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class DivisorNumberAdd {
    static int divisorNumber(int n) {
        int cnt = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                cnt++;
                if (i * i < n) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            if (divisorNumber(i) % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int left = 13;
        int right = 17;

        System.out.println(solution(13, 17));
    }
}
