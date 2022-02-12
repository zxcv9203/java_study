package algorithm.programmers.level2;

import java.util.Stack;

public class ParenthesisConversion {
    final static int OK = 0;
    static boolean validateCheck(String p) {
        int match = 0;
        for (int i = 0; i < p.length(); i++) {
            String parenthesis = String.valueOf(p.charAt(i));
            switch (parenthesis) {
                case "(":
                    match++;
                    break;
                case ")":
                    match--;
                    break;
                default:
                    break;
            }
            if (match < 0)
                return false;
        }
        return true;
    }
    static String validParenthesis(String p) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < p.length(); i++) {
            String parenthesis = String.valueOf(p.charAt(i));
            switch (parenthesis) {
                case "(":
                    ans.append(")");
                    break;
                case ")":
                    ans.append("(");
                    break;
                default:
                    break;
            }
        }
        return ans.toString();
    }
    static String[] parenthesisSeparation(String p) {
        String[] separation = new String[2];
        Stack<String> s = new Stack<>();
        int match = OK;
        int idx = 0;
        do {
            String parenthesis = String.valueOf(p.charAt(idx++));

            switch (parenthesis) {
                case "(":
                    match++;
                    break;
                case ")":
                    match--;
                    break;
                default:
                    break;
            }
            s.push(parenthesis);
        } while(match != OK);
        separation[0] = p.substring(0, idx);
        separation[1] = p.substring(idx);
        return separation;
    }
    static String solution(String p) {
        String ans = "";
        if (p.length() == 0) {
            return "";
        }
        String[] w = parenthesisSeparation(p);
        String u = w[0];
        String v = w[1];
        if (validateCheck(u)) {
            u += solution(v);
            return u;
        }
        ans += "(";
        ans += solution(v);
        u = u.substring(1, u.length()-1);
        u = validParenthesis(u);
        ans += ")";
        ans += u;
        return ans;
    }
    public static void main(String[] args) {
        String p = "()))((()";
        System.out.println(solution(p));
    }
}
