package algorithm.programmers.level2;

public class MaximizeFormula {

//    static long dfs(String p, int idx, String expression) {
//        if (idx == 2) {
//            return
//        }
//    }
    static long solution(String expression) {
        long answer = 0;

        String[] priority = {
                "*-+",
                "*+-",
                "+*-",
                "+-*",
                "-+*",
                "-*+"
        };
//        for (String p : priority) {
//            long tmp = dfs(p, 0, expression);
//            answer = Math.max(answer, Math.abs(tmp));
//        }
        return answer;
    }
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }
}
