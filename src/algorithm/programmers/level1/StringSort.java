package algorithm.programmers.level1;

import java.util.Scanner;

public class StringSort {
    public static String solution(String s) {
        String answer = "";
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i; j < s.length(); j++) {
                if (ch[i] < ch[j]) {
                    char tmp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = tmp;
                }
            }
        }
        answer = String.valueOf(ch);
        return answer;
    }
    public static void main(String[] args) {;
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(solution(s));
    }
}
