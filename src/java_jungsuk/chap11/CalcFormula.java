package java_jungsuk.chap11;

import java.util.Stack;

public class CalcFormula {
    final static int ARGS_ERR = 1;
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("수식을 입력해주세요");
            System.exit(ARGS_ERR);
        }

        Stack<Character> st = new Stack<>();
        String expression = "((())";

        System.out.println(expression);
        try {
            for (char c : expression.toCharArray()) {
                switch (c) {
                    case '(' -> st.push(c);
                    case ')' -> st.pop();
                    default -> {
                    }
                }
            }
            if (st.isEmpty()) {
                System.out.println("괄호의 개수가 일치합니다.");
            } else {
                System.out.println("괄호의 개수가 다릅니다.");
            }
        } catch (Exception ignored) {
            System.out.println("괄호의 개수가 다릅니다.");
        }
    }
}
