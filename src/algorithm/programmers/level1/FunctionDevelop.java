package algorithm.programmers.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelop {
    static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        int idx = 0;
        int time = 1;
        int cnt = 0;

        for (int progress : progresses) {
            q.add(progress);
        }
        while (!q.isEmpty()) {
            int progress = q.peek();
            int addProgress = time * speeds[idx];
            if (addProgress + progress >= 100) {
                q.poll();
                cnt++;
                idx++;
                continue;
            }
            if (cnt > 0) {
                ans.add(cnt);
                cnt = 0;
            }
            time++;
        }
        ans.add(cnt);
        return ans.stream().mapToInt(i->i).toArray();
    }
    public static void main(String[] args) {
        int[] progress = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(solution(progress, speeds)));
    }
}
