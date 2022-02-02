package java_jungsuk.chap05;

public class StringUsingExam {
    public static void main(String[] args) {
        String s = "ABCDE";
        char c = s.charAt(2);
        String s2 = s.substring(1, 4);
        String s3 = s.substring(1);

        System.out.println(c);
        System.out.println(s2);
        System.out.println(s3);
    }
}
