package java_jungsuk.chap11;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample1 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("myId", "1234");
        map.put("asdf", "1111");
        map.put("asdf", "1234");

        Scanner s = new Scanner(System.in); // 화면으로부터 라인단위로 입력받는 입력기

        while (true) {
            System.out.println("로그인");
            System.out.print("id : ");
            String id = s.nextLine().trim();

            System.out.print("password : ");
            String password = s.nextLine().trim();
            System.out.println();

            if (!map.containsKey(id)) {
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
                continue;
            }
            if (!(map.get(id)).equals(password)) {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
                continue;
            }
            System.out.println("로그인 성공");
            break;
        }

    }
}
