import java.util.Scanner;

public class GameNumberWars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfFirstPlayer, nameOfSecondPlayer, command, winner = "";
        int firsPlayerCard, secondPlayerCard,
                pointsForFirstPlayer = 0, pointsForSecondPlayer = 0,
                sumFirstPlayerPoints = 0, sumSecondPlayerPoints = 0,
                pointsOfWinner = 0;
        nameOfFirstPlayer = scanner.nextLine();
        nameOfSecondPlayer = scanner.nextLine();
        boolean isFirstPlayerWinner = false;
        boolean isSecondPlayerWinner = false;

        command = scanner.nextLine();

        while (!command.equals("End of game")){
            firsPlayerCard = Integer.parseInt(command);
            secondPlayerCard = Integer.parseInt(scanner.nextLine());

            if(firsPlayerCard > secondPlayerCard){
                pointsForFirstPlayer = firsPlayerCard - secondPlayerCard;
                sumFirstPlayerPoints += pointsForFirstPlayer;
            }
            if(secondPlayerCard > firsPlayerCard){
                pointsForSecondPlayer = secondPlayerCard - firsPlayerCard;
                sumSecondPlayerPoints += pointsForSecondPlayer;
            }

            if(secondPlayerCard == firsPlayerCard) {
                firsPlayerCard = Integer.parseInt(scanner.nextLine());
                secondPlayerCard = Integer.parseInt(scanner.nextLine());

                if(firsPlayerCard > secondPlayerCard){
                    winner = nameOfFirstPlayer;
                    pointsOfWinner = sumFirstPlayerPoints;
                    isFirstPlayerWinner = true;
                    break;
                }

                if(secondPlayerCard > firsPlayerCard){
                    winner = nameOfSecondPlayer;
                    pointsOfWinner = sumSecondPlayerPoints;
                    isSecondPlayerWinner = true;
                    break;
                }

            }
            command = scanner.nextLine();
        }

        if(isFirstPlayerWinner || isSecondPlayerWinner){
            System.out.printf("Number wars!%n%s is winner with %d points", winner, pointsOfWinner);
        }else{
            System.out.printf("%s has %d points%n%s has %d points",
                    nameOfFirstPlayer, sumFirstPlayerPoints,
                    nameOfSecondPlayer, sumSecondPlayerPoints);
        }
    }
}
