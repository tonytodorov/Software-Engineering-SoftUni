import java.util.Arrays;
import java.util.Scanner;

public class _02_BlindManBuff {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = dimensions[0];
        int m = dimensions[1];

        String[][] matrix = new String[n][m];

        int startRow = -1;
        int startCol = -1;

        for (int i = 0; i < matrix.length; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int j = 0; j < input.length; j++) {
                if (input[j].equals("B")) {
                    startRow = i;
                    startCol = j;
                }
            }

            matrix[i] = input;
        }

        String command = scanner.nextLine();

        int moves = 0;
        int players = 0;


        while (!command.equals("Finish")) {

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

            if (isOutOfMatrix(matrix, currentRow, currentCol)) {
                command = scanner.nextLine();
                continue;
            } else if (matrix[currentRow][currentCol].equals("-")) {
                moves++;
                matrix[startRow][startCol] = "-";
                matrix[currentRow][currentCol] = "B";
                startRow = currentRow;
                startCol = currentCol;
            } else if (matrix[currentRow][currentCol].equals("P")) {
                moves++;
                players++;
                matrix[startRow][startCol] = "-";
                matrix[startRow][startCol] = "B";
                startRow = currentRow;
                startCol = currentCol;
            }

            if (players == 3) {
                break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Game over!%n" +
                "Touched opponents: %d Moves made: %d", players, moves);
    }

    private static boolean isOutOfMatrix(String[][] matrix, int startRow, int startCol) {
        return startRow < 0 || startRow >= matrix.length ||
                startCol < 0 || startCol >= matrix.length;
    }
}
