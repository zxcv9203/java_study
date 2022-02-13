package algorithm.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

class User implements Comparable<User> {
    int number;
    double percent;

    @Override
    public int compareTo(User u) {
        if (this.percent < u.percent)
            return 1;
        else if (this.percent == u.percent) {
            return 0;
        } else {
            return -1;
        }
    }
}
public class FailureRate {

    static int[] solution(int N, int[] stages) {
        int users = stages.length;
        HashMap<Integer, Integer> fail = new HashMap<>();
        int[] answer = new int[N];
        User[] user = new User[N];
        for (int i = 0; i < user.length; i++) {
            user[i] = new User();
        }
        for(int clear : stages) {
            int cnt = 1;
            if (fail.containsKey(clear-1)) {
                cnt += fail.get(clear-1);
            }
            fail.put(clear-1, cnt);
        }
        for (int i = 0; i < N; i++) {
            if (fail.containsKey(i)) {
                int failUser = fail.get(i);
                user[i].number = i+1;
                user[i].percent = (double)failUser / users;
                users -= failUser;
            } else {
                user[i].number = i+1;
                user[i].percent = 0;
            }
        }
        Arrays.sort(user);
        for (int i = 0; i < N; i++) {
            answer[i] = user[i].number;
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 4;
        int[] stages = {
                4,4,4,4,4
        };
        System.out.println(Arrays.toString(solution(n, stages)));
    }
}
