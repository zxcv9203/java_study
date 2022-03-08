package java_jungsuk.chap11;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExample3 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("abc");
        set.add("abc"); // 중복이라 저장안됨
        set.add(new Person("David", 10));
        set.add(new Person("David", 10));

        System.out.println(set);
    }
}

// equals()와 hashCode()를 오버라이딩 하지 않으면 주소 값을 비교하게 됨
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " : " + age;
    }

    @Override
    public int hashCode() {
        // int hash(Object... values);
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person p)) {
            return false;
        }
        return this.name.equals(p.name) && this.age == p.age;
    }
}