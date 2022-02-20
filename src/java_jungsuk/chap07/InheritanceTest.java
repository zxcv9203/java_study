package java_jungsuk.chap07;

public class InheritanceTest {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.p.x = 1;
        c.p.y = 2;
        c.r = 3;
        System.out.println("c.x = " + c.p.x);
        System.out.println("c.y = " + c.p.y);
        System.out.println("c.r = " + c.r);
    }
}

class Point {
    int x;
    int y;
}

class Circle { // 포함
    Point p;
    int r;
    Circle() {
        this.p = new Point();
    }
}

//class Circle extends Point { 상속
//    int r;
//}
