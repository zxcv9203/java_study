package algorithm.bakingdog.chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        int number = Integer.parseInt(reader.readLine());

        for (int i = 0; i < number; i++) {
            String input = reader.readLine();
            String[] command = input.split(" ");
            switch (command[0]) {
                case "push" -> stack.push(Integer.parseInt(command[1]));
                case "pop" -> {
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.pop());
                    }
                }
                case "size" -> System.out.println(stack.size());
                case "empty" -> System.out.println(stack.isEmpty() ? 1 : 0);
                case "top" -> {
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.peek());
                    }
                }
            }
        }
    }
}
