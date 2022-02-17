package algorithm.programmers.level1;

import java.util.Arrays;

public class Budget {
    static int solution(int[] d, int budget) {
        int answer = 0;
        int idx = 0;

        Arrays.sort(d);
        while (budget > 0 && idx < d.length) {
            budget -= d[idx];
            idx++;
            if (budget >= 0)
                answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] d = {1, 3, 2, 5, 4};
        int budget = 20;
        System.out.println(solution(d, budget));
    }
}
