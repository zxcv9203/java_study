package java_jungsuk.chap14;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFinalCalc {
    public static void main(String[] args) {
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream",
                "OptionalDouble", "IntStream", "count", "sum"
        };

        Stream.of(strArr)
                .parallel()
                .forEachOrdered(System.out::println);

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s->s.length() == 0);
        Optional<String> sWord = Stream.of(strArr)
                .filter(s->s.charAt(0) == 's')
                .parallel()
                .findAny();

        System.out.println("noEmptyStr = " + noEmptyStr);
        System.out.println("sWord = " + sWord.get());

        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a, b) -> a + 1);
        int sum = intStream2.reduce(0, (a, b) -> a + b);

        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);

        System.out.println(count);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(min);
    }
}
