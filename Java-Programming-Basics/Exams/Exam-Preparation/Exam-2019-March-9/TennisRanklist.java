import java.util.Scanner;

public class TennisRanklist {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTournaments, startingPoints, countFinal = 0, countSemiFinal = 0;
        double averagePoints, percentOfWinningTournaments, countWin = 0;
        String stageOfTournament;

        numberOfTournaments = Integer.parseInt(scanner.nextLine());
        startingPoints = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfTournaments; i++) {
            stageOfTournament = scanner.nextLine();

            if(stageOfTournament.equals("W")){
                startingPoints += 2000;
                countWin++;
            }else if(stageOfTournament.equals("F")){
                startingPoints += 1200;
                countFinal++;
            }else{
                startingPoints += 720;
                countSemiFinal++;
            }
        }

        averagePoints = Math.floor(((countWin * 2000) +  (countFinal * 1200) + (countSemiFinal * 720))) / numberOfTournaments;
        percentOfWinningTournaments = (countWin / numberOfTournaments) * 100;
        System.out.printf("Final points: %d\nAverage points: %.0f\n%.2f%%", startingPoints,
                Math.floor(averagePoints),
                percentOfWinningTournaments);


    }
}