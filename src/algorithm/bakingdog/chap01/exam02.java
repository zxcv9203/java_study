package algorithm.bakingdog.chap01;

/*
    주어진 길이 N의 int 배열 arr에서 합이 100인 서로 다른 위치의 두 원소가 존재하면 1을 존재하지 않으면 0을 반환하는 함수
    func2를 작성하세요
    arr의 각 수는 0이상 100이하이고 N은 1000이하입니다.
 */
public class exam02 {
    static int func2(int[] arr, int n) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 100) {
                    return 1;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(func2(new int[]{1, 52, 48}, 3));
    }
}
