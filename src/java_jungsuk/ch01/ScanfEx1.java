package java_jungsuk.ch01;

import java.util.Scanner;

public class ScanfEx1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        String input = scanner.nextLine();
        int n = Integer.parseInt(input);
        System.out.println(n);
    }
}
