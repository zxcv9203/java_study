package algorithm.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

public class LightDistanceCycle {

    static int[] solution(String[] grid) {
        ArrayList<Integer> answer = new ArrayList<>();


        return answer.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        String[] grid = {
                "SL", "LR"
        };
        System.out.println(Arrays.toString(solution(grid)));
    }
}
