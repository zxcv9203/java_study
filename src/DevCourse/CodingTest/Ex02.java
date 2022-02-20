package DevCourse.CodingTest;

import java.util.*;

public class Ex02 {
    static final int user = 0;
    static final int command = 1;

    static void modifyAlert(Status prev, String user) {
        if (prev.others.equals("")) {
            prev.others = " and " + user;
        } else {
            prev.others = " and " + prev.users + " others";
        }
        prev.users++;
    }
    static String parseStat(Status stat) {
        String msg = stat.name + stat.others + " ";

        switch(stat.cmd) {
            case "share":
                msg += stat.cmd + "d" + " your post";
                break;
            case "comment":
                msg += stat.cmd + "ed" + " on your post";
                break;
            default:
                break;
        }

        return msg;
    }
    static String[] solution(String[] records) {
        Stack<Status> stat = new Stack<>();
        ArrayList<String> box = new ArrayList<>();

        for (String r : records) {
            String[] record = r.split(" ");
            switch (record[command]) {
                case "share":
                case "comment":
                    if (!stat.isEmpty()) {
                        Status prev = stat.pop();
                        if (prev.cmd.equals(record[command])) {
                            modifyAlert(prev, record[user]);
                            stat.push(prev);
                            break;
                        }
                        stat.push(prev);
                    }
                    stat.push(new Status(record[user], record[command]));
                    break;
                case "notification":
                    if (!stat.isEmpty()) {
                        String msg = parseStat(stat.pop());
                        box.add(msg);
                    }
                    break;
                default:
                    break;
            }
        }
        String[] answer = new String[box.size()];
        for (int i = 0; i < box.size(); i++) {
            answer[i] = box.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] records = {
                "john share", "mary comment", "jay share", "check notification", "check notification", "sally comment", "james share", "check notification", "lee share", "laura share", "will share", "check notification", "alice comment", "check notification"
        };
        System.out.println(Arrays.toString(solution(records)));
    }
}

class Status {
    int users;
    String name;
    String others;
    String cmd;
    Status(String name, String cmd) {
        this.users = 1;
        this.name = name;
        this.others = "";
        this.cmd = cmd;
    }
}
