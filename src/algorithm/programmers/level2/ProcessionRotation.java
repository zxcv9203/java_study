package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;

public class ProcessionRotation {

    static int[][] createProcession(int rows, int columns) {
        int [][] procession = new int[rows][columns];
        int n = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                procession[i][j] = n++;
            }
        }
        return procession;
    }

    static int rotate(int[] query, int[][] p) {
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;
        int save = p[x1][y1];
        int low = save;

        for (int i = y1; i < y2; i++) {
            int tmp = p[x1][i+1];
            low = Math.min(low, tmp);
            p[x1][i+1] = save;
            save = tmp;
        }
        for (int i = x1; i < x2; i++) {
            int tmp = p[i+1][y2];
            low = Math.min(low, tmp);
            p[i+1][y2] = save;
            save = tmp;
        }
        for (int i = y2; i > y1 ; i--) {
            int tmp = p[x2][i-1];
            low = Math.min(low, tmp);
            p[x2][i-1] = save;
            save = tmp;
        }
        for (int i = x2; i > x1; i--) {
            int tmp = p[i-1][y1];
            low = Math.min(low, tmp);
            p[i-1][y1] = save;
            save = tmp;
        }
        return low;
    }
    static int[] solution(int rows, int columns, int[][] queries) {
        int[][] procession = createProcession(rows, columns);
        LinkedList<Integer> answer = new LinkedList<>();

        for (int[] query: queries) {
            int low = rotate(query, procession);
            answer.add(low);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {
                {2, 2, 5, 4},
                {3, 3, 6, 6},
                {5, 1, 6, 3}
        };
        System.out.println(Arrays.toString(solution(rows, columns, queries)));
    }
}
