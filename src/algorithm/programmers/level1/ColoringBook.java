package algorithm.programmers.level1;


import java.util.HashMap;

public class ColoringBook {
    static int M;
    static boolean[][] visit;

    static boolean safe(int x, int y, int n, int m) {
        return x >=0 && x < m && y >= 0 && y < n;
    }
    static int dfs(int cnt, int x, int y, int n, int m, int[][] pictures) {
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!safe(nx, ny, n, m) || visit[nx][ny] || pictures[nx][ny] != pictures[x][y])
                continue;
            cnt += dfs(1, nx, ny, n, m, pictures);
        }
        return cnt;
    }
    static int[] solution(int m, int n, int[][] picture) {
        M = 101;

        visit = new boolean[M][M];
        int kinds = 0;
        int max = 0;
        int[] answer = new int[2];
        int[][] copy = picture.clone();
        HashMap<Integer, Boolean> area = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j])
                    continue;
                int areaNumber = picture[i][j];
                if (area.get(areaNumber) == null) {
                    area.put(areaNumber, true);
                    kinds++;
                }
                if (areaNumber == 0)
                    continue;
                int tmp = dfs(1, i, j, n, m, copy);
                max = Math.max(tmp, max);
            }
        }
        answer[0] = kinds;
        answer[1] = max;
        return answer;
    }
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {
            {0, 1, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        int[] answer = solution(m, n, picture);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
