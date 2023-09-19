import java.util.Scanner;

public class FootballResults {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countWins = 0, countDraws = 0, countLoses = 0;
        String resultM1, resultM2, resultM3;

        resultM1 = scanner.nextLine();
        resultM2 = scanner.nextLine();
        resultM3 = scanner.nextLine();

        String[] partsM1 = resultM1.split(":");
        int num1 = Integer.parseInt(partsM1[0]);
        int num2 = Integer.parseInt(partsM1[1]);

        String[] partsM2 = resultM2.split(":");
        int num3 = Integer.parseInt(partsM2[0]);
        int num4 = Integer.parseInt(partsM2[1]);

        String[] partsM3 = resultM3.split(":");
        int num5 = Integer.parseInt(partsM3[0]);
        int num6 = Integer.parseInt(partsM3[1]);

        if (num1 > num2) {
            countWins++;
        }
        if(num3 > num4){
            countWins++;
        }
        if(num5 > num6){
            countWins++;
        }
        if(num1 < num2) {
            countLoses++;
        }
        if(num3 < num4){
            countLoses++;
        }
        if(num5 < num6){
            countLoses++;
        }
        if(num1 == num2) {
            countDraws++;
        }
        if(num3 == num4) {
            countDraws++;
        }
        if(num5 == num6) {
            countDraws++;
        }

        System.out.printf("Team won %d games.%n" +
                "Team lost %d games.%n" +
                "Drawn games: %d", countWins, countLoses, countDraws);
    }
}
