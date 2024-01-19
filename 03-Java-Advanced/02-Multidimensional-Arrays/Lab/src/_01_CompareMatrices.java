import java.util.Arrays;
import java.util.Scanner;

public class _01_CompareMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstInput = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstMatrixRow = firstInput[0];
        int firstMatrixCol = firstInput[1];

        int[][] firstMatrix = new int[firstMatrixRow][firstMatrixCol];

        for (int[] matrix : firstMatrix) {

            int[] input = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.arraycopy(input, 0, matrix, 0, matrix.length);
        }

        int[] secondInput = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int secondMatrixRow = secondInput[0];
        int secondMatrixCol = secondInput[1];

        int[][] secondMatrix = new int[secondMatrixRow][secondMatrixCol];

        for (int[] matrix : secondMatrix) {

            int[] input = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.arraycopy(input, 0, matrix, 0, matrix.length);
        }

        if (firstMatrixRow != secondMatrixRow || firstMatrixCol != secondMatrixCol) {
            System.out.println("not equal");
        } else {
            boolean isMatricesEquals = isMatricesEquals(firstMatrix, secondMatrix);

            if (isMatricesEquals) {
                System.out.println("equal");
            } else {
                System.out.println("not equal");
            }
        }
    }

    public static boolean isMatricesEquals(int[][] firstMatrix, int[][] secondMatrix) {

        for (int i = 0; i < firstMatrix.length; i++) {

            int[] firstNum = firstMatrix[i];
            int[] secondNum = secondMatrix[i];

            for (int j = 0; j < firstNum.length; j++) {
                if (firstNum[j] != secondNum[j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
