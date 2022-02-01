package java_jungsuk.ch04;

public class NamingLoopExam {
    public static void main(String[] args) {
        Loop1: for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 2)
                    break Loop1;
                System.out.println(j);
            }
        }
    }
}
