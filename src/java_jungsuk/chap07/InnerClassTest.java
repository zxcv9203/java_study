package java_jungsuk.chap07;

public class InnerClassTest {
    public static void main(String[] args) {
        AA a = new AA();
        a.b.method();
    }
}

class AA {      // AA는 BB의 외부클래스
    int i = 100;
    BB b = new BB();

    class BB {  // BB는 AA의 내부 클래스
        void method() {
            System.out.println(i);  // 객체 생성 없이 외부 클래스 멤버 접근가능
        }
    }
}


//class CC {
//    BB b = new BB();
//}