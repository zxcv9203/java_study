package algorithm.programmers.level1;

public class MinusPlus {
    static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (!signs[i])
                absolutes[i] *= -1;
            answer += absolutes[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};

        System.out.println(solution(absolutes, signs));
    }
}
