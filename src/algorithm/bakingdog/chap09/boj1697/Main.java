package algorithm.bakingdog.chap09.boj1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static final int M = 200000;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] position = bf.readLine().split(" ");
        int subin = Integer.parseInt(position[0]);
        int brother = Integer.parseInt(position[1]);
        System.out.println(bfs(subin, brother));
    }

    private static int bfs(int subin, int brother) {
        int[] dx = {1, -1, 2};
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[M + 1];

        if (subin == brother) {
            return 0;
        }
        int move = 0;
        q.add(subin);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int cnt = 0; cnt < size; cnt++) {
                int pos = q.poll();
                dx[2] = pos;
                for (int i = 0; i < 3; i++) {
                    int movePos = pos + dx[i];
                    if (safe(movePos) && !visit[movePos]) {
                        if (movePos == brother) {
                            return move + 1;
                        }
                        q.add(movePos);
                        visit[movePos] = true;
                    }
                }
            }
            move++;
        }
        return move;
    }

    private static boolean safe(int movePos) {
        return movePos >= 0 && movePos < M + 1;
    }
}
