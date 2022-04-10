package algorithm.bakingdog.chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new ArrayDeque<>();

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push" -> {
                    q.add(Integer.parseInt(command[1]));
                }
                case "pop" -> {
                    if (q.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(q.poll());
                    }
                }
                case "size" -> {
                    System.out.println(q.size());
                }
                case "empty" -> {
                    System.out.println(q.isEmpty() ? 1 : 0);
                }
                case "front" -> {
                    if (q.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(q.peekFirst());
                    }
                }
                case "back" -> {
                    if (q.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(q.peekLast());
                    }
                }
            }
        }
    }
}
