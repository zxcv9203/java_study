package java_jungsuk.chap12;

import java.util.ArrayList;

public class GenericTest {
    public static void main(String[] args) {
        // Generics 로 타입 체크가 강화됨
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

//        Integer i = (Integer) list.get(2);
        Integer i = list.get(2);

        System.out.println(list);
    }
}
