package java_jungsuk.chap12;

import java.util.ArrayList;

public class GenericTest7 {
    public static void main(String[] args) {
        FruitBox2<Fruit2> fruitBox2 = new FruitBox2<>();
        FruitBox2<Apple2> appleBox2 = new FruitBox2<Apple2>();

        fruitBox2.add(new Apple2());
        fruitBox2.add(new Grape2());
        appleBox2.add(new Apple2());
        appleBox2.add(new Apple2());

        System.out.println(JuiceMaker.makeJuice(fruitBox2));
        System.out.println(JuiceMaker.makeJuice(appleBox2));
    }
}

class Fruit2 {
    @Override
    public String toString() {
        return "Fruit";
    }
}

class Apple2 extends Fruit2 {

    @Override
    public String toString() {
        return "Apple";
    }
}

class Grape2 extends Fruit2 {
    public String toString() {
        return "Grape";
    }
}

class Juice {
    String name;

    Juice(String name) {
        this.name = name + "Juice";
    }

    @Override
    public String toString() {
        return name;
    }
}

class Box2<T> {
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

    ArrayList<T> getList() {
        return list;
    }

    public String toString() {
        return list.toString();
    }
}

class FruitBox2<T extends Fruit2> extends Box2<T> {}

class JuiceMaker {
    static Juice makeJuice(FruitBox2<? extends Fruit2> box) {
        StringBuilder tmp = new StringBuilder();

        for(Fruit2 f : box.getList()) {
            tmp.append(f).append(" ");
        }
        return new Juice(tmp.toString());
    }
}