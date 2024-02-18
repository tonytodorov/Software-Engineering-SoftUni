import java.util.Scanner;

public class _02_StickyFingers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(",");

        String[][] matrix = new String[n][];

        int startRow = -1;
        int starCol = -1;

        for (int i = 0; i < matrix.length; i++) {
            String[] symbols = scanner.nextLine().split("\\s+");

            for (int j = 0; j < symbols.length; j++) {
                if (symbols[j].equals("D")) {
                    startRow = i;
                    starCol = j;
                }
            }

            matrix[i] = symbols;
        }

        int totalStolenMoney = 0;
        boolean isCaughtByPolice = false;

        for (String currentDirection : directions) {

            int currentRow = startRow;
            int currentCol = starCol;

            if (currentDirection.equals("down")) {
                currentRow += 1;
            } else if (currentDirection.equals("up")) {
                currentRow -= 1;
            } else if (currentDirection.equals("right")) {
                currentCol += 1;
            } else if (currentDirection.equals("left")) {
                currentCol -= 1;
            }

            if (isOutOfField(matrix, currentRow, currentCol)) {
                System.out.println("You cannot leave the town, there is police outside!");
                continue;
            } else if (matrix[currentRow][currentCol].equals("+")) {
                matrix[startRow][starCol] = "+";
                matrix[currentRow][currentCol] = "D";
                startRow = currentRow;
                starCol = currentCol;
            } else if (matrix[currentRow][currentCol].equals("$")) {
                int stolenMoney = currentRow * currentCol;
                totalStolenMoney += stolenMoney;
                matrix[startRow][starCol] = "+";
                matrix[currentRow][currentCol] = "+";
                startRow = currentRow;
                starCol = currentCol;
                System.out.printf("You successfully stole %d$.%n", stolenMoney);
            } else if (matrix[currentRow][currentCol].equals("P")) {
                matrix[currentRow][currentCol] = "#";
                matrix[startRow][starCol] = "+";
                isCaughtByPolice = true;
                break;
            }
        }

        if (isCaughtByPolice) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", totalStolenMoney);
        } else {
            matrix[startRow][starCol] = "D";
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalStolenMoney);
        }

        printMatrix(matrix);
    }

    public static boolean isOutOfField(String[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length ||
                col < 0 || col >= matrix.length;
    }

    public static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
