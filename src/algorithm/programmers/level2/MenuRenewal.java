package algorithm.programmers.level2;

import java.util.*;

public class MenuRenewal {
    static boolean[] used;
    static void newMenu(HashMap<String, Integer> menuList, int course, String menu, String sett, int idx) {
        if (sett.length() > course) {
            return ;
        }
        if (sett.length() == course) {
            int cnt = 1;
            char[] settToChar = sett.toCharArray();
            Arrays.sort(settToChar);
            sett = new String(settToChar);
            if (menuList.get(sett) != null) {
                cnt += menuList.get(sett);
            }
            menuList.put(sett, cnt);
            return ;
        }
        for (int i = idx; i < menu.length(); i++) {
            int using = menu.charAt(i) - 'A';
            String tmp = String.valueOf(menu.charAt(i));
            if (used[using])
                continue;
            used[using] = true;
            newMenu(menuList, course, menu, sett + tmp, i);
            used[using] = false;
        }
    }
    static String[] solution(String[] orders, int[] course) {
        LinkedList<String> answer = new LinkedList<>();
        for (int c : course) {
            HashMap<String, Integer> menuList = new HashMap<>();
            int big = 0;
            for (String order : orders) {
                used = new boolean[26];
                newMenu(menuList, c, order, "", 0);
            }
            for (Integer cnt : menuList.values()) {
                big = Math.max(cnt, big);
            }
            if (big <= 1)
                continue;
            for (Map.Entry<String, Integer> entry : menuList.entrySet()) {

                if (big == entry.getValue()) {
                    answer.add(entry.getKey());
                }
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    public static void main(String[] args) {
        String[] orders = {
                "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
        };
        int[] course = {
                2,3,4
        };
        System.out.println(Arrays.toString(solution(orders, course)));
    }
}
