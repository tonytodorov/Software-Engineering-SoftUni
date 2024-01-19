import java.util.Arrays;
import java.util.Scanner;

public class _03_DiagonalDifference {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.arraycopy(currentRow, 0, matrix[i], 0, currentRow.length);
        }

        int primaryDiagonalSum = primaryDiagonalSum(matrix);
        int secondaryDiagonalSum = secondaryDiagonalSum(matrix);

        int absValue = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);

        System.out.println(absValue);
    }

    public static int primaryDiagonalSum(int[][] matrix) {

        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
            }
        }

        return sum;
    }

    public static int secondaryDiagonalSum(int[][] matrix) {

        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix.length - 1 - i];
        }

        return sum;
    }
}
