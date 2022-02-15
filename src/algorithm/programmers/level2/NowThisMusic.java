package algorithm.programmers.level2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class NowThisMusic {
    static final int stTime = 0;
    static final int edTime = 1;
    static final int title = 2;
    static final int scale = 3;

    static int timeCalc(String st, String ed) {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm", Locale.KOREA);
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = f.parse(ed);
            d2 = f.parse(st);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long diff = Objects.requireNonNull(d1).getTime() - Objects.requireNonNull(d2).getTime();
        long min = diff / 60000;

        return (int) min;
    }
    static String realScale(String scale, int min) {
        int scaleSize = scale.length();

        int tmp = (int) min % scaleSize;
        min /= scaleSize;
        StringBuilder scaleBuilder = new StringBuilder();
        for (int i = 0; i < min; i++) {
            scaleBuilder.append(scale, 0, scaleSize);
        }
        scaleBuilder.append(scale, 0, tmp);
        scale = scaleBuilder.toString();
        System.out.println(tmp);
        return scale;
    }
    static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");
        m = m.replaceAll("A#", "a");
        int max = 0;
        for (String musicInfo : musicinfos) {
            String[] info = musicInfo.split(",");
            int time = timeCalc(info[stTime], info[edTime]);
            info[scale] = info[scale].replaceAll("C#", "c");
            info[scale] = info[scale].replaceAll("D#", "d");
            info[scale] = info[scale].replaceAll("F#", "f");
            info[scale] = info[scale].replaceAll("G#", "g");
            info[scale] = info[scale].replaceAll("A#", "a");
            info[scale] = realScale(info[scale], time);
            if (info[scale].contains(m)) {
                if (max < time) {
                    answer = info[title];
                    max = time;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String m = "ABC";
        String[] musicinfos = {
                "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"
        };
        System.out.println(solution(m, musicinfos));
    }
}
