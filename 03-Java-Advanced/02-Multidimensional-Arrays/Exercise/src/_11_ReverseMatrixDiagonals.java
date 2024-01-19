import java.util.Arrays;
import java.util.Scanner;

public class _11_ReverseMatrixDiagonals {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = coordinates[0];
        int col = coordinates[1];

        int[][] matrix = new int[row][col];

        for (int[] ints : matrix) {
            int[] numbers = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.arraycopy(numbers, 0, ints, 0, numbers.length);
        }

        int startRow = matrix.length - 1;
        int startCol = col - 1;

        for (int i = 0; i < col; i++) {
            int currentRow = startRow;
            int currentCol = startCol;

            while (currentRow >= 0 && currentCol < col) {
                System.out.print(matrix[currentRow][currentCol] + " ");
                currentRow -= 1;
                currentCol += 1;
            }

            System.out.println();
            startCol -= 1;
        }

        int currentStartRow = matrix.length - 2;
        int currentStartCol = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            int currentRow = currentStartRow;
            int currentCol = currentStartCol;

            while (currentRow >= 0 && currentCol < col) {
                System.out.print(matrix[currentRow][currentCol] + " ");
                currentRow -= 1;
                currentCol += 1;
            }

            System.out.println();
            currentStartRow -= 1;
        }
    }
}