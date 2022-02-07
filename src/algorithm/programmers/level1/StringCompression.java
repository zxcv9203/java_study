package algorithm.programmers.level1;

public class StringCompression {

    static int solution(String s) {
        int len = s.length();
        int answer = len;
        for (int i = 1; i <= len / 2; i++) {
            int compress = 1;
            String compStr = s.substring(0, i);
            StringBuilder comp = new StringBuilder();
            for (int j = i; j <= len; j+=i) {
                String next = s.substring(j, Math.min(j + i, len));
                if (compStr.equals(next)) {
                    compress++;
                } else {
                    if (compress != 1) {
                        comp.append(compress);
                    }
                    comp.append(compStr);
                    compStr = next;
                    compress = 1;
                }
            }
            comp.append(compStr);
            answer = Math.min(answer, comp.length());
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution("ababcdcdababcdcd"));
    }
}
