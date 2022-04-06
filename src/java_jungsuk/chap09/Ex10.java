package java_jungsuk.chap09;

public class Ex10 {
    public static void main(String[] args) {
        int iVal = 100;
        String s1 = iVal + "";              // int to String 방법 1
        String s2 = String.valueOf(iVal);   // int to String 방법 2 (1보다 빠름)

        double dVal = 200.0;
        String s3 = dVal + "";              // Double to String 방법 1
        String s4 = String.valueOf(dVal);   // Double to String 방법 2 (1보다 빠름)

        double sum = Integer.parseInt("+" + s1) + Double.parseDouble(s3);
        double sum2 = Integer.parseInt(s1) + Double.parseDouble(s3);

        System.out.println(s1+"+"+s3+"="+sum2);
        // 위보다 join을 이용한 문자열 합친 것이 더 빠름
        System.out.println(String.join("",s1, "+",s3,"=")+sum);

    }
}
