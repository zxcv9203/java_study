package java_jungsuk.chap07;

public class PlayerTest {
    public static void main(String[] args) {
//        Player p = new Player();            // 추상 클래스의 객체를 생성

        Player ap = new AudioPlayer();     // 다형성
        ap.play(100);
        ap.stop();
    }
}

/*
    추상 클래스는 상속을 통해 완성해야 객체를 생성할 수 있습니다.
 */
abstract class Player {                     // 추상 클래스 (미완성 클래스, 미완성 설계도)
    abstract void play(int pos);            // 추상 메서드 (미완성 메서드)

    abstract void stop();                   // 추상 메서드 (선언부만 있고 구현부가 없는 메서드를 의미)
}

class AudioPlayer extends Player {
    void play(int pos) {
        System.out.println(pos + " 위치부터 play 합니다.");
    }

    void stop() {
        System.out.println("재생 종료");
    }
}