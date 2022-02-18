package algorithm.programmers.level2;

import java.util.ArrayList;
import java.util.Stack;

public class Printer {
    static int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Task> task = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] priorities = {
                2, 1, 3, 2
        };
        int location = 2;
        System.out.println(solution(priorities, location));
    }
}

class Task {
    int location;
    int priority;
}