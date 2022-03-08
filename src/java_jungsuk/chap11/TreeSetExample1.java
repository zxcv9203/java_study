package java_jungsuk.chap11;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
    TreeSet에 객체를 넣으려면 객체가 비교를 할 수 있거나(Comparable)
    따로 기준을 만들어주거나 (Comparator) 해야함
    만약, 둘다 되어 있지 않은경우 비교가 불가능해 에러발생
 */
public class TreeSetExample1 {
    public static void main(String[] args) {
        Set set = new TreeSet();        // 범위 검색, 정렬 되어있음
//        Set set = new HashSet();      // 정렬 필요

//        while (set.size() < 6) {
//            int n = (int) (Math.random() * 45) + 1;
            set.add(new Test());
            set.add(new Test());
            set.add(new Test());
            set.add(new Test());
//        }
        System.out.println(set);
    }
}

class Test implements Comparable{

    @Override
    public int compareTo(Object o) {
        return -1;
    }
}

class TestComp implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return -1;
    }
}