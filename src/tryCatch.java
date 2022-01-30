import java.util.Scanner;

public class tryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            int value = Integer.parseInt(input);
            System.out.println(value + 3);
        } catch (Exception e) {
            System.out.println("숫자를 입력해야 합니다.");
        }

    }
}
