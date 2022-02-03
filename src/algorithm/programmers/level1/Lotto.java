package algorithm.programmers.level1;

import java.util.Arrays;

public class Lotto {
    public static int[] solution(int[] lottos, int[] win_nums) {
        final int rank = 7;
        int[] answer = new int[2];
        int cnt = 0;
        int zero = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zero++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    cnt++;
                    break;
                }
            }
        }
        answer[0] = rank - (cnt + zero);
        answer[1] = rank - cnt;
        if (answer[0] == 7) {
            answer[0]--;
        }
        if (answer[1] == 7) {
            answer[1]--;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }
}
