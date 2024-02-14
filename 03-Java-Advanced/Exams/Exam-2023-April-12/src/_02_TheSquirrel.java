import java.util.Scanner;

public class _02_TheSquirrel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int totalHazelnut = 0;

        String[][] matrix = new String[n][];

        String[] commands = scanner.nextLine().split(",\\s+");

        int startRow = -1;
        int startCol = -1;

        for (int i = 0; i < matrix.length; i++) {
            String[] data = scanner.nextLine().split("");

            for (int j = 0; j < data.length; j++) {
                if (data[j].equals("s")) {
                    startRow = i;
                    startCol = j;
                }
            }

            matrix[i] = data;
        }

        boolean isTrap = false;
        boolean isOutOfField = false;

        for (String currentCommand : commands) {

            if (currentCommand.equals("up")) {
                startRow -= 1;
            } else if (currentCommand.equals("down")) {
                startRow += 1;
            } else if (currentCommand.equals("left")) {
                startCol -= 1;
            } else if (currentCommand.equals("right")) {
                startCol += 1;
            }

            boolean isValidIndex = isValidIndex(matrix, startRow, startCol);

            if (isValidIndex) {
                if (matrix[startRow][startCol].equals("t")) {
                    isTrap = true;
                    System.out.println("Unfortunately, the squirrel stepped on a trap...");
                    break;
                } else if (matrix[startRow][startCol].equals("h")) {
                    totalHazelnut += 1;
                    if (totalHazelnut == 3) {
                        System.out.println("Good job! You have collected all hazelnuts!");
                        break;
                    }
                }
            } else {
                System.out.println("The squirrel is out of the field.");
                isOutOfField = true;
                break;
            }

        }

        if (totalHazelnut != 3 && !isOutOfField && !isTrap) {
            System.out.println("There are more hazelnuts to collect.");
        }

        System.out.printf("Hazelnuts collected: %d", totalHazelnut);
    }

    public static boolean isValidIndex(String[][] matrix, int startRow, int startCol) {
        return startRow >= 0 && startRow < matrix.length &&
                startCol >= 0 && startCol < matrix.length;
    }
}
