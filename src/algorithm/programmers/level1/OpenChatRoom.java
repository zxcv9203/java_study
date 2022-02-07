package algorithm.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OpenChatRoom {
    static String[] solution(String[] record) {
        final int behavior = 0;
        final int uid = 1;
        final int name = 2;

        List<String> answer = new ArrayList<>();
        HashMap<String, String> user = new HashMap<>();

        for (String s : record) {
            String[] info = s.split(" ");
            if (!info[behavior].equals("Leave")) {
                user.put(info[uid], info[name]);
            }
        }
        for (String s : record) {
            String[] info = s.split(" ");
            switch (info[behavior]) {
                case "Enter" :
                    answer.add(user.get(info[uid])+"님이 들어왔습니다.");
                    break;
                case "Leave":
                    answer.add(user.get(info[uid])+"님이 나갔습니다.");
                    break;
                default:
                    break;
            }
        }
        String[] ret = new String[answer.size()];
        return answer.toArray(ret);
    }
    public static void main(String[] args) {
        String[] record = {
                "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"
        };
        System.out.println(Arrays.deepToString(solution(record)));
    }
}
