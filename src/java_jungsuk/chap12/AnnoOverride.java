package java_jungsuk.chap12;

public class AnnoOverride {

}

class Parent {
    void parentMethod() {}
}

class Child extends Parent {
//    @Override // 해당 애너테이션을 붙이면 컴파일러가 오버라이딩했는지 체크해줌
    void parentmethod() {}  // 조상 메서드의 이름을 잘못적음 (조상 : parentMethod)
}