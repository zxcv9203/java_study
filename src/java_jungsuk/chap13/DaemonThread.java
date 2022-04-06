package java_jungsuk.chap13;

public class DaemonThread implements Runnable{
    static boolean autoSave = false;
    public static void main(String[] args) {
        Thread t = new Thread(new DaemonThread());

        t.setDaemon(true);  // 데몬 쓰레드로 변경
        t.start();

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(i);
            if (i == 5) {
                autoSave = true;
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    public void run() {
        while (true) {  // 무한루프
            try {
                Thread.sleep(3 * 1000); // 3초마다
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            // autoSave 의 값이 true 면 autoSave()를 호출합니다.
            if (autoSave) {
                autoSave();
            }
        }
    }
    public void autoSave() {
        System.out.println("자동 저장 완료");
    }
}
