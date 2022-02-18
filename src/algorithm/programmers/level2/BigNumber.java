package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class BigNumber {
    static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] conv = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            conv[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(conv, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return (t1+s).compareTo(s+t1);
            }
        });
        if (conv[0].equals("0")) {
            return "0";
        }
        for (String n : conv) {
            answer.append(n);
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        int[] numbers = {0, 0, 0};
        System.out.println(solution(numbers));
    }
}
