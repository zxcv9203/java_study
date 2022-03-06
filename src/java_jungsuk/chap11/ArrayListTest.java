package java_jungsuk.chap11;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {
    public static void main(String[] args) {
        /*
            기본 길이(capacity)가 10인 ArrayList를 생성
         */
        ArrayList list1 = new ArrayList(10);
        // ArrayList에는 객체만 저장가능 하지만 autoBoxing에 의해 기본형이 참조형으로 변경됨
        list1.add(5);
        list1.add(4);
        list1.add(2);
        list1.add(0);
        list1.add(1);
        list1.add(new Integer(3));

        // list1의 1 ~ 3번째 인덱스 복사 (마지막 인덱스 이전 까지만 복사됨)
        // ArrayList(Collection c) 생성자 사용
        ArrayList list2 = new ArrayList(list1.subList(1, 4));
        print(list1, list2);
        
        // Collection은 인터페이스, Collections는 유틸 클래스
        Collections.sort(list1);
        Collections.sort(list2);
        print(list1, list2);

        // list1의 값이 list2의 값을 포함하는지 확인
        System.out.println("list.containsAll(list2) : " + list1.containsAll(list2));

//        인덱스를 적어주지 않는 경우 맨 뒤에 추가
//        인덱스를 적어줄 경우 해당 인덱스에 넣고 만약 데이터가 들어있었다면 한칸씩 뒤로 밀어냄
        list2.add("B");
        list2.add("C");
        list2.add(3, "A");
        print(list1, list2);

        list2.set(3, "AA");
        print(list1, list2);

        System.out.println("list1의 1의 위치 : " + list1.indexOf(1));
        
        list1.remove(1);                // 인덱스가 1인 값 삭제
        list1.remove(Integer.valueOf(1));       // 값이 1인 값 삭제
        print(list1, list2);

        // list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제합니다.
        System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));
        print(list1, list2);

        // list2에서 list1에 포함된 객체들을 삭제합니다.
        for (int i = list2.size()-1; i >= 0; i--) {
            if (list1.contains(list2.get(i))) {
                list2.remove(i);
            }
        }
        print(list1, list2);
    }

    static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);
        System.out.println();
    }
}
