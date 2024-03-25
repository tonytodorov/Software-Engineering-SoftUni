import java.util.Scanner;

public class _02_Armory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][];

        int startRow = -1;
        int startCol = -1;

        for (int i = 0; i < matrix.length; i++) {
            String[] symbols = scanner.nextLine().split("");

            for (int j = 0; j < symbols.length; j++) {
                if (symbols[j].equals("A")) {
                    startRow = i;
                    startCol = j;
                }
            }

            matrix[i] = symbols;
        }

        int totalCoins = 0;
        boolean isOutOfField = false;

        while (totalCoins < 65) {
            String command = scanner.nextLine();

            int currentRow = startRow;
            int currentCol = startCol;

            if (command.equals("left")) {
                currentCol -= 1;
            } else if (command.equals("right")) {
                currentCol += 1;
            } else if (command.equals("down")) {
                currentRow += 1;
            } else if (command.equals("up")) {
                currentRow -= 1;
            }

            if (isOutOfField(matrix, currentRow, currentCol)) {
                matrix[startRow][startCol] = "-";
                isOutOfField = true;
                break;
            } else if (matrix[currentRow][currentCol].equals("M")) {
                matrix[startRow][startCol] = "-";
                matrix[currentRow][currentCol] = "-";
                int[] mirror = mirrorPosition(matrix);
                startRow = mirror[0];
                startCol = mirror[1];
                matrix[startRow][startCol] = "-";
            } else if (matrix[currentRow][currentCol].equals("-")) {
                matrix[startRow][startCol] = "-";
                matrix[currentRow][currentCol] = "A";
                startRow = currentRow;
                startCol = currentCol;
            } else {
                matrix[startRow][startCol] = "-";
                int price = Integer.parseInt(matrix[currentRow][currentCol]);
                totalCoins += price;
                matrix[currentRow][currentCol] = "A";
                startRow = currentRow;
                startCol = currentCol;
            }
        }

        if (isOutOfField) {
            System.out.printf("I do not need more swords!%n" +
                    "The king paid %d gold coins.%n", totalCoins);
        } else {
            System.out.printf("Very nice swords, I will come back for more!%n" +
                    "The king paid %d gold coins.%n", totalCoins);
        }

        printMatrix(matrix);
    }

    private static int[] mirrorPosition(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("M")) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    private static boolean isOutOfField(String[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length ||
                col < 0 || col >= matrix.length;
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
