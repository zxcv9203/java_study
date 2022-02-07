package algorithm.programmers.level1;

public class Phonketmon {
    static int solution(int[] nums) {
        final int kinds = 200000;
        int answer = 0;
        int pick = nums.length / 2;
        boolean[] check = new boolean[kinds+1];

        for (int num : nums) {
            if (check[num])
                continue ;
            answer++;
            check[num] = true;
            if (pick == answer)
                break;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {3};

        System.out.println(solution(nums));
    }
}
