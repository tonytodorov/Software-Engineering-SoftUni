import java.util.Scanner;

public class _02_NavyBattle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][];

        int startRow = -1;
        int startCol = -1;

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

        int minesHit = 0;
        int cruisersHit = 0;

        while (minesHit != 3 && cruisersHit != 3) {

            String command = scanner.nextLine();
            matrix[startRow][startCol] = "-";

            if (command.equals("up")) {
                startRow -= 1;
            } else if (command.equals("down")) {
                startRow += 1;
            } else if (command.equals("left")) {
                startCol -= 1;
            } else if (command.equals("right")) {
                startCol += 1;
            }

            if (matrix[startRow][startCol].equals("*")) {
                minesHit++;
            } else if (matrix[startRow][startCol].equals("C")) {
                cruisersHit++;
            }

            matrix[startRow][startCol] = "-";
        }

        matrix[startRow][startCol] = "S";

        if (minesHit == 3) {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n",
                    startRow, startCol);
        } else {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
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
