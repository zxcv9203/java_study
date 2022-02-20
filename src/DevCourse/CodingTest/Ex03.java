package DevCourse.CodingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    1부터 n까지 붙어있는 n개의 역이 철로로 연결됨

    철로는 양방향 통행이 가능, 임의의 두역을 직접 연결하는 철로는 최대 한가지

    서로다른 역 사이 이동경로는 한가지이며, 두 역 사이에 이동이 불가능한 경우는 없음

    출발역과 종착역 사이를 왕복하는 열차를 운행하려고 함

    출발역은 1번역이며, 전체 역 중 한 곳을 종착역으로 정해야함

    단 열차가 출발역에서 종착역까지 갈 때 모든 역을 방문할 필요 X

    같은 역을 두번이상 방문 X

    종착역을 정하기 위해 각 역의 일일 이용객 수를 조사

    이때 열차가 방문하는 역의 일일 이용객 수의 합이 최대가 되도록 종착역 지정

    만약 일일 이용객 수의 합이 최대가 되는 역이 여러개라면 번호가 큰 역 선택

    전체 역의 개수 n, 1번부터 n번 역까지 일일 이용객 수 passenger
    역 사이의 철로 연결 정보 train이 매개변수로 주어짐

    종착역으로 지정할 역 번호와 그때의 이용객 수의 합을 배열에 담아 return

 */
public class Ex03 {
    static int user;
    static int last;
    static boolean[] visit;

    static boolean movePossible(int st, int[][] move) {
        for (int m : move[st]) {
            if (m == 0) break;
            if (visit[m])
                return true;
        }
        return false;
    }
    static void dfs(int st, int[][] move, int[] passenger, int cnt) {
        System.out.println(st);
        cnt += passenger[st-1];
        if (!movePossible(st, move)) {
            if (user < cnt || (user == cnt && last < st)) {
                last = st;
                user = cnt;
            }
            return ;
        }
        for (int m : move[st]) {
            if (m == 0) break;
            if (visit[m]) continue;
            visit[st] = true;
            dfs(m, move, passenger, cnt);
            visit[st] = false;
        }
    }
    static int[] solution(int n, int[] passenger, int[][] train) {
        user = 0;
        last = 0;
        int[] answer = new int[2];
        int[][] move = new int[n+1][n+1];
        int idx = 0;
        for (int[] t : train) {
            move[t[0]][idx] = t[1];
            move[t[1]][idx] = t[0];
            idx++;
        }

        for (int m : move[1]) {
            if (m == 0) break ;
            visit = new boolean[n+1];
            visit[0] = true;
            visit[1] = true;
            dfs(m, move, passenger, passenger[0]);
        }
        answer[0] = last;
        answer[1] = user;
        return answer;
    }
    public static void main(String[] args) {
        int n = 7;
        int[] passenger = {
               2, 1, 3, 3, 1, 2, 2
        };
        int[][] train = {
                {1, 2},
                {1, 4},
                {4, 3},
                {3, 6},
                {4, 5},
                {5, 7}
        };
        System.out.println(Arrays.toString(solution(n, passenger, train)));
    }
}
