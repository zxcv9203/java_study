package java_jungsuk.ch04;

import java.util.Scanner;

public class DoWhileExam {
    public static void main(String[] args) {
        int input = 0;
        int ans = 0;

        ans = (int)(Math.random() * 100) + 1;
        System.out.println(ans);

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("100사이의 수를 입력해주세요 > ");
            input = scanner.nextInt();

            if (input > ans) {
                System.out.println("smaller");
            } else if (input < ans) {
                System.out.println("bigger");
            }
        }while (input != ans);
        System.out.println("solved");
    }
}
