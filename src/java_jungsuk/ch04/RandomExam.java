package java_jungsuk.ch04;

public class RandomExam {
    public static void main(String[] args) {
        // 블럭 안의 내용을 20번 반복합니다.
        for (int i = 0; i <= 20; i++) {
//            System.out.println(Math.random());
//            System.out.println(Math.random() * 10);
            System.out.println((int)(Math.random() * 10));
        }
    }
}
