import java.util.Arrays;
import java.util.Scanner;

public class _07_Crossfire {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = dimensions[0];
        int col = dimensions[1];

        int[][] matrix = new int[row][col];
        fillMatrix(matrix);

        String command = scanner.nextLine();

        while (!command.equals("Nuke it from orbit")) {

            String[] indexes = command.split(" ");

            int elementRow = Integer.parseInt(indexes[0]);
            int elementCol = Integer.parseInt(indexes[1]);
            int radius = Integer.parseInt(indexes[2]);

            boolean isElementRowValid = isRowValid(matrix, elementRow);
            boolean isElementColValid = isColValid(col, elementCol);

            if (isElementRowValid && isElementColValid) {
                matrix[elementRow][elementCol] = -1;

                removeUpperElements(matrix, elementRow, elementCol, radius);
                removeDownElements(matrix, elementRow, elementCol, radius);
                removeLeftElements(matrix, elementRow, elementCol, radius);
                removeRightElements(matrix, elementRow, elementCol, col, radius);

                deleteElements(matrix);
            }

            command = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    public static boolean isRowValid(int[][] matrix, int index) {
        return index >= 0 && index < matrix.length;
    }

    public static boolean isColValid(int col, int index) {
        return index >= 0 && index < col;
    }

    public static void fillMatrix(int[][] matrix) {

        int num = 1;

        for (int i = 0; i < matrix.length; i++) {
            int[] currentRow = matrix[i];

            for (int j = 0; j < currentRow.length; j++) {
                matrix[i][j] = num;
                num += 1;
            }
        }
    }

    public static void removeUpperElements(int[][] matrix, int elementRow, int elementCol, int radius) {

        for (int i = 0; i < radius; i++) {
            elementRow -= 1;

            if (elementRow >= 0) {
                matrix[elementRow][elementCol] = -1;
            }
        }
    }

    public static void removeDownElements(int[][] matrix, int elementRow, int elementCol, int radius) {

        for (int i = 0; i < radius; i++) {
            elementRow += 1;

            if (elementRow <= matrix.length - 1) {
                matrix[elementRow][elementCol] = -1;
            }
        }
    }

    public static void removeLeftElements(int[][] matrix, int elementRow, int elementCol, int radius) {

        for (int i = 0; i < radius; i++) {
            elementCol -= 1;

            if (elementCol >= 0) {
                matrix[elementRow][elementCol] = -1;
            }
        }
    }

    public static void removeRightElements(int[][] matrix, int elementRow, int elementCol, int matrixCol, int radius) {

        for (int i = 0; i < radius; i++) {
            elementCol += 1;


            if (elementCol < matrixCol) {
                matrix[elementRow][elementCol] = -1;
            }
        }
    }

    public static void deleteElements(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            int[] currentRow = matrix[i];
            int[] replace = new int[currentRow.length];
            int index = 0;

            for (int j = 0; j < currentRow.length; j++) {
                if (currentRow[j] != -1) {
                    replace[index] = currentRow[j];
                    index += 1;
                }
            }

            matrix[i] = replace;
        }
    }

    public static void printMatrix(int[][] matrix) {

        for (int[] currentRow : matrix) {

            for (int currentElement : currentRow) {
                if (currentElement != 0) {
                    System.out.print(currentElement + " ");
                }
            }

            System.out.println();
        }
    }
}