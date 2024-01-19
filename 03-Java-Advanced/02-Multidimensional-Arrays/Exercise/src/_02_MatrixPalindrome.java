import java.util.Arrays;
import java.util.Scanner;

public class _02_MatrixPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = input[0];
        int col = input[1];

        String[][] words = new String[row][col];

        char currentLetter = 'a';

        for (String[] letter : words) {
            String[] currentRow = currentWord(col, currentLetter);

            System.arraycopy(currentRow, 0, letter, 0, currentRow.length);
            currentLetter += 1;
        }

        printMatrix(words);
    }

    public static String[] currentWord(int col, char currentLetter) {

        String[] words = new String[col];
        int index = 0;

        for (char i = currentLetter; i < currentLetter + col; i++) {
            words[index] = String.valueOf(currentLetter) + i + currentLetter;
            index += 1;

        }

        return words;
    }

    public static void printMatrix(String[][] matrix) {

        for (String[] currentRow : matrix) {
            for (String currentWord : currentRow) {
                System.out.print(currentWord + " ");
            }
            System.out.println();
        }
    }
}
