import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadWrite {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("src/chiken.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
    }
}
