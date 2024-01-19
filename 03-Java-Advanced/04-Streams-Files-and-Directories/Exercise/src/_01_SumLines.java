import java.io.*;

public class _01_SumLines {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        String line = bufferedReader.readLine();

        while (line != null) {
            int sum = 0;

            for (char currentChar: line.toCharArray()) {
                sum += currentChar;
            }

            System.out.println(sum);
            line = bufferedReader.readLine();
        }
    }
}
