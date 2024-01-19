import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _02_WriteToFile {

    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\PC-TONY\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        FileInputStream fileInputStream = new FileInputStream(inputPath);
        FileOutputStream fileOutputStream = new FileOutputStream("output-file");

        int bytes = fileInputStream.read();

        while (bytes >= 0) {
            char symbol = (char) bytes;

            if (!symbols.contains(symbol)) {
                fileOutputStream.write(symbol);
            }

            bytes = fileInputStream.read();
        }
    }
}
