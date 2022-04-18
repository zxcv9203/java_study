package algorithm.bakingdog.chap09.boj2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static boolean safe(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    public static int bfs(String[] maze, int n, int m) {
        boolean[][] visit = new boolean[n][m];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int answer = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        visit[0][0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Point p = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if (safe(nx, ny, n, m) && maze[nx].charAt(ny) == '1' && !visit[nx][ny]) {
                        if (nx == n - 1 && ny == m - 1) {
                            return answer + 2;
                        }
                        q.add(new Point(nx, ny));
                        visit[nx][ny] = true;
                    }
                }
            }
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] mapSize = bf.readLine().split(" ");
        int n = Integer.parseInt(mapSize[0]);
        int m = Integer.parseInt(mapSize[1]);
        String[] maze = new String[n];
        for (int i = 0; i < n; i++) {
            maze[i] = bf.readLine();
        }
        System.out.println(bfs(maze, n, m));
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}