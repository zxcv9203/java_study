package algorithm.programmers.level1;

import java.util.Scanner;


public class DecimalFind {
    public static int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            boolean prime = true;
            for (int j = 2; j*j <= i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break ;
                }
            }
            if (prime) {
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int n;

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println(solution(n));
    }
}
