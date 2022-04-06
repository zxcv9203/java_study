package java_jungsuk.chap14;

import java.util.stream.Stream;

public class IterStream {
    public static void main(String[] args) {
        // Iterate(T seed, UnaryOperator f) 단항 연산자
        Stream<Integer> intStream = Stream.iterate(1, n -> n + 2);  // 무한 스트림

        intStream.limit(10).forEach(System.out::println);

        // generate(Supplier s) : 주기만 하는 것 입력X, 출력 O
        Stream<Integer> oneStream = Stream.generate(() -> 1);   // 무한 스트림
        oneStream.limit(10).forEach(System.out::println);

    }
}
