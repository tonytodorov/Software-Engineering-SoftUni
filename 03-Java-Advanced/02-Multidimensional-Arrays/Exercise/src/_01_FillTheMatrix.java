import java.util.Scanner;

public class _01_FillTheMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int n = Integer.parseInt(input[0]);
        String method = input[1];

        int[][] matrix = new int[n][n];

        if (method.equals("A")) {
            fillMatrixTopToBottom(matrix);
        } else {
            fillMatrixLeftToRight(matrix);
        }

        printMatrix(matrix);
    }

    public static void fillMatrixTopToBottom(int[][] matrix) {

        int number = 1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
               matrix[col][row] = number;
               number += 1;
            }
        }
    }

    public static void fillMatrixLeftToRight(int[][] matrix) {

        int number = 1;

        for (int row = 0; row < matrix.length; row++) {

            if (row % 2 == 0) {
                for (int col = 0; col < matrix.length; col++) {
                    matrix[col][row] = number;
                    number += 1;
                }
            } else {
                for (int col = matrix.length - 1; col >= 0; col--) {
                    matrix[col][row] = number;
                    number += 1;
                }
            }
        }
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
