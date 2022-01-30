import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
//        Scanner scanner;
//        scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        System.out.println(input);
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.next();
//        String input2 = scanner.next();
//
//        System.out.println(input);
//        System.out.println(input2);
        System.out.println("숫자 입력 : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int value = Integer.parseInt(input);
        System.out.println(value * 4);
    }
}
