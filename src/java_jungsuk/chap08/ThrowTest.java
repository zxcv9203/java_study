package java_jungsuk.chap08;

import java.io.File;

public class ThrowTest {
    public static void main(String[] args) {
        try {
            File f = createFile("hmm");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n파일 생성에 실패하였습니다.");
        }
    }

    static File createFile(String name) throws Exception {
        if (name == null || name.equals("")) {
            throw new Exception("파일 이름이 없습니다.");
        }
        File f = new File(name);
        if (f.createNewFile()) {
            System.out.println(f.getName() + " 파일이 성공적으로 생성되었습니다.");
        }
        return f;
    }
}
