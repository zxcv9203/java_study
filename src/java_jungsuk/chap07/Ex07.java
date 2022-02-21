package java_jungsuk.chap07;

public class Ex07 {
    public static void castExceptionTest() {
        Car car = new Car();
        FireEngine fe = null;
        fe = (FireEngine) car;
        //  Car 에서 FireEngine 으로 형변환 하였지만 Car 클래스에는
        //  Water 메서드가 존재하지 않기때문에 에러발생
//        fe.water();

    }
    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        fe.water();
        car = fe;
//        car.water();  -> Car Class 멤버가 아닌 자손의 멤버이기 때문에 사용불가능
        fe2 = (FireEngine)car;
        fe2.water();
        castExceptionTest();
    }
}

class Car {
    String color;
    int door;

    void drive() {  // 운전하는 기능
        System.out.println("Drive, Brrrrr~");
    }
    void stop() {   // 멈추는 기능
        System.out.println("stop!!!");
    }
}

class FireEngine extends Car {
    void water() {
        System.out.println("Water");
    }
}