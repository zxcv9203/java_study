package java_jungsuk.chap12;

import java.util.ArrayList;

public class GenericTest2 {
    public static void main(String[] args) {
        ArrayList<Tv> list = new ArrayList<>();    // Tv 타입의 객체만 저장가능
        list.add(new Tv());
//        list.add(new Audio());

        Tv t = list.get(0);     // list 의 첫번째 요소를 꺼냄
    }
}

class Tv{

}

class Audio{

}