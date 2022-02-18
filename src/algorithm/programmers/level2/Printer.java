package algorithm.programmers.level2;

import java.util.*;

public class Printer {
    static boolean isTopPriority(Queue<Task> q, Task task) {
        for (Task t : q) {
            if (t.priority > task.priority) {
                return false;
            }
        }
        return true;
    }
    static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Task> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            q.add(new Task(i, priorities[i]));
        }
        int prev = 0;
        while (!q.isEmpty()) {
            Task task = q.poll();
            if (!isTopPriority(q, task)) {
                q.add(task);
                continue;
            }
            answer++;
            if (location == task.location) {
                break;
            }
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

    Task(int location, int priority) {
        this.location = location;
        this.priority = priority;
    }
}