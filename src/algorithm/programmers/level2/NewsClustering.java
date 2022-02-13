package algorithm.programmers.level2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsClustering {
    static HashMap<String, Integer> mapCreate(String[] split) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : split) {
            int cnt = 1;
            if (map.containsKey(s)) {
                cnt += map.get(s);
            }
            map.put(s, cnt);
        }
        return map;
    }
    static String[] stringTwoWordSplit(String s) {
        LinkedList<String> ret = new LinkedList<>();
        Pattern alphaCheck = Pattern.compile("^[a-zA-Z]*$");
        for (int i = 0; i < s.length() - 1; i++) {
            String tmp = s.substring(i, i+2);
            Matcher isAlpha = alphaCheck.matcher(tmp);
            if (!isAlpha.find()) {
                continue;
            }
            tmp = tmp.toUpperCase();
            ret.add(tmp);
        }
        return ret.toArray(new String[0]);
    }

    static int solution(String str1, String str2) {
        int size = 0;
        int interCnt = 0;
        double answer;
        String[] str1Split = stringTwoWordSplit(str1);
        String[] str2Split = stringTwoWordSplit(str2);
        HashMap<String, Integer> map1 = mapCreate(str1Split);
        HashMap<String, Integer> map2 = mapCreate(str2Split);


        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            int cnt = entry.getValue();

            if (!map2.containsKey(key)) {
                size += cnt;
                continue;
            }
            int s2Cnt = map2.get(key);
            if (cnt == s2Cnt) {
                interCnt += cnt;
            } else {
                interCnt += Math.min(cnt, s2Cnt);
            }
            size += Math.max(cnt, s2Cnt);
        }
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            if (map1.containsKey(key))
                continue;
            size += entry.getValue();
        }
        answer = (double)interCnt / size * 65536;
        if (Double.isNaN(answer)) {
            answer = 65536;
        }
        return (int)answer;
    }
    public static void main(String[] args) {
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";
        System.out.println(solution(str1, str2));
    }
}
