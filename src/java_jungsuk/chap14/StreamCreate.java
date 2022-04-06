package java_jungsuk.chap14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreate {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStream = list.stream();  // list 로부터 stream 생성

        intStream.forEach(System.out::print);
        
        // stream 은 최종연산(forEach)을 수행하면 닫힘
        intStream = list.stream();
        intStream.forEach(System.out::print);

        System.out.println();
        String[] strArr = {"a", "b", "c"};
//        Stream<String> strStream = Stream.of("a", "b", "c");
//        Stream<String> strStream = Stream.of(strArr);
        Stream<String> strStream = Arrays.stream(strArr);
        strStream.forEach(System.out::println);

        Integer[] intArr = {1, 2, 3, 4, 5};
        Stream<Integer> intStream2 = Arrays.stream(intArr);
//        intStream2.forEach(System.out::println);
        System.out.println("count = " + intStream2.count());

        int[] intArr2 = {1, 2, 3, 4, 5};
        IntStream intStream3 = Arrays.stream(intArr2);
//        System.out.println("sum = " + intStream3.sum());
        System.out.println("sum = " + intStream3.average());
    }
}
