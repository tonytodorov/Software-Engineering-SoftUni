import java.util.Arrays;
import java.util.Scanner;

public class _02_DeliveryBoy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = dim[0];
        int m = dim[1];

        String[][] matrix = new String[n][m];

        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String[] input = scanner.nextLine().split("");

            for (int j = 0; j < input.length; j++) {
                if (input[j].equals("B")) {
                    startRow = i;
                    startCol = j;
                }
            }

            matrix[i] = input;
        }

        String command = scanner.nextLine();

        int boyRow = startRow;
        int boyCol = startCol;

        boolean isLeft = false;

        while (!isLeft) {

            if (matrix[boyRow][boyCol].equals("P")) {
                matrix[boyRow][boyCol] = "R";
                System.out.println("Pizza is collected. 10 minutes for delivery.");
            } else if (matrix[boyRow][boyCol].equals("-")) {
                matrix[boyRow][boyCol] = ".";
            } else if (matrix[boyRow][boyCol].equals("A")) {
                matrix[boyRow][boyCol] = "P";
                System.out.println("Pizza is delivered on time! Next order...");
                break;
            }

            if (command.equals("up")) {
                if (boyRow - 1 >= 0) {
                    if (matrix[boyRow - 1][boyCol].equals("*")) {
                        continue;
                    }
                }
                boyRow -= 1;
            } else if (command.equals("down")) {
                if (boyRow + 1 > matrix.length) {
                    if (matrix[boyRow + 1][boyCol].equals("*")) {
                        continue;
                    }
                }
                boyRow += 1;
            } else if (command.equals("left")) {
                if (boyCol - 1 >= 0) {
                    if (matrix[boyRow][boyCol - 1].equals("*")) {
                        continue;
                    }
                }
                boyCol -= 1;
            } else if (command.equals("right")) {
                if (boyCol + 1 > m) {
                    if (matrix[boyRow][boyCol + 1].equals("*")) {
                        continue;
                    }
                }
                boyCol += 1;
            }

            isLeft = isValidIndex(matrix, boyRow, boyCol);
            command = scanner.nextLine();
        }

        if (isLeft) {
            System.out.println("The delivery is late. Order is canceled.");
            matrix[startRow][startCol] = " ";
        }

        printMatrix(matrix);
    }


    public static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String currentElement : row) {
                System.out.print(currentElement);
            }
            System.out.println();
        }
    }

    public static boolean isValidIndex(String[][] matrix, int boyRow, int boyCol) {
        return boyRow < 0 || boyRow >= matrix.length ||
                boyCol < 0 || boyCol >= matrix[boyRow].length;
    }
}
