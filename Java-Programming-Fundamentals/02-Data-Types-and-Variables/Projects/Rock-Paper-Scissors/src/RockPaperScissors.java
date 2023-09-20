import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    private static final String rock = "Rock";
    private static final String paper = "Paper";
    private static final String scissors = "Scissors";

    private static final String win = "win";
    private static final String lose = "lose";
    private static final String draw = "draw";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose [r]ock, [p]aper or [s]cissors: ");
        String playerChoose = scanner.nextLine();
        String result = "";

        int generateNumber = generateNumber();
        String computerChoose = computerChoose(generateNumber);

        if (playerChoose.equals("r") || playerChoose.equals("rock")){
            if (computerChoose.equals(rock)){
                result = draw;
            }else if (computerChoose.equals(paper)){
                result = lose;
            }else if (computerChoose.equals(scissors)){
                result = win;
            }
        }

        if (playerChoose.equals("p") || playerChoose.equals("paper")){
            if (computerChoose.equals(rock)){
                result = win;
            }else if (computerChoose.equals(paper)){
                result = draw;
            }else if (computerChoose.equals(scissors)){
                result = lose;
            }
        }

        if (playerChoose.equals("s") || playerChoose.equals("scissors")){
            if (computerChoose.equals(rock)){
                result = lose;
            }else if (computerChoose.equals(paper)){
                result = win;
            }else if (computerChoose.equals(scissors)){
                result = draw;
            }
        }

        System.out.printf("The computer chose %s.%n", computerChoose);
        printResult(result);
        
    }

    public static int generateNumber(){

        int lowerBound = 1, upperBound = 4;
        Random random = new Random();
        return random.nextInt(upperBound - lowerBound) + lowerBound;
    }

    public static String computerChoose(int generateNumber){

        String computerChoose = "";

        if (generateNumber == 1){
            computerChoose = rock;
        }else if (generateNumber == 2){
            computerChoose = paper;
        }else if (generateNumber == 3){
            computerChoose = scissors;
        }

        return computerChoose;
    }

    public static void printResult(String result){

        if (result.equals(win)){
            System.out.println("You win.");
        }else if (result.equals(draw)){
            System.out.println("This game was a draw.");
        }else if (result.equals(lose)){
            System.out.println("You lose.");
        }
    }
}
