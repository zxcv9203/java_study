package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MoreSpicy {
    static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int s : scoville) {
            heap.add(s);
        }
        try {
            while (heap.peek() < K) {
                int lowest = heap.poll();
                int low = heap.poll();
                heap.add(lowest + low * 2);
                answer++;
            }
        } catch (Exception e) {
            return -1;
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] scoville = {1,2,3,9,10,12};
        int k = 7;
        System.out.println(solution(scoville, k));
    }
}
