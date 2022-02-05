package algorithm.programmers.level1;

import java.util.LinkedList;
import java.util.Queue;

class dial {
    static final int x = 0;
    static final int y = 1;

    static int[][] dial = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {-2, 0, -1}
    };
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean visit[][] = {
            {false, false, false},
            {false, false, false},
            {false, false, false},
            {false, false, false}
    };

    static boolean safe(int nx, int ny) {
        return nx >= 0 && nx < 4 && ny >= 0 && ny < 3;
    }
    static void visitInit() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                visit[i][j] = false;
            }
        }
    }
    static int[] Position(int n) {
        int[] pos = new int[2];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (n == dial[i][j]) {
                    pos[x] = i;
                    pos[y] = j;
                    break;
                }
            }
        }
        return pos;
    }
    static int shortestPath(int[] pos, int target) {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();

        if (dial[pos[x]][pos[y]] == target)
            return cnt;
        q.add(pos);
        visit[pos[x]][pos[y]] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            for (int s = 0; s < size; s++) {
                int[] nPos = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = nPos[x] + dx[i];
                    int ny = nPos[y] + dy[i];
                    if (safe(nx, ny) && dial[nx][ny] == target) {
                        return cnt;
                    }
                    if (safe(nx, ny) && !visit[nx][ny] && dial[nx][ny] != target) {
                        q.add(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        return cnt;
    }
}
public class KeyPad {

    static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        // right # == -1
        int right = -1;
        // left * == -2
        int left = -2;

        for (int number : numbers) {
            switch (number) {
                case 1:
                case 4:
                case 7:
                    answer.append("L");
                    left = number;
                    break;
                case 3:
                case 6:
                case 9:
                    answer.append("R");
                    right = number;
                    break;
                default:
                    int[] leftPos = dial.Position(left);
                    int[] rightPos = dial.Position(right);
                    int rPath = dial.shortestPath(rightPos, number);
                    dial.visitInit();
                    int lPath = dial.shortestPath(leftPos, number);
                    dial.visitInit();
                    System.out.printf("%d %d %d\n", number, left, right);
                    if (rPath < lPath) {
                        answer.append("R");
                        right = number;
                    } else if (rPath > lPath) {
                        answer.append("L");
                        left = number;
                    } else { // same
                        switch (hand) {
                            case "right":
                                answer.append("R");
                                right = number;
                                break;
                            case "left":
                                answer.append("L");
                                left = number;
                                break;
                        }
                    }
                    break;
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        System.out.println(solution(numbers, hand));
    }
}
