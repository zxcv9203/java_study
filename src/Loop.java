import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        String pw = "abc123";
        Scanner scanner = new Scanner(System.in);
        String input = "";
//        while (input.equals(pw)) {
//            System.out.println("패스워드를 입력해주세요 : ");
//            input = scanner.nextLine();
//        }
        do {
            System.out.println("패스워드를 입력해주세요 : ");
            input = scanner.nextLine();
        } while (!input.equals(pw));

        System.out.println(input);
    }
}
