package algorithm.bakingdog.chap09.boj4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] size = bf.readLine().split(" ");
        int r = Integer.parseInt(size[0]);
        int c = Integer.parseInt(size[1]);
        StringBuffer[] maze = new StringBuffer[r];

        for (int i = 0; i < r; i++) {
            maze[i] = new StringBuffer();
            maze[i].append(bf.readLine());
        }
        int time = bfs(maze, r, c);
        System.out.println(time != 0 ? time : "IMPOSSIBLE");
    }

    private static int bfs(StringBuffer[] maze, int r, int c) {
        Queue<Point> user = new LinkedList<>();
        Queue<Point> fire = new LinkedList<>();
        int time = 0;
        Point p = readMaze(maze, user, fire, r, c);
        if (possibleExit(p.x, p.y, r - 1, c - 1)) {
            return time + 1;
        }
        while (!user.isEmpty()) {
            time++;
            move(maze, fire, 'F', r, c);
            if (move(maze, user, 'J', r, c)) {
                return time + 1;
            }
        }
        return 0;
    }

    private static boolean move(StringBuffer[] maze, Queue<Point> q, char sep, int r, int c) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        if (q.isEmpty()) {
            return false;
        }
        int size = q.size();
        for (int s = 0; s < size; s++) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (safe(nx, ny, r, c) && maze[nx].charAt(ny) == '.') {
                    if (sep == 'J' && possibleExit(nx, ny, r - 1, c - 1)) {
                        return true;
                    }
                    maze[nx].setCharAt(ny, sep);
                    q.add(new Point(nx, ny));
                }
            }
        }
        return false;
    }

    private static boolean possibleExit(int x, int y, int r, int c) {
        return x == 0 || x == r || y == 0 || y == c;
    }

    private static boolean safe(int x, int y, int r, int c) {
            return x >= 0 && x < r && y >= 0 && y < c;
    }

    private static Point readMaze(StringBuffer[] maze, Queue<Point> user, Queue<Point> fire, int r, int c) {
        Point p = new Point(0, 0);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (maze[i].charAt(j) == 'J') {
                    user.add(new Point(i, j));
                    p = new Point(i, j);
                } else if (maze[i].charAt(j) == 'F') {
                    fire.add(new Point(i, j));
                }
            }
        }
        return p;
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