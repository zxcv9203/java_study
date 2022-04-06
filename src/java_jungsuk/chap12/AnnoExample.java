package java_jungsuk.chap12;

import java.lang.annotation.*;

@Deprecated
@SuppressWarnings("1111")   // 유효하지 않은 애너테이션은 무시됨
@TestInfo(
        testedBy="aaa",
        testDate=@DateTime(yymmdd="160101", hhmmss="235959")
)
public class AnnoExample {
    public static void main(String[] args) {
        Class<AnnoExample> cls = AnnoExample.class;

        TestInfo anno = cls.getAnnotation(TestInfo.class);
        System.out.println("anno.testedBy() = " + anno.testedBy());
        System.out.println("anno.testedBy() = " + anno.testDate().yymmdd());
        System.out.println("anno.testedBy() = " + anno.testDate().hhmmss());

                for(String str : anno.testTools()) {
                System.out.println("testTools = " + str);
                }

                Annotation[] annoArr = cls.getAnnotations();

                for (Annotation a : annoArr) {
                    System.out.println(a);
                }
    }
}

@Retention(RetentionPolicy.RUNTIME) // 실행시에 가능하도록 지정
@interface TestInfo {
    int count() default 1;
    String testedBy();
    String[] testTools() default "JUnit";   // 하나인 경우 {} 생략가능 값이 없거나 여러개라면 {} 필요
    TestType testType() default TestType.FIRST;
    DateTime testDate();
}

enum TestType {FIRST, SECOND}

@interface DateTime {
    String yymmdd();
    String hhmmss();
}