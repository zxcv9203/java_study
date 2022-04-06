package java_jungsuk.chap12;

import java.util.HashMap;

public class GenericTest5 {
    public static void main(String[] args) {
        HashMap<String, Std> map = new HashMap<>(); // JDK 1.7부터 생성자에 타입지정 생략가능

        map.put("자바왕", new Std("자바왕", 1, 1, 100, 100, 100));
        System.out.println(map);
        
        Std s = map.get("자바왕"); // value 가져올때
        
    }
}

class Std {
    String name = "";
    int ban;            // 반
    int no;             // 번호
    int kor;
    int eng;
    int math;

    Std(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}