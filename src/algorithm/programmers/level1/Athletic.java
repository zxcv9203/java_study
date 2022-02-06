package algorithm.programmers.level1;

import java.util.Arrays;

public class Athletic {
    static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        int lIdx = 0;
        int rIdx = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    reserve[j] = 0;
                    lost[i] = 0;
                    break;
                }
            }
        }
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] != 0)
                break;
            lIdx++;

        }
        for (int i = 0; i < reserve.length; i++) {
            if (reserve[i] != 0)
                break;
            rIdx++;
        }
        for (int i = lIdx; i < lost.length; i++) {
            for (int j = rIdx; j < reserve.length; j++) {
                if (lost[i]-1 == reserve[j] || lost[i]+1 == reserve[j]) {
                    answer++;
                    reserve[j] = 0;
                    rIdx = j+1;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 8;
        int[] lost = {
                     2,3,4

        };
        int[] reserve = {
               1
        };

        System.out.println(solution(n, lost, reserve));
    }
}
