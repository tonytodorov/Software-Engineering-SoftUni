import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class _04_ExtractIntegers {

    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\PC-TONY\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(inputPath);
        Scanner scanner = new Scanner(fileInputStream);

        PrintWriter printWriter = new PrintWriter(new FileOutputStream("extract-integers"));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                printWriter.println(scanner.nextInt());
            }

            scanner.next();
        }

        printWriter.flush();
    }
}
