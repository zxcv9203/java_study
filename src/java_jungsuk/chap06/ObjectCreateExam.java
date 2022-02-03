package java_jungsuk.chap06;

public class ObjectCreateExam {
    public static void main(String[] args) {
        // Tv 클래스로 생성한 인스턴스를 참조하기 위한 변수 t 선언
        Tv t;
        // Tv 클래스의 인스턴스를 생성
        t = new Tv();
        // Tv 인스턴스의 멤버변수 channel 값을 7로합니다.
        t.channel = 7;
        // Tv 인스턴스의 channel 값을 내립니다. (6이됨)
        t.channelDown();
        System.out.println(t.channel);
    }
}

class Tv {
    // Tv 클래스의 속성(멤버 변수)
    String color;   // 색상
    boolean power;  // 전원상태 (on / off)
    int channel;    //채널

    // Tv 클래스의 기능(메서드)
    void power() { power = !power; }    // Tv를 켜거나 끄는 기능을 하는 메서드
    void channelUp() { ++channel; }     // Tv의 채널을 올리는 기능을 하는 메서드
    void channelDown() { --channel; }   // Tv의 채널을 내리는 기능을 하는 메서드
}
