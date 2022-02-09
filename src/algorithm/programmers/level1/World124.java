package algorithm.programmers.level1;

public class World124 {
    static String ans;
    static void dfs(int n) {
        String[] word = {"4", "1", "2"};
        if (n <= 0) {
            return ;
        }
        if (n % 3 == 0) {
            dfs(n / 3 - 1);
        } else {
            dfs(n / 3);
        }
        int digit = n % 3;
        ans += word[digit];
    }
    static String solution(int n) {
        ans = "";
        dfs(n);
        return ans;
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(solution(n));
    }
}
