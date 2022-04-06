package java_jungsuk.chap13;

public class noSyncThread {
    public static void main(String[] args) {
        Runnable r = new NST();
        // Thread Group에 의해 참조되므로 gc 대상이 아닙니다.
        new Thread(r).start();
        new Thread(r).start();
    }
}

class Account {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int money) {
        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}
            balance -= money;
        }
    }
}

class NST implements Runnable {
    Account acc = new Account();

    public void run() {
        while (acc.getBalance() > 0) {
            int money = (int) (Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance : " + acc.getBalance());
        }
    }
}