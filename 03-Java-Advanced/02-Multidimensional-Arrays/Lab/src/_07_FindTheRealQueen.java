import java.util.Scanner;

public class _07_FindTheRealQueen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];

        for (String[] currentRow : matrix) {
            String[] data = scanner.nextLine().split(" ");

            System.arraycopy(data, 0, currentRow, 0, data.length);
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("q")) {
                    if (isRowValid(matrix, row, col)) {
                        if (isColValid(matrix, row, col)) {
                            if (isFirstPartMainDiagonalValid(matrix, row, col)) {
                                if (isSecondPartMainDiagonalValid(matrix, row, col)) {
                                    if (isFirstPartSecondDiagonalValid(matrix, row, col)) {
                                        if (isSecondPartSecondDiagonalValid(matrix, row, col)) {
                                            System.out.printf("%d %d", row, col);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean isRowValid(String[][] matrix, int row, int col) {

        int currentCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row][currentCol].equals("q") && col != currentCol) {
                return false;
            }

            currentCol += 1;
        }

        return true;
    }

    public static boolean isColValid(String[][] matrix, int row, int col) {

        int currentRow = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[col][currentRow].equals("q") && currentRow != row) {
                return false;
            }

            currentRow += 1;
        }

        return true;
    }

    public static boolean isFirstPartMainDiagonalValid(String[][] matrix, int row, int col) {

        while (row > 0 && col > 0) {
            String currentElement = matrix[row - 1][col - 1];

            if (currentElement.equals("q")) {
                return false;
            } else {
                row -= 1;
                col -= 1;
            }
        }

        return true;
    }

    public static boolean isSecondPartMainDiagonalValid(String[][] matrix, int row, int col) {

        while (row < matrix.length - 1 && col < matrix.length - 1) {
            String currentElement = matrix[row + 1][col + 1];

            if (currentElement.equals("q")) {
                return false;
            } else {
                row += 1;
                col += 1;
            }
        }

        return true;
    }

    public static boolean isFirstPartSecondDiagonalValid(String[][] matrix, int row, int col) {

        while (row > 0 && col < matrix.length - 1) {
            String currentElement = matrix[row - 1][col + 1];

            if (currentElement.equals("q")) {
                return false;
            } else {
                row -= 1;
                col += 1;
            }
        }

        return true;
    }

    public static boolean isSecondPartSecondDiagonalValid(String[][] matrix, int row, int col) {

        while (col > 0 && row < matrix.length - 1) {
            String currentElement = matrix[row + 1][col - 1];

            if (currentElement.equals("q")) {
                return false;
            } else {
                row += 1;
                col -= 1;
            }
        }

        return true;
    }
}
