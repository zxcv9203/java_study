package algorithm.programmers.level1;

import java.util.Arrays;

public class Exam {
    static int[] solution(int[] answers) {
        int[] students = {0, 0, 0};
        int[] twos = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] threes = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for (int i = 0; i < answers.length; i++) {
            int one = i % 5 + 1;
            int two = twos[i % 8];
            int three = threes[i % 10];
            if (one == answers[i]) {
                students[0]++;
            }
            if (two == answers[i]) {
                students[1]++;
            }
            if (three == answers[i]) {
                students[2]++;
            }
        }
        int max = -1;
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (students[i] > max) {
                max = students[i];
                cnt = 1;
            } else if (max != -1 && students[i] == max) {
                cnt++;
            }
        }
        int[] answer = new int[cnt];
        int idx = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == max) {
                answer[idx++] = i+1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        System.out.println(Arrays.toString(solution(answers)));
    }
}
