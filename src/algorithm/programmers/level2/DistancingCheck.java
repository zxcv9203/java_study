package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;

public class DistancingCheck {
    static boolean valid;
    static boolean[][] visit;
    static boolean safe(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }

    static void validCheck(String[] place, int x, int y, int cnt) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        visit[x][y] = true;
        if (!valid || place[x].charAt(y) == 'X' || cnt == 2) {
            return ;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!safe(nx, ny)) continue;
            if (visit[nx][ny]) continue;
            char c = place[nx].charAt(ny);
            if (c == 'P') {
                valid = false;
                return;
            }
            validCheck(place, nx, ny, cnt + 1);
        }
    }
    static int[] solution(String[][] places) {
        LinkedList<Integer> list = new LinkedList<>();
        for (String[] place : places) {
            for (int x = 0; x < place.length; x++) {
                valid = true;
                for (int y = 0; y < place.length; y++) {
                    char c = place[x].charAt(y);
                    if (c != 'P') continue;
                    visit = new boolean[5][5];
                    validCheck(place, x, y, 0);
                    if (!valid) {
                        break;
                    }
                }
                if(!valid) break;
            }
            if(valid) {
                list.add(1);
            } else {
                list.add(0);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
    public static void main(String[] args) {
        String[][] places = {
                { "PPOOO", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        System.out.println(Arrays.toString(solution(places)));
    }
}
