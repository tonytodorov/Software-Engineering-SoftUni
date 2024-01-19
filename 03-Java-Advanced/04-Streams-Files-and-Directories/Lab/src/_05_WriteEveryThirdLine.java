import java.io.*;

public class _05_WriteEveryThirdLine {

    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\PC-TONY\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath)));

        String line = bufferedReader.readLine();
        int countLines = 1;

        PrintWriter printWriter = new PrintWriter(new FileOutputStream("write-every-third-line"));

        while (line != null) {
            if (countLines % 3 == 0) {
                printWriter.println(line);
            }

            countLines += 1;
            line = bufferedReader.readLine();
        }

        printWriter.flush();
    }
}
