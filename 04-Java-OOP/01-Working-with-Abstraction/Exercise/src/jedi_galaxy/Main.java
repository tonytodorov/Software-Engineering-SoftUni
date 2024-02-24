package jedi_galaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = read(scanner);

        int row = dimensions[0];
        int col = dimensions[1];

        int[][] matrix = new int[row][col];

        fillMatrix(matrix, row, col);

        String command = scanner.nextLine();
        long sum = 0;

        while (!command.equals("Let the Force be with you")) {
            int[] playerCoordinates = Arrays.stream(command
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] evilCoordinates = read(scanner);

            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];

            evilMove(matrix, evilRow, evilCol);

            int playerRow = playerCoordinates[0];
            int playerCol = playerCoordinates[1];

            sum += playerMove(matrix, playerRow, playerCol);

            command = scanner.nextLine();
        }

        System.out.println(sum);
    }

    private static int[] read(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void fillMatrix(int[][] matrix, int row, int col) {
        int value = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = value++;
            }
        }
    }

    private static boolean isValidIndex(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    private static void evilMove(int[][] matrix, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (isValidIndex(matrix, evilRow, evilCol)) {
                matrix[evilRow][evilCol] = 0;
            }

            evilRow--;
            evilCol--;
        }
    }

    private static long playerMove(int[][] matrix, int playerRow, int playerCol) {
        long sum = 0;

        while (playerRow >= 0 && playerCol < matrix[1].length) {
            if (isValidIndex(matrix, playerRow, playerCol)) {
                sum += matrix[playerRow][playerCol];
            }

            playerCol++;
            playerRow--;
        }

        return sum;
    }
}
