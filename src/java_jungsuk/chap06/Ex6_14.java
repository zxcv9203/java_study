package java_jungsuk.chap06;

public class Ex6_14 {
    public static void main(String[] args) {

    }
}

class Car2 {
    String color;
    String gearType;
    int door;
    static int cv = 1;
    int iv = 1;
    static {cv = 2;}
    {iv = 2;}
    Car2() {
        this("white", "auto", 4);
    }
    Car2(String color) {
        this(color, "auto", 4);
    }
    Car2(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}