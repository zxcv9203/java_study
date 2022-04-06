package java_jungsuk.chap10;

import java.text.DecimalFormat;

public class PatternTest {
    public static void main(String[] args) {
        double number = 1234567.89;
        String[] pattern = {
                "0",
                "#",
                "0.0",
                "#.#",
                "000000000.0000",
                "#########.####",
                "#.#-",
                "-#.#",
                "#,###.##",
                "#,####,##",
                "#E0",
                "0E0",
                "##E0",
                "00E0",
                "####E0",
                "0000E0",
                "#.#E0",
                "0.0E0",
                "0.0000000E0",
                "00.000000E0",
                "000.00000E0",
                "#.#######E0",
                "##.######E0",
                "###.#####E0"
        };
        for (String p : pattern) {
            DecimalFormat df = new DecimalFormat(p);
            System.out.println(p + " : " + df.format(number));
        }
    }
}
