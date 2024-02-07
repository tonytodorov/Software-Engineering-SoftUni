import java.util.Scanner;

public class _02_FishingCompetition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String[] input = scanner.nextLine().split("");

            for (int j = 0; j < input.length; j++) {
                if (input[j].equals("S")) {
                    startRow = i;
                    startCol = j;
                }
            }

            matrix[i] = input;
        }

        String command = scanner.nextLine();
        int totalTons = 0;

        while (!"collect the nets".equals(command)) {

            matrix[startRow][startCol] = "-";

            if ("up".equals(command)) {
                startRow -= 1;

                if (startRow < 0) {
                    startRow = 0;
                }
            } else if ("down".equals(command)) {
                startRow += 1;

                if (startRow >= n) {
                    startRow = 0;
                }
            } else if ("right".equals(command)) {
                startCol += 1;

                if (startCol >= n) {
                    startCol = 0;
                }
            } else if ("left".equals(command)) {
                startCol -= 1;

                if (startCol < 0) {
                    startCol = 0;
                }
            }

            if (matrix[startRow][startCol].equals("W")) {
                System.out.printf("You fell into a whirlpool! " +
                        "The ship sank and you lost the fish you caught." +
                        " Last coordinates of the ship: [%d,%d]", startRow, startCol);
                return;
            } else if (matrix[startRow][startCol].equals("-")) {
                matrix[startRow][startCol] = "S";
            } else {
                int tons = Integer.parseInt(matrix[startRow][startCol]);
                totalTons += tons;
                matrix[startRow][startCol] = "S";
            }

            command = scanner.nextLine();
        }

        int neededTons = 20;

        if (totalTons > neededTons) {
            System.out.printf("Success! You managed to reach the quota!%n" +
                    "Amount of fish caught: %d tons.%n", totalTons);
        } else {
            System.out.printf("You didn't catch enough fish and didn't reach the quota! " +
                    "You need %d tons of fish more.%n" +
                    "Amount of fish caught: %d tons.%n", neededTons - totalTons , totalTons);
        }

        printMatrix(matrix);
    }

    public static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
