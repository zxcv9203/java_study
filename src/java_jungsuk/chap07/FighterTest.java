package java_jungsuk.chap07;

interface Fightable {
    void move(int x, int y); // public abstract 생략됨

    void attack(Fightable f);

}

class Fighter extends MyUnit implements Fightable {
    //    오버라이딩 규칙 : 조상보다 접근제어자가 범위가 좁으면 안됨 (조상 : public, 자식 : default)
    public void move(int x, int y) {
        System.out.println("x : " + x + ", y : " + y);
    }

    public void attack(Fightable f) {
        System.out.println(f + "를 공격");
    }

    // 싸울수 있는 상대를 불러옵니다.
    Fightable getFightable() {
        return new Fighter();
    }
}

public class FighterTest {
    public static void main(String[] args) {
//        Fighter f = new Fighter();
        MyUnit u = new Fighter();
        Fighter f = new Fighter();
        Fightable f2 = f.getFightable();

        u.move(100, 200);
        u.stop();
//        u.attack(f2); // MyUnit 에는 attack 메서드가 없어서 호출 불가
        System.out.println();
        f.move(100, 200);
//        f.stop(); // Fightable 에는 stop 메서드가 없어서 호출 불가
        f.attack(f2);
    }
}

abstract class MyUnit {
    int x, y;

    abstract void move(int x, int y);

    void stop() {
        System.out.println("stop!");
    }
}


