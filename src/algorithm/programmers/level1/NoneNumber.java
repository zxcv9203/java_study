package algorithm.programmers.level1;

public class NoneNumber {
    static int solution(int[] numbers) {
        int answer = 0;
        boolean[] exist = new boolean[10];
        for (int number : numbers) {
            exist[number] = true;
        }
        for (int i = 0; i < exist.length; i++) {
            if (!exist[i])
                answer += i;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
        System.out.println(solution(numbers));
    }
}
