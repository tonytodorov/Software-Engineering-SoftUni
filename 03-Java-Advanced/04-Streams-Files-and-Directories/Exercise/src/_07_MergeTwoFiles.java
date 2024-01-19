import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class _07_MergeTwoFiles {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String inputOne = "C:\\Users\\User\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inputTwo = "C:\\Users\\User\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        FileWriter mergeTwoFiles = new FileWriter("merge-two-files");

        Scanner readFirstFile = new Scanner(new FileInputStream(inputOne));
        Scanner readSecondFile = new Scanner(new FileInputStream(inputTwo));

        while (readFirstFile.hasNext()) {
            mergeTwoFiles.write(readFirstFile.next() + "\n");
        }

        while (readSecondFile.hasNext()) {
            mergeTwoFiles.write(readSecondFile.next() + "\n");
        }

        mergeTwoFiles.flush();

    }
}
