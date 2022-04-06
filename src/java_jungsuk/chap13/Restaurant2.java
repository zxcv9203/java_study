package java_jungsuk.chap13;

// wait() notify() 사용

import java.util.ArrayList;

public class Restaurant2 {
    public static void main(String[] args) throws Exception {
        Table2 table = new Table2();

        new Thread(new Cook2(table), "COOK").start();
        new Thread(new Customer2(table, "donut"), "CUST1").start();
        new Thread(new Customer2(table, "burger"), "CUST2").start();
        Thread.sleep(2000);
        System.exit(0);
    }
}

class Table2 {
    String[] dishNames = {"donut", "donut", "burger"};
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) {
        while (dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is waiting");
            try {
                wait();     // COOK thread 를 기다리게 한다.
                Thread.sleep(500);
            } catch(InterruptedException ignored) {}
        }
        dishes.add(dish);
        notify();           // 기다리고 있는  CUST를 깨우기 위함
        System.out.println("Dishes : " + dishes.toString());
    }

    public void remove(String dishName) {
        synchronized (this) {
            String name = Thread.currentThread().getName();

            while (dishes.size() == 0) {
                System.out.println(name + " is waiting.");
                try {
                    wait();     // CUST 쓰레드를 기다리게 합니다.
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {}
            }
            while (true) {
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        notify();       //잠자고 있는 COOK을 깨우기 위함
                        return;
                    }
                }

                try {
                    System.out.println(name + " is waiting.");
                    wait();
                    Thread.sleep(500);
                } catch(InterruptedException ignored) {}
            }
        }
    }

    public int dishNum() {
        return dishNames.length;
    }
}

class Cook2 implements Runnable {
    private Table2 table;

    Cook2(Table2 table) { this.table = table; }

    public void run() {
        while (true) {
            int idx = (int)(Math.random() * table.dishNum());
            table.add(table.dishNames[idx]);
            try {
                Thread.sleep(10);
            } catch(InterruptedException ignored) {}
        }
    }
}

class Customer2 implements Runnable {
    private Table2 table;
    private String food;

    Customer2(Table2 table, String food) {
        this.table = table;
        this.food = food;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {}
            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name + " ate a " + food);
        }
    }
}

