package algorithm.bakingdog.chap01;

/*
    n 이하의 자연수 중에서 3의 배수이거나 5의 배수인 수를 모두 합한 값을 반환하는 함수 func1(int N)를 작성하세요
    n은 10만이하의 자연수입니다.
 */

public class exam01 {
    static int func1(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(func1(34567));
    }
}
