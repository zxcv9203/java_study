package java_jungsuk.chap12;

enum Direction {EAST, SOUTH, WEST, NORTH};

public class EnumTest {
    public static void main(String[] args) {
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Direction.valueOf(Direction.class, "EAST");

        System.out.println("#######################");
        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);
        System.out.println("#######################");
        System.out.println("d1 == d2 ? " + (d1==d2));
        System.out.println("d1 == d3 ? " + (d1==d3));
        System.out.println("d1.equals(d3) ? " + d1.equals(d3));
//        System.out.println("d2 > d3 ? " + (d2 > d3)); // 열거형(enum)은 비교 연산자 사용불가
        // 열거형의 비교는 compareTo 메서드를 사용하여 해야함
        System.out.println("d1.compareTo(d3) ? " + d1.compareTo(d3));
        System.out.println("d1.equals(d2) ? " + d1.compareTo(d2));
        System.out.println("#######################");

        switch(d1) {
            case EAST -> System.out.println("The Direction is EAST");
            case WEST -> System.out.println("The Direction is WEST");
            case SOUTH -> System.out.println("The Direction is SOUTH");
            case NORTH -> System.out.println("The Direction is NORTH");
        }
        System.out.println("#######################");

        Direction[] dArr = Direction.values();
        for (Direction d : dArr) {
            System.out.printf("%s = %d\n", d.name(), d.ordinal());
        }
    }
}
