package java_jungsuk.chap09;

public class ParseTest {
    public static void main(String[] args) {
        String num = "100";

        System.out.println("i = " + Integer.parseInt(num));
        System.out.println("i = " + Integer.parseInt(num, 10));
        System.out.println("i = " + Integer.parseInt(num, 2));
        System.out.println("i = " + Integer.parseInt(num, 8));
        System.out.println("i = " + Integer.parseInt(num, 16));
        System.out.println("i = " + Integer.parseInt("FF", 16));
    }
}
