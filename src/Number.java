public class Number {
    public static void main(String[] args) {
        byte byteInt = 10;
        short shortInt = 20;
        int intInt = 30;
        long longInt = 40;

        System.out.println(byteInt);
        System.out.println(shortInt);
        System.out.println(intInt);
        System.out.println(longInt);

        int sum = byteInt + shortInt;
        int sum2 = shortInt + intInt;
        long sum3 = intInt + longInt;
//        int sum4 = byteInt + longInt;
        float floatNumber = 1.2f;
        double doubleNumber = 4.3;

        System.out.println(floatNumber);
        System.out.println(doubleNumber);

        float floatSum = 0.001f + 0.001f + 0.0001f;
        System.out.println(floatSum);
    }
}
