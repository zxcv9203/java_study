package algorithm.programmers.level1;

import java.util.Arrays;

public class WePicture {

    static final String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static boolean[] visit;
    static int ans;
    static boolean dataCheck(String we, String[] data) {
        for (String cond : data) {
            int to = we.indexOf(cond.charAt(0));
            int from = we.indexOf(cond.charAt(2));
            String op = String.valueOf(cond.charAt(3));
            int n = (int) cond.charAt(4) - '0' + 1;
            int pos = Math.abs(to - from);
            switch (op) {
                case "=":
                    if (pos == n)
                        break;
                    return false;
                case ">":
                    if (pos > n)
                        break;
                    return false;
                case "<":
                    if (pos < n)
                        break;
                    return false;
                default:
                    return false;
            }
        }
        return true;
    }
    static void dfs(String we, String[] data, int depth) {
        if (depth == 8) {
            if (dataCheck(we, data))
                ans++;
            return ;
        }
        for (int i = 0; i < 8; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(we + friends[i], data, depth+1);
                visit[i] = false;
            }
        }
    }
    static int solution(int n, String[] data) {
        ans = 0;
        visit = new boolean[8];
        dfs("", data,0);
        return ans;
    }
    public static void main(String[] args) {
        int n = 2;
        String[] data = {
                "N~F=0",
                "R~T>2"
        };
        System.out.println(solution(n, data));
    }
}
