package java_jungsuk.chap12;

import java.util.ArrayList;

public class GenericTest6 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();
//        FruitBox<Grape> grapeBox2 = new FruitBox<Apple>(); // error, 타입 불일치
//        FruitBox<Toy> toyBox = new FruitBox<Toy>(); // error, 제네릭 타입 불일치
        Box<Toy> toyBox = new Box<Toy>();       // OK

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        appleBox.add(new Apple());
//        appleBox.add(new Grape());    // error, Grape는 Apple의 자손이 아님
        grapeBox.add(new Grape());
        toyBox.add(new Toy());

        System.out.println(fruitBox);
        System.out.println(appleBox);
        System.out.println(grapeBox);
        System.out.println(toyBox);
    }
}

interface Eatable {

}

class Fruit implements Eatable {

    @Override
    public String toString() {
        return "Fruit";
    }
}

class Apple extends Fruit {

    @Override
    public String toString() {
        return "Apple";
    }
}

class Grape extends Fruit {
    public String toString() {
        return "Grape";
    }
}

class Toy {
    public String toString() {
        return "Toy";
    }
}

class Box<T> {
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
class FruitBox<T extends Fruit & Eatable> extends Box<T> {}
