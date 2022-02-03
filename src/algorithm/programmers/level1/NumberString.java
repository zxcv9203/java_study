package algorithm.programmers.level1;

public class NumberString {
    static int solution(String s) {
        int answer = 0;
        String[] numbers = {
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine"
        };
        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(numbers[i], Integer.toString(i));
        }
        answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }
}
