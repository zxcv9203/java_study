package algorithm.bakingdog.chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push_front" -> dq.addFirst(Integer.parseInt(command[1]));
                case "push_back" -> dq.addLast(Integer.parseInt(command[1]));
                case "pop_front" -> {
                    if (dq.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq.pollFirst());
                    }
                }
                case "pop_back" -> {
                    if (dq.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq.pollLast());
                    }
                }
                case "size" -> System.out.println(dq.size());
                case "empty" -> System.out.println(dq.isEmpty() ? 1 : 0);
                case "front" -> {
                    if (dq.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq.peekFirst());
                    }
                }
                case "back" -> {
                    if (dq.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq.peekLast());
                    }
                }
            }
        }
    }
}
