package exam9and10march2019;

import java.util.Scanner;

public class BasketballTournament {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfTournament;
        int numberOfMatches, pointFromDesiTeam, pointFromOpponentTeam,
                countGames, countWins = 0, countLoses = 0, countTotalMatches = 0;

        nameOfTournament = scanner.nextLine();

        while (!nameOfTournament.equals("End of tournaments")){
            numberOfMatches = Integer.parseInt(scanner.nextLine());
            countGames = 0;

            for (int i = 0; i < numberOfMatches; i++) {
                pointFromDesiTeam = Integer.parseInt(scanner.nextLine());
                pointFromOpponentTeam = Integer.parseInt(scanner.nextLine());

                countGames++;

                if(pointFromDesiTeam > pointFromOpponentTeam){
                    countWins++;
                    pointFromDesiTeam -= pointFromOpponentTeam;
                    System.out.printf("Game %d of tournament %s: win with %d points.%n",
                            countGames, nameOfTournament, pointFromDesiTeam);
                }else if(pointFromOpponentTeam > pointFromDesiTeam){
                    countLoses++;
                    pointFromOpponentTeam -= pointFromDesiTeam;
                    System.out.printf("Game %d of tournament %s: lost with %d points.%n",
                            countGames, nameOfTournament, pointFromOpponentTeam);
                }

                countTotalMatches++;
            }


            nameOfTournament = scanner.nextLine();
        }

        System.out.printf("%.2f%% matches win%n", 1.0 * countWins / countTotalMatches * 100);
        System.out.printf("%.2f%% matches lost", 1.0 * countLoses / countTotalMatches * 100);

    }
}
