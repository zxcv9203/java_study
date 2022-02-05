package algorithm.programmers.level1;


import java.util.Stack;

public class CrainDoll {
    static int[] fillBoard(int[][] board) {
        int[] dollPos = new int[board.length];
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != 0) {
                    dollPos[i] = j;
                    break;
                }
            }
        }
        return dollPos;
    }

    static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        int front = 0;

        int[] dollPos = fillBoard(board);
        for (int move : moves) {
            int pos = move - 1;
            int doll = board[dollPos[pos]][pos];
            if (doll == 0) {
                continue;
            }
            System.out.printf("%d %d\n",front,doll);
            if (front == doll) {
                s.pop();
                if (!s.empty()) {
                    front = s.peek();
                } else {
                    front = 0;
                }
                answer += 2;
            } else {
                front = doll;
                s.push(doll);
            }
            dollPos[pos]++;
            if (dollPos[pos] >= board.length) {
                dollPos[pos] = 0;
                board[dollPos[pos]][pos] = 0;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 2, 5, 0},
                {4, 2, 4, 4},
                {3, 5, 1, 3}
        };
        int[] moves = {1, 4, 3, 4, 1, 2, 1, 4};
        System.out.println(solution(board, moves));
    }
}
