package algorithm.bakingdog.chap01;

/*
    n 이하의 수 중에서 가장 큰 2의 거듭제곱수를 반환하는 함수 func4(int n)을 작성하세요
    n은 10 이하의 자연수입니다.
 */
public class exam04 {
    static int func4(int n) {
        int answer = 1;
        while (2 * answer <= n) {
            answer *= 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(func4(97615282));
    }
}
