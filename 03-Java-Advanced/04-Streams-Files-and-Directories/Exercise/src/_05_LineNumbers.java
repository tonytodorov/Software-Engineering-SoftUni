import java.io.*;

public class _05_LineNumbers {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\User\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        BufferedReader bufferedReader = new BufferedReader
                (new InputStreamReader(new FileInputStream(path)));

        FileWriter fileWriter = new FileWriter("line-numbers");

        String line = bufferedReader.readLine();
        int count = 1;

        while (line != null) {
            fileWriter.write(String.format("%d. %s%n", count, line));
            count += 1;

            line = bufferedReader.readLine();
        }

        fileWriter.flush();
    }
}
