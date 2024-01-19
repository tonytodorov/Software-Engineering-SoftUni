import java.io.*;
import java.util.Scanner;

public class _06_WordCount {

    public static void main(String[] args) throws IOException {

        String wordsPath = "C:\\Users\\User\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String filePath = "C:\\Users\\User\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        Scanner readWords = new Scanner(new FileInputStream(wordsPath));

        while (readWords.hasNext()) {
            String currentWord = readWords.next();
            int count = 0;

            Scanner readFileWords = new Scanner(new FileInputStream(filePath));

            while (readFileWords.hasNext()) {
                String currentFileWord = readFileWords.next();

                if (currentWord.equals(currentFileWord)) {
                    count += 1;
                }
            }
            
            System.out.printf("%s - %d%n", currentWord, count);
        }
    }
}
