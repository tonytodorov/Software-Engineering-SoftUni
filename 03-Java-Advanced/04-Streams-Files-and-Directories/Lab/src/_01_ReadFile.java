import java.io.FileInputStream;
import java.io.IOException;

public class _01_ReadFile {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\PC-TONY\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);
        int bytes = fileInputStream.read();

        while (bytes >= 0) {
            System.out.printf("%s ", Integer.toBinaryString(bytes));
            bytes = fileInputStream.read();
        }

    }
}
