package algorithm.bakingdog.chap01;

/*
    N이 제곱수이면 1을 반환하고 제곱수가 아니면 0을 반환하는 함수 func3(int n)을 작성하세요
    N은 10억 이하의 자연수입니다.
 */
public class exam03 {
    static int func3(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(func3(756580036));
    }
}
