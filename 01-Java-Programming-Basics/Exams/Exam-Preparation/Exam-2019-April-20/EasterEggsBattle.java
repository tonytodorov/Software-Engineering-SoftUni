import java.util.Scanner;

public class EasterEggsBattle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEggsForFirstPlayer, numberOfEggsForSecondPlayer;
        String command;
        boolean isFirstPlayerLose = false;
        boolean isSecondPlayerLose = false;

        numberOfEggsForFirstPlayer = Integer.parseInt(scanner.nextLine());
        numberOfEggsForSecondPlayer = Integer.parseInt(scanner.nextLine());

        command = scanner.nextLine();

        while (!command.equals("End")){

            if(command.equals("one")){
                numberOfEggsForSecondPlayer--;
            }
            if(command.equals("two")){
                numberOfEggsForFirstPlayer--;
            }

            if(numberOfEggsForFirstPlayer <= 0){
                isFirstPlayerLose = true;
                break;
            }

            if(numberOfEggsForSecondPlayer <= 0){
                isSecondPlayerLose = true;
                break;
            }

            command = scanner.nextLine();
        }

        if(isFirstPlayerLose){
            System.out.printf("Player one is out of eggs. Player two has %d eggs left.", numberOfEggsForSecondPlayer);
        }else if(isSecondPlayerLose){
            System.out.printf("Player two is out of eggs. Player one has %d eggs left.", numberOfEggsForFirstPlayer);
        }else{
            System.out.printf("Player one has %d eggs left.%n" +
                    "Player two has %d eggs left.", numberOfEggsForFirstPlayer, numberOfEggsForSecondPlayer);
        }
    }
}
