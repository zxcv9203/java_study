package algorithm.programmers.level1;

import java.util.*;

public class Marathon {
    static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> pa = new HashMap<String, Integer>();
        HashMap<String, Integer> co = new HashMap<String, Integer>();

        for (String p : participant) {
            int cnt = 1;
            if (pa.get(p) != null)
                cnt += pa.get(p);
            pa.put(p, cnt);
        }
        for (String c : completion) {
            int cnt = 1;
            if (co.get(c) != null)
                cnt += co.get(c);
            co.put(c, cnt);
        }
        for (String p : participant) {
            int cCnt = 0;
            int pCnt = 0;
            if (co.get(p) != null)
                cCnt = co.get(p);
            if (pa.get(p) != null)
                pCnt = pa.get(p);
            if (cCnt != pCnt) {
                return p;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] participant = {
                "a", "ccc", "ccc", "asddf"
        };
        String[] completion = {
                "a", "ccc", "asddf"
        };
        System.out.println(solution(participant, completion));
    }
}
