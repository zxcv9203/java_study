package java_jungsuk.chap13;

public class ThreadExample3 {
    public static void main(String[] args) {
        long stTime = System.currentTimeMillis();

        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }
        System.out.print("\n소요시간 1 : " + (System.currentTimeMillis() - stTime));
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }
        System.out.print("\n소요시간 1 : " + (System.currentTimeMillis() - stTime));
    }
}
