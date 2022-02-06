package algorithm.programmers.level1;

import java.util.Arrays;

public class KNumber {
    static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] command : commands) {
            int[] tmp = array.clone();
            int st = command[0] - 1;
            int ed = command[1];
            int pick =  command[0]-1+command[2]-1;
            Arrays.sort(tmp, command[0]-1, command[1]);
            answer[idx++] = tmp[pick];
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] command = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        System.out.println(Arrays.toString(solution(array,command)));
    }
}
