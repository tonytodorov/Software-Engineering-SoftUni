import java.util.Arrays;
import java.util.Scanner;

public class _09_ParkingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = dimensions[0];
        int col = dimensions[1];

        String[][] parking = new String[row][col];

        for (String[] currentRow : parking) {
            Arrays.fill(currentRow, "X");
        }

        String command = scanner.nextLine();

        while (!command.equals("stop")) {

            String[] tokens = command.split(" ");

            int startRow = Integer.parseInt(tokens[0]);
            int parkingRow = Integer.parseInt(tokens[1]);
            int parkingCol = Integer.parseInt(tokens[2]);

            int steps = 1;
            boolean isParking = false;
            boolean isNotFoundParking = false;

            while (startRow != parkingRow) {
                if (startRow > parkingRow) {
                    startRow -= 1;
                } else {
                    startRow += 1;
                }

                steps += 1;
            }

            if (parking[parkingRow][parkingCol].equals("X")) {
                parking[parkingRow][parkingCol] = "P";
                steps += countSteps(parkingCol);
                isParking = true;
            } else {
                for (int currentCol = 1; currentCol < parkingCol; currentCol++) {
                    if (parking[parkingRow][currentCol].equals("X")) {
                        parking[parkingRow][currentCol] = "P";
                        steps += countSteps(currentCol);
                        isParking = true;
                        break;
                    }
                }

                if (!isParking) {
                    isNotFoundParking = true;
                }
            }

            if (isNotFoundParking) {
                for (int currentCol = parkingCol; currentCol < col; currentCol++) {
                    if (parking[parkingRow][currentCol].equals("X")) {
                        parking[parkingRow][currentCol] = "P";
                        steps += countSteps(currentCol);
                        isParking = true;
                        break;
                    }
                }
            }

            if (isParking) {
                System.out.println(steps);
            } else {
                System.out.printf("Row %d full%n", parkingRow);
            }

            command = scanner.nextLine();
        }
    }

    public static int countSteps(int parkingCol) {

        int steps = 0;

        for (int i = 0; i < parkingCol; i++) {
            steps += 1;
        }

        return steps;
    }
}
