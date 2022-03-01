package java_jungsuk.chap08;

public class Ex07 {
    public static void main(String[] args) {
        try {                           // Exception 클래스와 그 자손은 예외처리를 해줘야 합니다. (필수) -> Checked Exception
            throw new Exception();      // Exception을 고의로 발생 시킵니다.
        } catch (Exception e) {

        }
        // RuntimeException 클래스와 그 자손은 예외처리를 해주지 않아도 컴파일이 가능합니다. (에러는 발생) -> Unchecked Exception
        throw new RuntimeException();
    }
}
