package algorithm.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GetAlert {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> idx = new HashMap<String, Integer>();
        HashMap<String, List<Integer>> warning = new HashMap<String, List<Integer>>();

        for (int i = 0; i < id_list.length; i++) {
            idx.put(id_list[i], i);
        }
        for (String value : report) {
            // tmp[0] = From, tmp[1] = To
            String[] tmp = value.split(" ");
            if (!warning.containsKey(tmp[1])) {
                warning.put(tmp[1], new ArrayList<>());
            }
            List<Integer> list = warning.get(tmp[1]);
            if (!list.contains(idx.get(tmp[0]))) {
                list.add(idx.get(tmp[0]));
            }
        }
        for (String id : id_list) {
            if (warning.containsKey(id) && warning.get(id).size() >= k) {
                for (int reporter : warning.get(id)) {
                    answer[reporter]++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] id_list = {
                "muzi",
                "frodo",
                "apeach",
                "neo"
        };
        String[] report = {
                "muzi frodo",
                "apeach frodo",
                "frodo neo",
                "muzi neo",
                "apeach muzi"
        };
        int k = 2;
        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }
}