package java_jungsuk.chap14;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class StreamPartitioning {
    public static void main(String[] args) {
        Student2[] stdArr = {
                new Student2("나자바", true, 1, 1, 300),
                new Student2("김지미", false, 1, 1, 250),
                new Student2("김자바", true, 1, 1, 200),
                new Student2("이지미", false, 1, 1, 150),
                new Student2("남자바", false, 1, 2, 100),
                new Student2("안지미", false, 1, 2, 50),
                new Student2("황지미", true, 1, 2, 250),
                new Student2("강지미", false, 1, 3, 150),
                new Student2("이자바", true, 1, 3, 250),
                new Student2("나자바", true, 1, 3, 50),
                new Student2("김지미", true, 2, 1, 300),
                new Student2("김자바", false, 2, 1, 200),
                new Student2("이지미", true, 2, 1, 50),
                new Student2("남자바", false, 2, 2, 100),
                new Student2("안지미", true, 2, 2, 50),
                new Student2("황지미", false, 2, 3, 250),
                new Student2("강지미", true, 2, 3, 300),
                new Student2("이자바", false, 2, 3, 200)
        };
        System.out.println("1. 단순분할(성별로 분할)\n");
        Map<Boolean, List<Student2>> stuBySex = Stream.of(stdArr)
                .collect(partitioningBy(Student2::isMale));

        List<Student2> maleStudent = stuBySex.get(true);
        List<Student2> femaleStudent = stuBySex.get(false);

        for (Student2 s : maleStudent) System.out.println(s);
        for (Student2 s : femaleStudent) System.out.println(s);

        System.out.println("\n2. 단순분할 + 통계 (성별 학생수)\n");
        Map<Boolean, Long> stuNumBySex = Stream.of(stdArr)
                .collect(partitioningBy(Student2::isMale, counting()));

        System.out.println("남학생 수 : " + stuNumBySex.get(true));
        System.out.println("여학생 수 : " + stuNumBySex.get(false));

        System.out.println("\n3. 단순분할 + 통계 (성별 1등)\n");
        Map<Boolean, Optional<Student2>> topScoreBySex = Stream.of(stdArr)
                .collect(partitioningBy(Student2::isMale,
                        maxBy(comparingInt(Student2::getScore))));
        System.out.println("남학생 1등 : " + topScoreBySex.get(true));
        System.out.println("여학생 1등 : " + topScoreBySex.get(false));

        Map<Boolean, Student2> topScoreBySex2 = Stream.of(stdArr)
                .collect(partitioningBy(Student2::isMale,
                       collectingAndThen(
                               maxBy(comparingInt(Student2::getScore)), Optional::get
                       )
                ));
        System.out.println("남학생 1등 : " + topScoreBySex2.get(true));
        System.out.println("여학생 1등 : " + topScoreBySex2.get(false));

        System.out.println("\n4. 다중분할 + 통계 (성별 불합격자, 100점 이하)\n");

        Map<Boolean, Map<Boolean, List<Student2>>> failedStdBySex =
                Stream.of(stdArr).collect(partitioningBy(Student2::isMale,
                        partitioningBy(s -> s.getScore() <= 100))
                );

        List<Student2> failedMaleStd = failedStdBySex.get(true).get(true);
        List<Student2> failedFemaleStd = failedStdBySex.get(false).get(true);

        for(Student2 s : failedMaleStd) System.out.println(s);
        for(Student2 s : failedFemaleStd) System.out.println(s);
    }
}

class Student2 {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    Student2(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }
    String getName() { return name; }
    boolean isMale() { return isMale; }
    int getHak() { return hak; }
    int getBan() { return ban; }
    int getScore() { return score; }

    public String toString() {
        return String.format("[%s, %s %d학년 %d반, %3d점]"
                , name, isMale ? "남" : "여", hak, ban, score);
    }

    enum Level { HIGH, MID, LOW }
}