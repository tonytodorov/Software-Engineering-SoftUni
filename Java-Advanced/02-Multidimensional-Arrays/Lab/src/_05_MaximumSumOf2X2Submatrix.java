import java.util.Arrays;
import java.util.Scanner;

public class _05_MaximumSumOf2X2Submatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine()
                            .split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.arraycopy(numbers, 0, matrix[i], 0, col);
        }

        int[][] bestSubmatrix = new int[2][2];
        int bestSum = Integer.MIN_VALUE;

        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {

                int firstElement = matrix[i][j];
                int secondElement = matrix[i][j + 1];
                int thirdElement = matrix[i + 1][j];
                int fourthElement = matrix[i + 1][j + 1];

                int sum = firstElement + secondElement + thirdElement + fourthElement;

                if (sum > bestSum) {
                    bestSum = sum;
                    bestSubmatrix[0][0] = firstElement;
                    bestSubmatrix[0][1] = secondElement;
                    bestSubmatrix[1][0] = thirdElement;
                    bestSubmatrix[1][1] = fourthElement;
                }
            }
        }

        for (int i = 0; i < bestSubmatrix.length; i++) {
            for (int j = 0; j < bestSubmatrix.length; j++) {
                System.out.print(bestSubmatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(bestSum);
    }
}
