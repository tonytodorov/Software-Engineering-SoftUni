import java.util.Arrays;
import java.util.Scanner;

public class _05_MatrixShuffling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = coordinates[0];
        int col = coordinates[1];

        String[][] matrix = new String[row][col];

        for (int i = 0; i < matrix.length; i++) {
            String[] info = scanner.nextLine().split(" ");

            for (int j = 0; j < info.length; j++) {
                matrix[i][j] = info[j];
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] tokens = command.split(" ");

            String operation = tokens[0];

            if (operation.equals("swap") && tokens.length == 5) {

                int firstElementRow = Integer.parseInt(tokens[1]);
                int firstElementCol = Integer.parseInt(tokens[2]);
                int secondElementRow = Integer.parseInt(tokens[3]);
                int secondElementCol = Integer.parseInt(tokens[4]);

                boolean isFirstElementRowValid = isIndexValid(firstElementRow, col);
                boolean isFirstElementColValid = isIndexValid(firstElementCol, col);
                boolean isSecondElementRowValid = isIndexValid(secondElementRow, col);
                boolean isSecondElementColValid = isIndexValid(secondElementCol, col);

                if (isFirstElementRowValid && isFirstElementColValid &&
                        isSecondElementRowValid && isSecondElementColValid) {

                    String temp = matrix[firstElementRow][firstElementCol];
                    matrix[firstElementRow][firstElementCol] = matrix[secondElementRow][secondElementCol];
                    matrix[secondElementRow][secondElementCol] = temp;

                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }
    }

    public static boolean isIndexValid(int index, int col) {
        return index >= 0 && index <= col;
    }

    public static void printMatrix(String[][] matrix) {

        for (String[] currentRow : matrix) {

            for (String currentElement : currentRow) {
                System.out.print(currentElement + " ");
            }

            System.out.println();
        }
    }
}
