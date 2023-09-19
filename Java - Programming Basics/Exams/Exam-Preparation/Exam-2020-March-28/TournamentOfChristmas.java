import java.util.Scanner;

public class TournamentOfChristmas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfDays, countWins = 0, countLoses = 0, totalWins = 0, totalLoses = 0;
        String sport, winOrLose;
        double money, totalMoney = 0.00;

        numberOfDays = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfDays; i++) {
            money = 0.00;
            countWins = 0;
            countLoses = 0;
            sport = scanner.nextLine();

            while (!sport.equals("Finish")){
                winOrLose = scanner.nextLine();

                if(winOrLose.equals("win")){
                    countWins++;
                    money += 20;
                }else{
                    countLoses++;
                }

                sport = scanner.nextLine();
            }

            if(countWins > countLoses){
                money *= 1.10;
            }
            totalMoney += money;
            totalWins += countWins;
            totalLoses += countLoses;
        }

        if(totalWins > totalLoses){
            totalMoney *= 1.20;
            System.out.printf("You won the tournament! Total raised money: %.2f", totalMoney);
        }else{
            System.out.printf("You lost the tournament! Total raised money: %.2f", totalMoney);
        }

    }
}
