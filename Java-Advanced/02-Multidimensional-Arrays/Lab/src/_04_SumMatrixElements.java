import java.util.Arrays;
import java.util.Scanner;

public class _04_SumMatrixElements {

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

        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < col; j++) {
                sum += matrix[i][j];
            }
        }

        System.out.println(row);
        System.out.println(col);
        System.out.println(sum);
    }
}
