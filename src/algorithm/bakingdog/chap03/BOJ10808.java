package algorithm.bakingdog.chap03;

import java.util.Scanner;

public class BOJ10808 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] alpha = new int[26];

        String str = scanner.nextLine();
        for (char c : str.toCharArray()) {
            alpha[c - 'a']++;
        }
        for (int n : alpha) {
            System.out.print(n + " ");
        }
    }
}
