package algorithm.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximizeFormula {
    static boolean[] used;
    final static char[] op = {'*', '-', '+'};
    static ArrayList<Long> numbers;
    static ArrayList<Character> opList;
    static long answer;
    static long operationCalc(long a, long b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                return 0;
        }
    }
    static void calc(char[] priority) {
        ArrayList<Long> formula = new ArrayList<>(numbers);
        ArrayList<Character> op = new ArrayList<>(opList);
        for(int i = 0; i < priority.length; i++) {
            for (int j = 0; j < op.size(); j++) {
                if (priority[i] == op.get(j)) {
                    Long ret = operationCalc(formula.remove(j), formula.remove(j), priority[i]);
                    formula.add(j, ret);
                    op.remove(j);
                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(formula.get(0)));
        System.out.println(answer);
    }
    static void dfs(int depth, char[] priority, int idx) {
        if (depth == 3) {
            calc(priority);
            return ;
        }
        for (int i = 0; i < 3; i++) {
            if (used[i]) continue;
            used[i] = true;
            priority[idx] = op[i];
            dfs(depth + 1, priority, idx + 1);
            used[i] = false;
        }
    }
    static long solution(String expression) {
        answer = 0;
        numbers = new ArrayList<>();
        opList = new ArrayList<>();
        int size = expression.length();
        used = new boolean[3];
        for (int i = 0; i < size; i++) {
            StringBuilder num = new StringBuilder();
            while (i < size && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                num.append(expression.charAt(i++));
            }
            if (i >= size) {
                numbers.add(Long.parseLong(num.toString()));
                break;
            }
            numbers.add(Long.parseLong(num.toString()));
            opList.add(expression.charAt(i));
        }
        System.out.println(numbers);
        dfs(0, new char[3], 0);
        return answer;
    }
    public static void main(String[] args) {
        String expression = "1*2+3-4";
        System.out.println(solution(expression));
    }
}
