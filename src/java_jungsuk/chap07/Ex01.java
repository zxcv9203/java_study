package java_jungsuk.chap07;

public class Ex01 {
    public static void main(String[] args) {
        SmartTv sTv = new SmartTv();
        sTv.channel = 10;
        sTv.channelDown();
    }
}

class Tv {
    boolean power;
    int channel;

    void power() { power = !power;}
    void channelUp() { ++channel; }
    void channelDown() { --channel; }
}

class SmartTv extends Tv {
    boolean caption;
    void displayCaption(String text) {
        if (caption) {
            System.out.println(text);
        }
    }
}