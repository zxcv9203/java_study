package algorithm.bakingdog.chap09.boj1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    private static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> paper = new ArrayList<>();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int cnt = 0;
        int size = 0;
        for (int i = 0; i < n; i++) {
            paper.add(br.readLine().replaceAll("\s", ""));
        }
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] || paper.get(i).charAt(j) == '0')
                    continue;
                size = Math.max(bfs(paper, n, m, i, j), size);
                cnt++;
            }
        }
        System.out.println(cnt);
        System.out.println(size);
    }

    private static int bfs(List<String> paper, int n, int m, int x, int y) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Queue<Point> q = new LinkedList<>();
        int size = 1;
        q.add(new Point(x, y));
        visit[x][y] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if (safe(nx, ny, n, m) && paper.get(nx).charAt(ny) == '1' && !visit[nx][ny]) {
                    q.add(new Point(nx, ny));
                    visit[nx][ny] = true;
                    size++;
                }
            }
        }
        return size;
}

    private static boolean safe(int nx, int ny, int x, int y) {
        return nx >= 0 && nx < x && ny >= 0 && ny < y;
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
