import java.util.Scanner;

public class _02_PascalTriangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n + 1];

        matrix[0][1] = 1;

        for (int row = 1; row < n; row++) {
            for (int col = 1; col <= row + 1; col++) {
                matrix[row][col] = matrix[row - 1][col] + matrix[row - 1][col - 1];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length + 1; j++) {
                if(matrix[i][j] != 0){
                    System.out.printf("%d ", matrix[i][j]);
                }
            }
            System.out.println();
        }
    }
}
