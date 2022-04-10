package designpattern.singleton;

import java.io.Serializable;

//public class Settings implements Serializable {
//
//    private Settings() {}
//
//    private static class SettingsHolder {
//        private static final Settings INSTANCE = new Settings();
//    }
//
//    public static Settings getInstance() {
//        return SettingsHolder.INSTANCE;
//    }
//
//    protected Object readResolve() {
//        return getInstance();
//    }
//}
/*
    리플렉션으로 싱글톤을 깨는 것을 막기 위해서 다음과 같이 enum을 사용할 수 있습니다.
 */
public enum Settings {
    INSTANCE;

}