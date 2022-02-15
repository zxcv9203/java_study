package algorithm.programmers.level2;

import java.sql.Array;
import java.util.*;

public class Tuple {
    final static int M = 100001;
    static ArrayList<Integer> findTuple(List<List<Integer>> arr) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        boolean[] used = new boolean[M];

        for (List<Integer> elem : arr) {
            for (Integer e : elem) {
                if (!used[e]) {
                    answer.add(e);
                    used[e] = true;
                }
            }
        }
        return answer;
    }
    static List<List<Integer>> parseTuple(String s) {
        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder n = new StringBuilder();
            List<Integer> elem = new ArrayList<>();
            while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                n.append(s.charAt(i++));
                if (s.charAt(i) == ',' || s.charAt(i) == '}') {
                    elem.add(Integer.parseInt(n.toString()));
                    n = new StringBuilder();
                    i++;
                }
            }
            if (!elem.isEmpty()) {
                arr.add(elem);
            }
        }
        return arr;
    }
    static int[] solution(String s) {
        LinkedHashSet<Integer> tuple = new LinkedHashSet<>();
        List<List<Integer>> arr = parseTuple(s);
        arr.sort(Comparator.comparingInt(List::size));
        ArrayList<Integer> answer = findTuple(arr);
        return answer.stream().mapToInt(i->i).toArray();
    }
    public static void main(String[] args) {
        String s = "{{20,111},{111}}";
        System.out.println(Arrays.toString(solution(s)));
    }
}
