package java_jungsuk.chap05;

public class ArrayExam {
    public static void main(String[] args) {
//        int[] score;
//        score = new int[5];

        int[] score = new int[5];
        score[3] = 100;
        for (int i = 0; i < 5; i++) {
            System.out.println(score[i]);
        }
    }
}
