package java_jungsuk.chap07;

class MyParent {
    private int     prv;        // 같은 클래스
    int             dft;        // 같은 패키지
    protected int   prt;        // 같은 패키지 + 자손 클래스(다른 패키지)
    public int      pub;        // 접근제한 없음

    public void printMembers() {
        System.out.println(prv);
        System.out.println(dft);
        System.out.println(prt);
        System.out.println(pub);
    }
}

public class MyParentTest {
    public static void main(String[] args) {
        MyParent p = new MyParent();
        System.out.println(p.prv);  // 에러 (같은 클래스가 아님)
        System.out.println(p.dft);  // 가능
        System.out.println(p.prt);  // 가능
        System.out.println(p.pub);  // 가능
    }
}
