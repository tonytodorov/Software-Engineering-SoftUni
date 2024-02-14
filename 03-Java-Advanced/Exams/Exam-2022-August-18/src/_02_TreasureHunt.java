import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_TreasureHunt {

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
                if (input[j].equals("Y")) {
                    startRow = i;
                    startCol = j;
                }
            }

            matrix[i] = input;
        }

        String command = scanner.nextLine();

        List<String> direction = new ArrayList<>();
        boolean isFinish = false;

        while (!command.equals("Finish")) {

            int currentRow = startRow;
            int currentCol = startCol;

            if (command.equals("up")) {
                currentRow -= 1;
            } else if (command.equals("down")) {
                currentRow += 1;
            } else if (command.equals("right")) {
                currentCol += 1;
            } else if (command.equals("left")) {
                currentCol -= 1;
            }

            if (isOutOfField(matrix, currentRow, currentCol)) {
                command = scanner.nextLine();
                continue;
            } else if (matrix[currentRow][currentCol].equals("X")) {
                direction.add(command);
                isFinish = true;
                break;
            } else if (matrix[currentRow][currentCol].equals("-")) {
                matrix[startRow][startCol] = "-";
                matrix[currentRow][currentCol] = "Y";
                startRow = currentRow;
                startCol = currentCol;
                direction.add(command);
            }

            command = scanner.nextLine();
        }

        if (isFinish) {
            System.out.printf("I've found the treasure!%nThe right path is %s",
                    direction.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(", ")));
        } else {
            System.out.println("The map is fake!");
        }

    }
    
    
    public static boolean isOutOfField(String[][] matrix, int startRow, int startCol) {
        return startRow < 0 || startRow >= matrix.length ||
                startCol < 0 || startCol >= matrix[startRow].length;
    }
}
