package algorithm.bakingdog.chap03;

/*
    주어진 길이 N의 int 배열 arr에서 합이 100인 서로 다른 위치의 두 원소가 존재하면 1을, 존재하지 않으면 0을 반환하는 함수
    func2(int arr[], int N)을 작성하세요
    arr의 각 수는 0 이상 100 이하이고 N은 1000 이하 입니다.
 */
public class Exam01 {

    static int func1(int[] arr, int N) {
        boolean[] answer = new boolean[101];
        for (int n : arr) {
            int operand = 100 - n;
            if (answer[operand]) {
                return 1;
            }
            answer[n] = true;
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(func1(new int[]{1, 52, 48}, 3));
    }
}
