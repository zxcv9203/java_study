package algorithm.bakingdog.chap08.boj10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> s = new ArrayDeque<>();
        String pipe = bf.readLine();
        int answer = 0;
        char front = ')';
        for (Character c : pipe.toCharArray()) {
            if (c == '(') {
                s.push(c);
            } else {
                s.pop();
                if (front == '(') {
                    answer += s.size();
                } else {
                    answer++;
                }
            }
            front = c;
        }
        System.out.println(answer);
    }
}