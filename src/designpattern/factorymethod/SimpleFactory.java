package designpattern.factorymethod;

public class SimpleFactory {

    // 다음과 같은 방식으로 구현된 팩토리를 심플 팩토리 패턴이라고 합니다.
    public Object createProduct(String name) {
        if (name.equals("whiteship")) {
            return new WhiteShip();
        } else if (name.equals("blackship")) {
            return new BlackShip();
        }
        throw new IllegalArgumentException();
    }
}
