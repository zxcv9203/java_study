package algorithm.programmers.level2;

public class TargetNumber {
    static int cnt;

    static void dfs(int[] numbers, int target, int depth, int n) {
        if (depth == numbers.length && target == n) {
            cnt++;
            return ;
        }
        if (depth >= numbers.length) {
            return ;
        }
        dfs(numbers, target, depth + 1, n + numbers[depth] * -1);
        dfs(numbers, target, depth + 1, n + numbers[depth]);
    }
    static int solution(int[] numbers, int target) {
        cnt = 0;
        dfs(numbers, target, 0, 0);
        return cnt;
    }


    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        System.out.println(solution(numbers, target));
    }
}
