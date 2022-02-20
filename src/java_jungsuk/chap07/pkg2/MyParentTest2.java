package java_jungsuk.chap07.pkg2;

import java_jungsuk.chap07.pkg1.MyParent;

class MyChild extends MyParent {
    public void printMembers() {
//        System.out.println(prv);    // 에러 (다른 패키지이기 때문에 안됨)
//        System.out.println(dft);    // 에러 (다른 패키지이기 때문에 안됨)
        System.out.println(prt);    // OK (다른 패키지지만 자손 클래스이기 때문에 가능)
        System.out.println(pub);    // OK (접근제한 없음)
    }
}
public class MyParentTest2 {
    public static void main(String[] args) {
        MyParent p = new MyParent();
//        System.out.println(p.prv);  // 에러 (같은 클래스가 아님)
//        System.out.println(p.dft);  // 에러 (다른 패키지이기 때문에 안됨)
//        System.out.println(p.prt);  // 에러 (다른 패키지이며, 자손 클래스가 아니기 때문에 불가능)
        System.out.println(p.pub);  // 가능 (접근제한 없음)
    }
}
