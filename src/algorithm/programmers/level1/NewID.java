package algorithm.programmers.level1;

import java.util.Locale;

public class NewID {
    static String solution(String new_id) {
        StringBuilder answer = new StringBuilder(new_id);
        
        // 1단계
        answer = new StringBuilder(answer.toString().toLowerCase(Locale.ROOT));
        // 2단계
        answer = new StringBuilder(answer.toString().replaceAll("[^a-z\\d\\-_.]*", ""));
        // 3단계
        answer = new StringBuilder(answer.toString().replaceAll("\\.{2,}", "."));
        // 4단계
        answer = new StringBuilder(answer.toString().replaceAll("^[.]|[.]$", ""));
        // 5단계
        if (answer.toString().equals("")) {
            answer = new StringBuilder("a");
        }
        // 6단계
        if (answer.length() >= 16) {
            answer = new StringBuilder(answer.substring(0, 15));
        }
        answer = new StringBuilder(answer.toString().replaceAll("[.]$", ""));
        // 7단계
        while (answer.length() <= 2) {
            answer.append(answer.charAt(answer.length() - 1));
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        String id = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(solution(id));
    }
}
