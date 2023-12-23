import java.util.Arrays;
import java.util.Scanner;

public class _04_MaximalSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = input[0];
        int col = input[1];

        int[][] matrix = new int[row][col];

        for (int i = 0; i < matrix.length; i++) {

            int[] currentRow = Arrays.stream(scanner.nextLine()
                            .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.arraycopy(currentRow, 0, matrix[i], 0, currentRow.length);
        }

        int maxSum = Integer.MIN_VALUE;
        int[][] bestSubmatrix = new int[3][3];

        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                int[][] submatrix = submatrix(matrix, i, j);
                int submatrixSum = submatrixSum(submatrix);

                if (submatrixSum > maxSum) {
                    maxSum = submatrixSum;
                    bestSubmatrix = submatrix;
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);
        printMatrix(bestSubmatrix);
    }

    public static int[][] submatrix(int[][] matrix, int startRow, int starCol) {

        int[][] submatrix = new int[3][3];
        int row = 0;
        int col = 0;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = starCol; j < starCol + 3; j++) {
                submatrix[row][col] = matrix[i][j];
                col += 1;
            }
            row += 1;
            col = 0;
        }

        return submatrix;
    }

    public static int submatrixSum(int[][] submatrix) {

        int sum = 0;

        for (int i = 0; i < submatrix.length; i++) {
            for (int j = 0; j < submatrix.length; j++) {
                sum += submatrix[i][j];
            }
        }

        return sum;
    }

    public static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
