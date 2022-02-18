package algorithm.programmers;

import java.util.Arrays;

public class Solution {
    static int notUsed(int[][] v, int idx) {
        for (int i = 0; i < v.length; i++) {
            boolean flag = false;
            for (int j = 0; j < v.length; j++) {
                if (i == j) continue;
                if (v[i][idx] == v[j][idx]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return v[i][idx];
            }
        }
        return -1;
    }
    static int[] solution(int[][] v) {
        int[] answer = new int[2];
        answer[0] = notUsed(v, 0);
        answer[1] = notUsed(v, 1);

        return answer;
    }

    public static void main(String[] args) {
        int[][] v = {
            {1, 4},
            {3, 4},
            {3, 10}
        };
        System.out.println(Arrays.toString(solution(v)));
    }
}
