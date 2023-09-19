import java.util.Scanner;

public class Balls {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfBalls, countRedBalls = 0, countOrangeBalls = 0,
                countYellowBalls = 0, countWhiteBalls = 0,
                otherColorBalls = 0, countNumbersOfDivides = 0;
        double points = 0.00;
        String ballColor;

        numberOfBalls = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfBalls; i++) {
            ballColor = scanner.nextLine();

            switch (ballColor) {
                case "red":
                    points += 5;
                    countRedBalls++;
                    break;
                case "orange":
                    points += 10;
                    countOrangeBalls++;
                    break;
                case "yellow":
                    points += 15;
                    countYellowBalls++;
                    break;
                case "white":
                    points += 20;
                    countWhiteBalls++;
                    break;
                case "black":
                    points = Math.floor(points / 2);
                    countNumbersOfDivides++;
                    break;
                default:
                    otherColorBalls++;
            }
        }

        System.out.printf("Total points: %.0f%n" +
                "Red balls: %d%n" +
                "Orange balls: %d%n" +
                "Yellow balls: %d%n" +
                "White balls: %d%n" +
                "Other colors picked: %d%n" +
                "Divides from black balls: %d", points, countRedBalls,
                countOrangeBalls, countYellowBalls, countWhiteBalls,
                otherColorBalls, countNumbersOfDivides);
    }
}
