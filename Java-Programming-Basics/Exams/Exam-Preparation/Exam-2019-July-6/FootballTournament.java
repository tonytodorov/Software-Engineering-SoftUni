import java.util.Scanner;

public class FootballTournament {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfFootballTeam, endOfMatch;
        int numberOfMatches, totalMatches, totalPoints = 0, numberOfWins = 0, numberOfDraws = 0, numberOfLoses = 0;
        double winRate;
        nameOfFootballTeam = scanner.nextLine();
        numberOfMatches = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfMatches; i++) {
            endOfMatch = scanner.nextLine();
            switch (endOfMatch) {
                case "W":
                    totalPoints += 3;
                    numberOfWins++;
                    break;
                case "D":
                    totalPoints += 1;
                    numberOfDraws++;
                    break;
                case "L":
                    numberOfLoses++;
                    break;
            }
        }

        totalMatches = numberOfWins + numberOfDraws + numberOfLoses;
        winRate = (double)numberOfWins / totalMatches * 100;

        if(numberOfMatches == 0){
            System.out.printf("%s hasn't played any games during this season.", nameOfFootballTeam);
        }else{
            System.out.printf("%s has won %d points during this season.%nTotal stats:%n## W: %d%n## D: %d%n## L: %d%nWin rate: %.2f%%",
                    nameOfFootballTeam, totalPoints, numberOfWins, numberOfDraws, numberOfLoses, winRate);
        }







    }
}
