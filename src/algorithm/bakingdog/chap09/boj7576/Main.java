package algorithm.bakingdog.chap09.boj7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] size = bf.readLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);
        int[][] box = new int[m][n];
        for (int i = 0; i < m; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                box[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        System.out.println(bfs(box, m, n));

    }

    private static int bfs(int[][] box, int m, int n) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int answer = -1;
        Queue<Point> q = findTomato(box, m, n);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int cnt = 0; cnt < size; cnt++) {
                Point p = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if (safe(nx, ny, m, n) && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        q.add(new Point(nx, ny));
                    }
                }
            }
            answer++;
        }
        if (!tomatoAllRipe(box, m, n)) {
            answer = -1;
        }
        return answer;
    }

    private static boolean safe(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private static boolean tomatoAllRipe(int[][] box, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (box[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Queue<Point> findTomato(int[][] box, int m, int n) {
        Queue<Point> tomato = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (box[i][j] == 1) {
                    tomato.add(new Point(i, j));
                }
            }
        }
        return tomato;
    }
}
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
