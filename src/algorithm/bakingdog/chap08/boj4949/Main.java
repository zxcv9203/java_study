package algorithm.bakingdog.chap08.boj4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringBuilder word = new StringBuilder(bf.readLine());
            Deque<Character> stack = new ArrayDeque<>();
            if (".".equals(word.toString()))
                break;
            StringBuilder answer = new StringBuilder("no");
            boolean valid = true;
            for (Character c : word.toString().toCharArray()) {
                valid = charCheck(stack, c);
                if (!valid) break;
            }
            if (stack.isEmpty() && valid) {
                answer = new StringBuilder("yes");
            }
            System.out.println(answer);
        }
    }

    private static boolean charCheck(Deque<Character> stack, Character c) {
            return switch (c) {
                case '(', '[' -> {
                    stack.add(c);
                    yield true;
                }
                case ')' -> {
                    if (stack.isEmpty()) {
                        yield false;
                    }
                    if (stack.peekLast() == '(') {
                        stack.pollLast();
                        yield true;
                    } else {
                        yield false;
                    }
                }
                case ']' -> {
                    if (stack.isEmpty()) {
                        yield false;
                    }
                    if (stack.peekLast() == '[') {
                        stack.pollLast();
                        yield true;
                    } else {
                        yield false;
                    }
                }
                default -> true;
            };
        }
}
