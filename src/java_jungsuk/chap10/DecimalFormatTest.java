package java_jungsuk.chap10;

import java.text.DecimalFormat;

public class DecimalFormatTest {
    public static void main(String[] args) {
        String n = "1,234,567.89";
        DecimalFormat df = new DecimalFormat("#,###.##");
        DecimalFormat df2 = new DecimalFormat("#.###E0");

        try {
            Number num = df.parse(n);
            System.out.print(n + " -> ");

            double d = num.doubleValue();
            System.out.print(d + " -> ");
            System.out.println(df2.format(num));
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
