package java_jungsuk.chap11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
//        HashSet<String> list = new HashSet<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        // Iterator 사용
        System.out.println("Iterator Traversal");
        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            Object obj = it.next();
            System.out.print(obj + " ");
        }
        System.out.println("\n");

        // For 사용
        /*
            For loop 사용해서 값을 가져올 때 컬렉션마다 방법이 달라 수정이 필요해질 수 있음
            ex ) HashSet
         */
        System.out.println("For loop");
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            System.out.print(obj + " ");
        }
        System.out.println("\n");

        // For each 사용
        System.out.println("For each loop");
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println("\n");
    }
}
