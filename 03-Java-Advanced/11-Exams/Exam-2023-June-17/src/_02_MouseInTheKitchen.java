import java.util.Arrays;
import java.util.Scanner;

public class _02_MouseInTheKitchen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine()
                .split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = dim[0];
        int m = dim[1];

        int biggestDim = Math.max(n, m);
        int[] currentPosition = new int[2];

        String[][] matrix = new String[n][m];

        int countCheese = 0;

        for (int i = 0; i < matrix.length; i++) {
            String[] input = scanner.nextLine().split("");

            for (int j = 0; j < input.length; j++) {
                if (input[j].equals("M")) {
                    currentPosition[0] = i;
                    currentPosition[1] = j;
                } else if (input[j].equals("C")) {
                    countCheese += 1;
                }
            }

            matrix[i] = input;
        }

        String command = scanner.nextLine();


        while (!"danger".equals(command)) {

            int[] newPosition = new int[]{currentPosition[0], currentPosition[1]};

            if (command.equals("up")) {
                newPosition[0] = currentPosition[0] - 1;
            } else if (command.equals("down")) {
                newPosition[0] = currentPosition[0] + 1;
            } else if (command.equals("left")) {
                newPosition[1] = currentPosition[1] - 1;
            } else if (command.equals("right")) {
                newPosition[1] = currentPosition[1] + 1;
            }

            if (validIndex(newPosition, biggestDim)) {
                String nextElement = matrix[newPosition[0]][newPosition[1]];

                if (nextElement.equals("C")) {
                    countCheese -= 1;
                    matrix[currentPosition[0]][currentPosition[1]] = "*";
                    matrix[newPosition[0]][newPosition[1]] = "M";

                    if (countCheese == 0) {
                        System.out.println("Happy mouse! All the cheese is eaten, good night!");
                        printMatrix(matrix);
                        return;
                    }
                } else if (nextElement.equals("@")) {
                    command = scanner.nextLine();
                    continue;
                } else if (nextElement.equals("T")) {
                    System.out.println("Mouse is trapped!");
                    matrix[currentPosition[0]][currentPosition[1]] = "*";
                    matrix[newPosition[0]][newPosition[1]] = "M";
                    printMatrix(matrix);
                    return;
                } else if (nextElement.equals("*")) {
                    matrix[currentPosition[0]][currentPosition[1]] = "*";
                    matrix[newPosition[0]][newPosition[1]] = "M";
                }
            } else {
                System.out.println("No more cheese for tonight!");
                printMatrix(matrix);
                return;
            }

            currentPosition = newPosition;
            command = scanner.nextLine();
        }

    }


    public static boolean validIndex(int[] indexes, int n) {
        return indexes[0] >= 0 && indexes[0] < n && indexes[1] >= 0 && indexes[1] < n;
    }

    public static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String currentElement : row) {
                System.out.print(currentElement);
            }
            System.out.println();
        }
    }
}
