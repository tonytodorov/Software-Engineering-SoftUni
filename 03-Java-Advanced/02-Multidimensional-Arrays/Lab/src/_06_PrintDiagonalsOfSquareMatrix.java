import java.util.Arrays;
import java.util.Scanner;

public class _06_PrintDiagonalsOfSquareMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        
        int[][] matrix = new int[n][n];

        for (int[] currentRow : matrix) {
            int[] numbers = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.arraycopy(numbers, 0, currentRow, 0, matrix.length);
        }

        int[] firstDiagonal = new int[n];
        int[] secondDiagonal = new int[n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    firstDiagonal[i] = matrix[i][j];
                }

                if (matrix.length - 1 - i == j) {
                    secondDiagonal[matrix.length - 1 - i] = matrix[i][j];
                }
            }
        }

        print(firstDiagonal);
        print(secondDiagonal);
    }

    public static void print(int[] array) {

        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println();
    }
}
