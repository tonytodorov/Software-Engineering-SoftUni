import java.util.Scanner;

public class _02_ClearSkies {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][];

        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String[] symbols = scanner.nextLine().split("");

            for (int j = 0; j < symbols.length; j++) {
                if (symbols[j].equals("J")) {
                    startRow = i;
                    startCol = j;
                }
            }

            matrix[i] = symbols;
        }

        int unitsOfArmour = 300;
        int enemyAircraft = 4;

        boolean isWinBattle = false;

        while (unitsOfArmour > 0) {
            String command = scanner.nextLine();

            int currentRow = startRow;
            int currentCol = startCol;

            if (command.equals("up")) {
                currentRow -= 1;
            } else if (command.equals("down")) {
                currentRow += 1;
            } else if (command.equals("left")) {
                currentCol -= 1;
            } else if (command.equals("right")) {
                currentCol += 1;
            }

            if (matrix[currentRow][currentCol].equals("-")) {
                matrix[startRow][startCol] = "-";
                matrix[currentRow][currentCol] = "J";
                startRow = currentRow;
                startCol = currentCol;
            } else if (matrix[currentRow][currentCol].equals("E")) {
                enemyAircraft -= 1;
                unitsOfArmour -= 100;
                matrix[startRow][startCol] = "-";
                matrix[currentRow][currentCol] = "-";
                startRow = currentRow;
                startCol = currentCol;

                if (enemyAircraft == 0) {
                    isWinBattle = true;
                    break;
                }
            } else if (matrix[currentRow][currentCol].equals("R")) {
                unitsOfArmour = 300;
                matrix[startRow][startCol] = "-";
                matrix[currentRow][currentCol] = "J";
                startRow = currentRow;
                startCol = currentCol;
            }
        }

        matrix[startRow][startCol] = "J";

        if (isWinBattle) {
            System.out.println("Mission accomplished, you neutralized the aerial threat!");
        } else {
            System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!%n",
                    startRow, startCol);
        }

        printMatrix(matrix);
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
