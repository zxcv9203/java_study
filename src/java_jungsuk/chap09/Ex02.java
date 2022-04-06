package java_jungsuk.chap09;

public class Ex02 {
    public static void main(String[] args) {
        Person p1 = new Person(801108111222L);
        Person p2 = new Person(801108111222L);

        if (p1.equals(p2)) {
            System.out.println("같음");
        } else {
            System.out.println("다름");
        }
    }
}

class Person {
    long id;

    Person(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            return id == ((Person) obj).id;
        } else {
            return false;
        }
    }
}
