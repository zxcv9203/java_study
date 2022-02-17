package algorithm.programmers.level1;

public class ThreeReverse {
    static final String[] three = {"0", "1", "2"};
    static int solution(int n) {
        int answer = 0;
        int digit = 1;
        StringBuilder tmp = new StringBuilder();
        while (n != 0) {
            tmp.append(three[n % 3]);
            n /= 3;
        }
        tmp.reverse();
        for (char c : tmp.toString().toCharArray()) {
            answer += (c - '0') * digit;
            digit *= 3;
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 45;
        System.out.println(solution(n));
    }
}
