package java_jungsuk.chap12;

import java.util.ArrayList;

public class GenericTest8 {
    public static void main(String[] args) {
        FruitBox3<? extends Fruit3> fBox =
                (FruitBox3<? extends Fruit3>)new FruitBox3<Fruit3>();

        //FruitBox<Apple> -> FruitBox<? extends Fruit>
        FruitBox<? extends Fruit> aBox = new FruitBox<>();
        // FruitBox<? extends Fruit> -> FruitBox<Apple> (다운캐스팅 위험 -> 경고)
        FruitBox<Apple> appleBox = (FruitBox<Apple>) aBox;

    }
}
interface Eatable3 {

}

class Fruit3 implements Eatable3 {

    @Override
    public String toString() {
        return "Fruit";
    }
}

class Apple3 extends Fruit3 {

    @Override
    public String toString() {
        return "Apple";
    }
}

class Grape3 extends Fruit3 {
    public String toString() {
        return "Grape";
    }
}

class Toy3 {
    public String toString() {
        return "Toy";
    }
}

class Box3<T> {
    ArrayList<T> list = new ArrayList<>();  // item 을 저장할 list

    void add(T item) {          // 박스에 item 추가
        list.add(item);
    }

    T get(int i) {              // 박스에 item 꺼낼때
        return list.get(i);
    }

    int size() {
        return list.size();
    }

    public String toString() {
        return list.toString();
    }
}

class FruitBox3<T extends Fruit3 & Eatable3> extends Box3<T> {}
