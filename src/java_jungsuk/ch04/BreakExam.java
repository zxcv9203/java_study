package java_jungsuk.ch04;

public class BreakExam {
    public static void main(String[] args) {
        int sum = 0;
        int i = 0;

        while (true) {
            if (sum > 100) {
                break;
            }
            sum += ++i;
            System.out.println(sum);
        }
    }
}
