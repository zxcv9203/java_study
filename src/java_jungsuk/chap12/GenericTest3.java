package java_jungsuk.chap12;

import java.util.ArrayList;
import java.util.List;

public class GenericTest3 {
    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<>();
        ArrayList<Phone> phoneList = new ArrayList<>();
//        ArrayList<Product> phoneList2 = new ArrayList<Phone>(); // 에러
//        List<Phone> phoneList3 = new ArrayList<Phone>();  // Ok, 다형성

        productList.add(new Phone());
        productList.add(new LabTop());

        phoneList.add(new Phone());
        phoneList.add(new Phone());
//        phoneList.add(new LabTop()); // 에러
        printAll(productList);
//        printAll(phoneList);
    }
    public static void printAll(ArrayList<Product> list) {
        for (Product p : list) {
            System.out.println(p);
        }
    }
}

class Product {}
class Phone extends Product {}
class LabTop extends Product {}