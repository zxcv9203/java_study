package java_jungsuk.chap11;

import java.util.*;

public class HashSetExample2 {
    public static void main(String[] args) {
        Set set = new HashSet();
        
        // set 이 6에 도달할때 까지 1 ~ 45 사이의 난수 저장
        while (set.size() < 6) {
            int n = (int) (Math.random() * 45) + 1;
            set.add(n);
        }

        List list = new LinkedList(set);
        Collections.sort(list);
        System.out.println(list);
    }
}
