package java_jungsuk.chap11;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import static java.util.Collections.*;      // static 키워드를 붙여
                                            // Collections 를 생략가능하게 해줍니다.

public class CollectionsExample {
    public static void main(String[] args) {
        List list = new ArrayList();
        System.out.println(list);

        addAll(list, 1,2,3,4,5);    // 가변인자들을 추가
        System.out.println(list);

        rotate(list, 2);                // 오른쪽 방향으로 회전(마지막은 처음으로 감)
        System.out.println(list);

        swap(list, 0, 2);                  // 두 인덱스 위치에 있는 값을 바꿈
        System.out.println(list);

        shuffle(list);                              // 저장된 값을 임의 위치로 이동
        System.out.println(list);

        sort(list, reverseOrder());                 // 역순정렬
        System.out.println(list);

        sort(list);                                 // 정렬
        System.out.println(list);

        int idx = binarySearch(list, 3);        // 이분탐색
        System.out.println("index of 3 = " + idx);

        System.out.println("max = " + max(list));
        System.out.println("min = " + min(list));
        // 비교를 반대로해서 최대값이 아닌 최소 값이 max가 됨
        System.out.println("min = " + max(list, reverseOrder())); 

        // 해당 컬렉션을 특정 값으로 채움
        fill(list, 9);
        System.out.println(list);

        // 매개변수로 주어진 컬렉션과 같은 크기의 새로운 컬렉션을 특정 값으로 채움
        List newList = nCopies(list.size(), 2);
        System.out.println(newList);

        // 두 컬렉션간 공통요소가 없으면 true, 있으면 false
        System.out.println(disjoint(list, newList));

        // newList를 list로 복사하는 메서드
        copy(list, newList);
        System.out.println(newList);
        System.out.println(list);

        // 현재 값을 특정 값으로 전부 바꿀때 사용하는 메서드
        replaceAll(list, 2, 1);
        System.out.println(list);

        Enumeration e = enumeration(list);
        ArrayList list2 = list(e);
        System.out.println(list2);
    }
}
