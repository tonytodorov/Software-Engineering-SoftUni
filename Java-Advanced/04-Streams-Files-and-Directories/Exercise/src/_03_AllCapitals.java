import java.io.*;
import java.util.Locale;

public class _03_AllCapitals {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        String line = bufferedReader.readLine();
        FileWriter fileWriter = new FileWriter("all-capitals");

        while (line != null) {
            fileWriter.write(String.format("%s%n", line.toUpperCase(Locale.ROOT)));
            line = bufferedReader.readLine();
        }

        fileWriter.flush();
    }
}
