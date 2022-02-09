package algorithm.programmers.level1;

public class GoodRectangle {
    private static long GCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }
    static long solution(int w, int h) {
        long rectangle = (long) w * h;

        long answer;

        answer = rectangle - ((long) w + (long) h - GCD(w, h));
        return answer;
    }
    public static void main(String[] args) {
        int w = 7;
        int h = 14;

        System.out.println(solution(w, h));
    }
}
