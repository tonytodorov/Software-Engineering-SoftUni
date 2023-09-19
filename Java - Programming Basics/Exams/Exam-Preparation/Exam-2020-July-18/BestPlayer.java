import java.util.Scanner;

public class BestPlayer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfGoals = 0, maxGoals = Integer.MIN_VALUE;
        String nameOfPlayer, bestPlayerName = "";
        boolean isScored10Goals = false;
        nameOfPlayer = scanner.nextLine();

        while (!nameOfPlayer.equals("END")){
            numberOfGoals = Integer.parseInt(scanner.nextLine());

            if(numberOfGoals > maxGoals){
                maxGoals = numberOfGoals;
                bestPlayerName = nameOfPlayer;
            }

            if(numberOfGoals >= 10){
                isScored10Goals = true;
                break;
            }

            nameOfPlayer = scanner.nextLine();
        }

        System.out.printf("%s is the best player!%n", bestPlayerName);

        if(isScored10Goals || numberOfGoals >= 3){
            System.out.printf("He has scored %d goals and made a hat-trick !!!", numberOfGoals);
        }else{
            System.out.printf("He has scored %d goals.", numberOfGoals);
        }
    }
}
