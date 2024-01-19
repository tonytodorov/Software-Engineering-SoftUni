import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _03_CopyBytes {

    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\PC-TONY\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "copy-bytes";

        FileInputStream fileInputStream = new FileInputStream(inputPath);
        FileOutputStream fileOutputStream = new FileOutputStream(outputPath);

        int bytes = fileInputStream.read();

        while (bytes >= 0) {

            if (bytes == 13) {
                fileOutputStream.write(Integer.toString(bytes).getBytes());
                fileOutputStream.write(bytes);
            } else if (bytes == 10 || bytes == 32) {
                fileOutputStream.write(bytes);
            } else {
                fileOutputStream.write(Integer.toString(bytes).getBytes());
            }

            bytes = fileInputStream.read();
        }

    }
}
