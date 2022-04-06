package java_jungsuk.chap09;

public class RountTest {
    public static void main(String[] args) {
        double sum = 0;
        double sum1 = 0;
        double sum2 = 0;

        for (double d = 1.5; d < 10.5; d++) {
//            .5일때 무조건 올림
            double d1 = Math.round(d);
//              .5일때 짝수면 버림, 홀수면 올림
            double d2 = Math.rint(d);

            System.out.printf("%4.1f %4.1f %4.1f%n", d, d1, d2);

            sum += d;
            sum1 += d1;
            sum2 += d2;
        }
        System.out.printf("%4.1f %4.1f %4.1f%n", sum, sum1, sum2);

    }
}
