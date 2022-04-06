package java_jungsuk.chap09;

import java.util.ArrayList;

public class AutoBoxingTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(new Integer(100));      // list에는 객체만 추가가능
        list.add(100);                        // JDK 1.5 이전에는 에러

        Integer i = list.get(0);
        int i2 = list.get(0).intValue();
        int i3 = list.get(0);


    }
}
