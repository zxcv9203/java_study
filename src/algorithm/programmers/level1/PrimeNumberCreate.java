package algorithm.programmers.level1;

public class PrimeNumberCreate {
    static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    boolean flag = true;
                    for (int l = 2; l*l <= tmp; l++) {
                        if (tmp % l == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        System.out.println(solution(nums));
    }
}
