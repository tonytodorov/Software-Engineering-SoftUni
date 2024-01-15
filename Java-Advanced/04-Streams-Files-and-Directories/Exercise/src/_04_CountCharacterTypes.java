import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class _04_CountCharacterTypes {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader
                (new InputStreamReader(new FileInputStream(path)));

        String line = bufferedReader.readLine();

        int vowels = 0;
        int otherSymbols = 0;
        int punctuationSign = 0;

        while (line != null) {

            for (char currentChar: line.toCharArray()) {
                if (currentChar == 'a' || currentChar == 'e' ||
                        currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
                    vowels += 1;
                } else if (currentChar == '!' || currentChar == ',' || currentChar == '.' || currentChar == '?') {
                    punctuationSign += 1;
                } else if (currentChar != ' ') {
                    otherSymbols += 1;
                }
            }

            line = bufferedReader.readLine();
        }

        System.out.printf("Vowels: %d%n", vowels);
        System.out.printf("Other symbols: %d%n", otherSymbols);
        System.out.printf("Punctuation: %d", punctuationSign);
    }
}
