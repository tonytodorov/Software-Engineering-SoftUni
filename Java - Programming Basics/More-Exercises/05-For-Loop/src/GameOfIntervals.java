import java.util.Scanner;

public class GameOfIntervals {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTurns, number, countInvalidNumbers = 0, countNumberFrom0To9 = 0,
                countNumberFrom10To19 = 0, countNumberFrom20To29 = 0,
                countNumberFrom30To39 = 0, countNumberFrom40To50 = 0;
        double startingPoints = 0.00;
        numberOfTurns = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfTurns; i++) {
            number = Integer.parseInt(scanner.nextLine());

            if(number < 0){
                startingPoints /= 2;
                countInvalidNumbers++;
            }else if(number <= 9){
                startingPoints = (number * 0.2) + startingPoints;
                countNumberFrom0To9++;
            }else if(number <= 19){
                startingPoints = (number * 0.3) + startingPoints;
                countNumberFrom10To19++;
            }else if(number <= 29){
                startingPoints = (number * 0.4) + startingPoints;
                countNumberFrom20To29++;
            }else if(number <= 39){
                startingPoints += 50;
                countNumberFrom30To39++;
            }else if(number <= 50){
                startingPoints += 100;
                countNumberFrom40To50++;
            }else{
                startingPoints /= 2;
                countInvalidNumbers++;
            }
        }

        System.out.printf("%.2f%n", startingPoints);
        System.out.printf("From 0 to 9: %.2f%%%n",      1.0 * countNumberFrom0To9 / numberOfTurns * 100);
        System.out.printf("From 10 to 19: %.2f%%%n",    1.0 * countNumberFrom10To19 / numberOfTurns * 100);
        System.out.printf("From 20 to 29: %.2f%%%n",    1.0 * countNumberFrom20To29 / numberOfTurns * 100);
        System.out.printf("From 30 to 39: %.2f%%%n",    1.0 * countNumberFrom30To39 / numberOfTurns * 100);
        System.out.printf("From 40 to 50: %.2f%%%n",    1.0 * countNumberFrom40To50 / numberOfTurns * 100);
        System.out.printf("Invalid numbers: %.2f%%",  1.0 * countInvalidNumbers / numberOfTurns * 100);


    }
}
