import java.util.Scanner;

public class EasterCompetition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfBakes, gradeForBake, sumGrades, maxPoints = Integer.MIN_VALUE;
        String nameOfBaker, command, bestBaker = "";
        numberOfBakes = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfBakes; i++) {
            sumGrades = 0;
            nameOfBaker = scanner.nextLine();
            command = scanner.nextLine();

            while (!command.equals("Stop")){
                gradeForBake = Integer.parseInt(command);
                sumGrades += gradeForBake;
                command = scanner.nextLine();
            }

            System.out.printf("%s has %d points.%n", nameOfBaker, sumGrades);

            if(sumGrades > maxPoints){
                maxPoints = sumGrades;
                bestBaker = nameOfBaker;
                System.out.printf("%s is the new number 1!%n", bestBaker);
            }

        }

        System.out.printf("%s won competition with %d points!", bestBaker, maxPoints);
    }
}
