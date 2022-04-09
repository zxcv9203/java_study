package algorithm.bakingdog.chap04;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Character> answer = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        int number = Integer.parseInt(br.readLine());
        for (char c : word.toCharArray()) {
            answer.add(c);
        }
        ListIterator<Character> iter = answer.listIterator(answer.size());
        for (int i = 0; i < number; i++) {
            char[] command = br.readLine().toCharArray();
            switch (command[0]) {
                case 'L' -> {
                    if (iter.hasPrevious())
                        iter.previous();
                }
                case 'D' -> {
                    if (iter.hasNext())
                        iter.next();
                }
                case 'B' -> {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                }
                case 'P' -> {
                    char character = command[2];
                    iter.add(character);
                }
            }
        }

        for(char c : answer)
            bw.append(c);
        bw.flush();
        bw.close();
        br.close();
    }
}
