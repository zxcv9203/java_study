package java_jungsuk.chap14;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        int[] arr = new int[0];

        System.out.println(arr.length);
//        Optional<String> opt = null;        // OK. 하지만 바람직 X
        Optional<String> opt = Optional.empty();
//        Optional<String> opt = Optional.of("abc");
        System.out.println("opt = " + opt);
//        System.out.println("opt = " + opt.get());
        String str = "";

//        try {
//            str = opt.get();        // 예외 발생
//        } catch (Exception e) {
//            str = "";
//        }
        str = opt.orElse("");       // Optional 에 저장된 값이 null 이면 ""반환
        str = opt.orElseGet(String::new);
        System.out.println("str = " + str);
    }
}
