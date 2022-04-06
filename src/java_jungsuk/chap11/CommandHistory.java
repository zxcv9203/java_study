package java_jungsuk.chap11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CommandHistory {
    final static int NORMAL_EXIT = 0;
    final static int MAX_SIZE = 5;
    static Queue<String> q = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");

        while (true) {
            System.out.print("> ");
            try {
                Scanner s = new Scanner(System.in);
                String input = s.nextLine().trim();

                save(input);
                input = input.toLowerCase();
                switch (input) {
                    case "q" -> {
                        System.out.println("bye");
                        System.exit(NORMAL_EXIT);
                    }
                    case "help" -> {
                        System.out.println("help - 도움말을 보여줍니다.");
                        System.out.println("q - 프로그램을 종료합니다.");
                        System.out.println("history - 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");
                    }
                    case "history" -> {
                        save(input);        // 입력받은 명령어를 저장하는 함수
                        // Queue -> LinkedList 변환 후 순회하며 출력
                        LinkedList<String> list = (LinkedList<String>) q;
                        System.out.println("history");
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println(i+1 + ". " + list.get(i));
                        }
                    }
                    default -> System.out.println("Command not found");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void save(String input) {
        if (q.size() > MAX_SIZE) {
            q.poll();
        }
        if (!input.equals("")) {
            q.offer(input);
        }
    }
}
