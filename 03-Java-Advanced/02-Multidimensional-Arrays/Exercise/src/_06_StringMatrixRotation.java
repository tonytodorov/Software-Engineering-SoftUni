import java.util.ArrayList;
import java.util.Scanner;

public class _06_StringMatrixRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotate = scanner.nextLine();
        rotate = rotate.replaceAll("[^\\d]+", "").trim();

        int number = Integer.parseInt(rotate);
        int numberOfRotation = number / 90;

        String word = scanner.nextLine();
        ArrayList<String> words = new ArrayList<>();

        while (!word.equals("END")) {
            words.add(word);
            word = scanner.nextLine();
        }

        char[][] matrix = fillMatrix(words);

        for (int i = 0; i < numberOfRotation; i++) {
            rotateMatrix(matrix);
        }


    }

    public static char[][] fillMatrix(ArrayList<String> words) {

        int n = words.size();
        char[][] matrix = new char[n][];

        for (int i = 0; i < matrix.length; i++) {
            String currentWord = words.get(i);
            matrix[i] = new char[currentWord.length()];

            for (int j = 0; j < currentWord.length(); j++) {
                char letter = currentWord.charAt(j);
                matrix[i][j] = letter;
            }
        }

        return matrix;
    }

    public static void rotateMatrix(char[][] matrix) {


    }
}
