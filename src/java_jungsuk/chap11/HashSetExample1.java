package java_jungsuk.chap11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample1 {
    public static void main(String[] args) {
        Object[] objArr = {
                "1", 1, "2", "2", "3", "3", "4", "4", "4", "4"
        };
        Set set = new HashSet();

        for (Object obj : objArr) {
            set.add(obj);   // objArr -> HashSet 저장
        }

        // HashSet 출력
        System.out.println(set);

        // HashSet 순회하며 출력(Iterator 사용)
        Iterator iter = set.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
