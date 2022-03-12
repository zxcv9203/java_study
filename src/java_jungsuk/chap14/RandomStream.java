package java_jungsuk.chap14;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomStream {
    public static void main(String[] args) {
//        IntStream intStream = new Random().ints();  // 무한 스트림
        IntStream intStream = new Random().ints(5, 5, 10);  // 무한 스트림

//        intStream.limit(5).forEach(System.out::println);
        intStream.forEach(System.out::println);

    }
}
