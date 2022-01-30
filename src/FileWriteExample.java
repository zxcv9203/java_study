import java.io.FileWriter;
import java.io.IOException;

public class FileWriteExample {
    public static void main(String[] args) {
        FileWriter w = null;
        try {
            w = new FileWriter("src/output01.txt", true);
        } catch (IOException e) {
            System.out.println("파일 생성에 실패했습니다.");
            System.exit(1);
        }
        try {
            w.write("생성완료");
            w.close();
        } catch (IOException e){
            System.out.println("파일에 데이터를 쓰는데 실패했습니다.");
            System.exit(2);
        }
    }
}
