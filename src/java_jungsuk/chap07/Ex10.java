package java_jungsuk.chap07;

public class Ex10 {
    public static void main(String[] args) {
        Unit[] group = {
                new Marine(),
                new Tank(),
                new DropShip()
        };

        for (Unit unit : group) {
            unit.move(100, 200);
        }
    }
}

abstract class Unit {
    int x, y;

    abstract void move(int x, int y);

    void stop() {
        System.out.println("유닛이 정지했습니다.");
    }
}

class Marine extends Unit {
    void move(int x, int y) {
        System.out.println("Marine[x = " + x + ", y = " + y + "]");
    }

    void stimPack() {
        System.out.println("스팀팩을 사용했습니다.");
    }
}

class Tank extends Unit {
    void move(int x, int y) {
        System.out.println("Tank[x = " + x + ", y = " + y + "]");
    }

    void changeMode() {
        System.out.println("공격 모드를 변환합니다.");
    }
}

class DropShip extends Unit {
    void move(int x, int y) {
        System.out.println("DropShip[x = " + x + ", y = " + y + "]");
    }

    void changeMode() {
        System.out.println("공격 모드를 변환합니다.");
    }
}