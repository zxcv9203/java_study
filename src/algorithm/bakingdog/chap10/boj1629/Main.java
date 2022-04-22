package algorithm.bakingdog.chap10.boj1629;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextInt();
        long b = scanner.nextInt();
        long c = scanner.nextInt();
        System.out.println(recursive(a, b, c));
    }

    private static long recursive(long a, long b, long c) {
        if (b == 1)
            return a % c;
        long ret = recursive(a, b / 2, c);
        ret = ret * ret % c;
        if (b % 2 == 0)
            return ret;
        return ret * a % c;
    }
}
