package java_jungsuk.chap07;

public class Ex09 {
    public static void main(String[] args) {
        Buyer2 b = new Buyer2();

        b.buy(new Tv2());
        b.buy(new Computer2());
        b.buy(new Audio2());
        b.summary();
    }
}

class Product2 {
    int price;
    int point;

    Product2(int price) {
        this.price = price;
        point = (int)(price  / 10.0);
    }
    Product2() {}
}

class Tv2 extends Product2 {
    Tv2() { super(100); }

    public String toString() { return "Tv"; }
}

class Computer2 extends Product2 {
    Computer2() { super(200); }

    public String toString() { return "Computer"; }
}

class Audio2 extends Product2 {
    Audio2() { super(50); }

    public String toString() { return "Audio"; }
}

class Buyer2 {
    int money = 1000;
    int point = 0;
    Product2[] cart = new Product2[10]; // 구매한 제품을 사기 위한 배열
    int idx = 0;                          // 배열에 사용할 인덱스 변수

    void buy(Product2 p) {
        if (money < p.price) {
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }

        money -= p.price;
        point += p.point;
        cart[idx++] = p;
        System.out.println(p + "을/를 구입하셨습니다.");
    }

    void summary() {            // 구매한 물품에 대한 정보를 요약해서 보여주는 함수
        int sum = 0;            // 구입한 물품의 가격합계
        StringBuilder itemList = new StringBuilder();   // 구입한 물품목록

        /*
            반복문을 이용해서 구입한 물품의 총 가격과 목록을 만듭니다.
         */
        for (Product2 product : cart) {
            if (product == null) break;
            sum += product.price;
            itemList.append(product).append(", ");
        }
        System.out.println("현재 구입한 물품의 가격 : " + sum);
        System.out.println("현재 구입한 제품 목록 : " + itemList);
    }
}
