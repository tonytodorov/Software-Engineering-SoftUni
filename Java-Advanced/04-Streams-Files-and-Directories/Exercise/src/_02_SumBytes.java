import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02_SumBytes {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\PC-TONY\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        String line = bufferedReader.readLine();
        int sum = 0;

        while (line != null) {

            for (char currentChar: line.toCharArray()) {
                sum += currentChar;
            }

            line = bufferedReader.readLine();
        }

        System.out.println(sum);
    }
}
