import java.util.Arrays;
import java.util.Scanner;

public class _08_WrongMeasurements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        int col = 0;

        int[][] matrix = new int[row][];

        for (int i = 0; i < row; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = new int[numbers.length];
            col = numbers.length;

            System.arraycopy(numbers, 0, matrix[i], 0, numbers.length);
        }

        int[] elementPosition = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int elementRow = elementPosition[0];
        int elementCol = elementPosition[1];

        int[][] resultMatrix = new int[row][col];
        int replacedElement = matrix[elementRow][elementCol];

        for (int i = 0; i < matrix.length; i++) {

            int[] currentRow = matrix[i];

            for (int j = 0; j < currentRow.length; j++) {
                if (matrix[i][j] == replacedElement) {
                    int upperElement = upperElement(matrix, i, j, replacedElement);
                    int downElement = downElement(matrix, i, j, replacedElement);
                    int leftElement = leftElement(matrix, i, j, replacedElement);
                    int rightElement = rightElement(matrix, i, j, col, replacedElement);

                    int newElement = upperElement + downElement + leftElement + rightElement;
                    resultMatrix[i][j] = newElement;
                } else {
                    resultMatrix[i][j] = matrix[i][j];
                }
            }
        }

        printMatrix(resultMatrix);
    }


    public static int upperElement(int[][] matrix, int row, int col, int replacedNumber) {

        int index = row - 1;

        if (index >= 0) {
            if (matrix[index][col] != replacedNumber) {
                return matrix[index][col];
            }
        }

        return 0;
    }

    public static int downElement(int[][] matrix, int row, int col, int replacedNumber) {

        int index = row + 1;

        if (index <= matrix.length - 1) {
            if (matrix[index][col] != replacedNumber) {
                return matrix[index][col];
            }
        }

        return 0;
    }

    public static int leftElement(int[][] matrix, int row, int col, int replacedNumber) {

        int index = col - 1;

        if (index >= 0) {
            if (matrix[row][index] != replacedNumber) {
                return matrix[row][index];
            }
        }

        return 0;
    }

    public static int rightElement(int[][] matrix, int row, int col, int colLength, int replacedNumber) {

        int index = col + 1;

        if (index <= colLength - 1) {
            if (matrix[row][index] != replacedNumber) {
                return matrix[row][index];
            }
        }

        return 0;
    }

    public static void printMatrix(int[][] matrix) {

        for (int[] currentRow : matrix) {

            for (Integer currentNum : currentRow) {
                System.out.print(currentNum + " ");
            }

            System.out.println();
        }
    }
}
