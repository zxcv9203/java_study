package algorithm.programmers.level2;

import java.util.Stack;

public class CoupleRemove {
    static int solution(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            int front = -1;
            if (!stack.isEmpty())
                front = stack.peek();
            if (c == front) {
                stack.pop();
            } else {
                stack.push((int) c);
            }
        }
        if (stack.isEmpty()) {
            answer = 1;
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
