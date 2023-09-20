import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";

    private static final String WIN = "win";
    private static final String LOSE = "lose";
    private static final String DRAW = "draw";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose [r]ock, [p]aper or [s]cissors: ");
        String playerChoose = scanner.nextLine();
        String result = "";

        int generateNumber = generateNumber();
        String computerChoose = computerChoose(generateNumber);

        if (playerChoose.equals("r") || playerChoose.equals("rock")){
            if (computerChoose.equals(ROCK)){
                result = DRAW;
            }else if (computerChoose.equals(PAPER)){
                result = LOSE;
            }else if (computerChoose.equals(SCISSORS)){
                result = WIN;
            }
        }

        if (playerChoose.equals("p") || playerChoose.equals("paper")){
            if (computerChoose.equals(ROCK)){
                result = WIN;
            }else if (computerChoose.equals(PAPER)){
                result = DRAW;
            }else if (computerChoose.equals(SCISSORS)){
                result = LOSE;
            }
        }

        if (playerChoose.equals("s") || playerChoose.equals("scissors")){
            if (computerChoose.equals(ROCK)){
                result = LOSE;
            }else if (computerChoose.equals(PAPER)){
                result = WIN;
            }else if (computerChoose.equals(SCISSORS)){
                result = DRAW;
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
            computerChoose = ROCK;
        }else if (generateNumber == 2){
            computerChoose = PAPER;
        }else if (generateNumber == 3){
            computerChoose = SCISSORS;
        }

        return computerChoose;
    }

    public static void printResult(String result){

        if (result.equals(WIN)){
            System.out.println("You win.");
        }else if (result.equals(DRAW)){
            System.out.println("This game was a draw.");
        }else if (result.equals(LOSE)){
            System.out.println("You lose.");
        }
    }
}
