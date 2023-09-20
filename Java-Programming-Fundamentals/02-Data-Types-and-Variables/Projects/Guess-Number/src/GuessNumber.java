import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int generateNumber = generateNumber();
        System.out.print("Guess a number (1-100): ");
        int playerChoose = Integer.parseInt(scanner.nextLine());

        while (playerChoose != generateNumber){

            if (playerChoose < generateNumber){
                System.out.println("Too low");
            } else {
                System.out.println("Too high");
            }

            System.out.print("Guess a number (1-100): ");
            playerChoose = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("You guessed it!");
    }

    public static int generateNumber(){

        int lowerBound = 1, upperBound = 100;
        Random random = new Random();
        return random.nextInt(upperBound - lowerBound) + lowerBound;
    }
}
