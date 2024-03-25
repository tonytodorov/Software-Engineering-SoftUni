import java.util.Scanner;

public class _02_RallyRacing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String carName = scanner.nextLine();

        String[][] matrix = new String[n][];

        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            matrix[i] = input;
        }

        String command = scanner.nextLine();

        int distance = 0;
        boolean isFinishReached = false;

        while (!command.equals("End")) {

            if (command.equals("up")) {
                startRow -= 1;
            } else if (command.equals("down")) {
                startRow += 1;
            } else if (command.equals("left")) {
                startCol -= 1;
            } else if (command.equals("right")) {
                startCol += 1;
            }

            if (matrix[startRow][startCol].equals("F")) {
                distance += 10;
                matrix[startRow][startCol] = "C";
                isFinishReached = true;
                break;
            } else if (matrix[startRow][startCol].equals("T")) {
                matrix[startRow][startCol] = ".";
                int[] teleportCoordinates = teleportCoordinates(matrix);
                startRow = teleportCoordinates[0];
                startCol = teleportCoordinates[1];
                matrix[startRow][startCol] = ".";
                distance += 30;
            } else if (matrix[startRow][startCol].equals(".")) {
                distance += 10;
            }

            command = scanner.nextLine();
        }

        if (isFinishReached) {
            System.out.printf("Racing car %s finished the stage!%n", carName);
        } else {
            matrix[startRow][startCol] = "C";
            System.out.printf("Racing car %s DNF.%n", carName);
        }

        System.out.printf("Distance covered %d km.%n", distance);
        printMatrix(matrix);
    }

    private static int[] teleportCoordinates(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("T")) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
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
