package java_jungsuk.chap09;

public class StringTest {
    public static void main(String[] args) {
        // 문자열 리터럴로 String을 선언하는 경우 해당 문자열이 constant pool에 저장되고 해당 주소를 가리키게 됨
        String s = "";
        String s2 = "";
        // new로 문자열을 생성할 경우 서로 다른 객체로 생성됨
        String cmp = new String("");
        String cmp2 = new String("");
        
        // 주소가 같기 때문에 true
        System.out.println(s2 == s);
        // 주소가 다르기 때문에 false
        System.out.println(cmp == s);
        
        /*
            new를 이용하여 선언할 경우 같은 내용임에도 계속 객체를 생성하기 때문에 메모리적으로 손해를 봄
         */
    }
}
