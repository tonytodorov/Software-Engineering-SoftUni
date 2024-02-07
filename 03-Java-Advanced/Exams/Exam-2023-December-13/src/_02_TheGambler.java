import java.util.Arrays;
import java.util.Scanner;

public class _02_TheGambler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int totalAmount = 100;

        String[][] matrix = new String[n][n];

        int startRow = 0;
        int startCol = 0;


        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("");

            for (int j = 0; j < input.length; j++) {
                if (input[j].equals("G")) {
                    startRow = i;
                    startCol = j;
                }
            }

            matrix[i] = input;
        }

        String command = scanner.nextLine();

        boolean isJackpotWin = false;
        boolean isIndexOrAmountInvalid = false;

        while (!"end".equals(command)) {
            matrix[startRow][startCol] = "-";

            if (command.equals("down")) {
                startRow += 1;
            } else if (command.equals("up")) {
                startRow -= 1;
            } else if (command.equals("left")) {
                startCol -= 1;
            } else if (command.equals("right")) {
                startCol += 1;
            }


            if (startRow < 0 || startRow > matrix.length
                    || startCol < 0 || startCol > matrix.length) {
                isIndexOrAmountInvalid = true;
                break;
            }


            if (matrix[startRow][startCol].equals("W")) {
                totalAmount += 100;
            } else if (matrix[startRow][startCol].equals("P")) {
                totalAmount -= 200;
            } else if (matrix[startRow][startCol].equals("J")) {
                totalAmount += 100000;
                matrix[startRow][startCol] = "G";
                isJackpotWin = true;
                break;
            }


            if (totalAmount <= 0) {
                isIndexOrAmountInvalid = true;
                break;
            }

            matrix[startRow][startCol] = "G";
            command = scanner.nextLine();
        }

        if (isJackpotWin) {
            System.out.println("You win the Jackpot!");
            System.out.printf("End of the game. Total amount: %d$%n", totalAmount);
            printMatrix(matrix);
        } else if (isIndexOrAmountInvalid) {
            System.out.println("Game over! You lost everything!");
        } else {
            System.out.printf("End of the game. Total amount: %d$%n", totalAmount);
            printMatrix(matrix);
        }
    }

    public static void printMatrix(String[][] matrix) {

        for (String[] row: matrix) {
            System.out.println(String.join("", row));
        }
    }
}
