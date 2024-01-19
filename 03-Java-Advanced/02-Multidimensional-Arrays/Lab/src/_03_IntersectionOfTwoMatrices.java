import java.util.Scanner;

public class _03_IntersectionOfTwoMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[row][col];
        char[][] secondMatrix = new char[row][col];

        for (char[] currentRow : firstMatrix) {
            String[] input = scanner.nextLine().split(" ");

            for (int j = 0; j < currentRow.length; j++) {
                String currentSymbol = input[j];
                char symbol = currentSymbol.charAt(0);

                if (symbol != '*') {
                    currentRow[j] = symbol;
                }
            }
        }

        for (char[] currentRow : secondMatrix) {
            String[] input = scanner.nextLine().split(" ");

            for (int j = 0; j < currentRow.length; j++) {
                String currentSymbol = input[j];
                char symbol = currentSymbol.charAt(0);

                if (symbol != '*') {
                    currentRow[j] = symbol;
                }
            }
        }

        char[][] result = new char[row][col];

        for (int i = 0; i < firstMatrix.length; i++) {

            char[] firstMatrixRow = firstMatrix[i];
            char[] secondMatrixRow = secondMatrix[i];

            for (int j = 0; j < firstMatrixRow.length; j++) {
                if (firstMatrixRow[j] == secondMatrixRow[j]) {
                    result[i][j] = firstMatrixRow[j];
                } else {
                    result[i][j] = '*';
                }
            }
        }

        for (char[] currentRow : result) {
            for (char symbol : currentRow) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}
