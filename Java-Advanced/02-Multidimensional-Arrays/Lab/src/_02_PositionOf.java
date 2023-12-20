import java.util.Arrays;
import java.util.Scanner;

public class _02_PositionOf {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = input[0];
        int col = input[1];

        int[][] matrix = new int[row][col];

        int length = Math.max(row, col);
        boolean isFoundNumber = false;

        for (int[] init : matrix) {
            int[] numbers = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (row != col) {
                System.arraycopy(numbers, 0, init, 0, length);
            } else {
                System.arraycopy(numbers, 0, init, 0, matrix.length);
            }
        }

        int searchedNum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < matrix.length; i++) {

            int[] currentRow = matrix[i];

            for (int j = 0; j < currentRow.length; j++) {
                if (matrix[i][j] == searchedNum) {
                    isFoundNumber = true;
                    System.out.printf("%d %d%n", i, j);
                }
            }
        }

        if (!isFoundNumber) {
            System.out.println("not found");
        }
    }
}
