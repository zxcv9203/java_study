package java_jungsuk.chap14;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class StreamGrouping {
    public static void main(String[] args) {
        Student3[] stdArr = {
                new Student3("나자바", true, 1, 1, 300),
                new Student3("김지미", false, 1, 1, 250),
                new Student3("김자바", true, 1, 1, 200),
                new Student3("이지미", false, 1, 1, 150),
                new Student3("남자바", false, 1, 2, 100),
                new Student3("안지미", false, 1, 2, 50),
                new Student3("황지미", true, 1, 2, 250),
                new Student3("강지미", false, 1, 3, 150),
                new Student3("이자바", true, 1, 3, 250),
                new Student3("나자바", true, 1, 3, 50),
                new Student3("김지미", true, 2, 1, 300),
                new Student3("김자바", false, 2, 1, 200),
                new Student3("이지미", true, 2, 1, 50),
                new Student3("남자바", false, 2, 2, 100),
                new Student3("안지미", true, 2, 2, 50),
                new Student3("황지미", false, 2, 3, 250),
                new Student3("강지미", true, 2, 3, 300),
                new Student3("이자바", false, 2, 3, 200)
        };
        System.out.println("1. 단순분할(반별로 분할)\n");
        Map<Integer, List<Student3>> stuByBan = Stream.of(stdArr)
                .collect(groupingBy(Student3::getBan));

        for (List<Student3> ban : stuByBan.values()) {
            for(Student3 s : ban) {
                System.out.println(s);
            }
        }

        System.out.println("\n2. 단순그룹화 (성적별로 그룹화)\n");
        Map<Student3.Level, List<Student3>> stuByLevel = Stream.of(stdArr)
                .collect(groupingBy(s -> {
                    if (s.getScore() >= 200) return Student3.Level.HIGH;
                    else if (s.getScore() >= 100) return Student3.Level.MID;
                    else return Student3.Level.LOW;
                }));

        TreeSet<Student3.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for (Student3.Level key : keySet) {
            System.out.println("[" + key + "]");
            for (Student3 s : stuByLevel.get(key))
                System.out.println(s);
            System.out.println();
        }

        System.out.println("\n3. 단순그룹화 + 통계 (성적별 학생수)\n");
        Map<Student3.Level, Long> stuCntByLevel = Stream.of(stdArr)
                .collect(groupingBy(s -> {
                    if (s.getScore() >= 200) return Student3.Level.HIGH;
                    else if (s.getScore() >= 100) return Student3.Level.MID;
                    else return Student3.Level.LOW;
                }, counting()));
        for (Student3.Level key : stuCntByLevel.keySet()) {
            System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
        }
        System.out.println();

        System.out.println("\n4. 다중 그룹화 (학년별, 반별)\n");
        Map<Integer, Map<Integer, List<Student3>>> stuByHakAndBan =
                Stream.of(stdArr)
                        .collect(groupingBy(Student3::getHak,
                                groupingBy(Student3::getBan)
                        ));
        for (Map<Integer, List<Student3>> hak : stuByHakAndBan.values()) {
            for (List<Student3> ban : hak.values()) {
                System.out.println();
                for (Student3 s : ban)
                    System.out.println(s);
            }
        }

        System.out.println("\n5. 다중 그룹화 + 통계 (학년별, 반별 1등)\n");
        Map<Integer, Map<Integer, Student3>> topStuByHakAndBan =
                Stream.of(stdArr)
                        .collect(groupingBy(Student3::getHak,
                                groupingBy(Student3::getBan,
                                        collectingAndThen(
                                                maxBy(comparingInt(Student3::getScore))
                                                , Optional::get
                                        )
                                )
                        ));

        for (Map<Integer, Student3> ban : topStuByHakAndBan.values()) {
            for (Student3 s : ban.values()) {
                System.out.println(s);
            }
        }
        System.out.println("\n6. 다중 그룹화 + 통계 (학년별, 반별 성적 그룹)\n");
        Map<String, Set<Student3.Level>> stuByScoreGroup = Stream.of(stdArr)
                .collect(groupingBy(s -> s.getHak() + "-" + s.getBan(),
                        mapping(s -> {
                            if (s.getScore() >= 200) return Student3.Level.HIGH;
                            else if (s.getScore() >= 100) return Student3.Level.MID;
                            else return Student3.Level.LOW;
                }, toSet())
                ));
        Set<String> keySet2 = stuByScoreGroup.keySet();
        for (String key : keySet2) {
            System.out.println("[" + key + "]" + stuByScoreGroup.get(key));
        }
    }
}

class Student3 {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    Student3(String name, boolean isMale, int hak, int ban, int score) {
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