package algorithm.programmers.level2;


import java.util.ArrayList;
import java.util.Arrays;

class LightDistanceCycle {
    static boolean[][][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int xSize;
    static int ySize;

    static int directionDesignate(char grid, int dir) {
        switch (grid) {
            case 'L':
                dir = (dir + 3) % 4;
                break;
            case 'R':
                dir = (dir + 1) % 4;
                break;
            default :
                break;
        }
        return dir;
    }
    static int cycleCheck(String[] grid, int x, int y, int dir) {
        int cnt = 0;

        while (!visit[x][y][dir]) {
            cnt++;
            visit[x][y][dir] = true;
            dir = directionDesignate(grid[x].charAt(y), dir);
            x = (x + dx[dir] + xSize) % xSize;
            y = (y + dy[dir] + ySize) % ySize;
        }
        return cnt;
    }
    static int[] solution(String[] grid) {
        ArrayList<Integer> answer = new ArrayList<>();
        xSize = grid.length;
        ySize = grid[0].length();

        visit = new boolean[xSize][ySize][4];
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                for (int k = 0; k < 4; k++) {
                    if (visit[i][j][k]) continue;
                    answer.add(cycleCheck(grid, i, j, k));
                }
            }
        }
        return answer.stream().sorted().mapToInt(i->i).toArray();
    }
    public static void main(String[] args) {
        String[] grid = {
                "SL", "LR"
        };
        System.out.println(Arrays.toString(solution(grid)));
    }
}