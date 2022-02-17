package algorithm.programmers.level2;


import java.util.HashMap;

public class PhoneNumberList {
    static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Boolean> dup = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            dup.put(phone_book[i], true);
        }
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (dup.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] phone_book = {
               "1234", "1235", "12345"
        };
        System.out.println(solution(phone_book));
    }
}
