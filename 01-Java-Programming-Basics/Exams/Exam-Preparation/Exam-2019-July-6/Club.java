import java.util.Scanner;

public class Club {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String command;
        int numberOfCharacters, numberOfCocktails;
        double neededWin, sum = 0.00, totalWin = 0.00;
        boolean isTargetReached = false;

        neededWin = Double.parseDouble(scanner.nextLine());
        command = scanner.nextLine();

        while (!command.equals("Party!")){
            numberOfCharacters = command.length();
            numberOfCocktails = Integer.parseInt(scanner.nextLine());

            sum = numberOfCharacters * numberOfCocktails;

            if(sum % 2 == 0){
                sum = sum;
            }else{
                sum *= 0.75;
            }

            totalWin += sum;

            if(totalWin >= neededWin){
                isTargetReached = true;
                break;
            }


            command = scanner.nextLine();
        }

        if(isTargetReached){
            System.out.printf("Target acquired.%nClub income - %.2f leva.", totalWin);
        }else{
            System.out.printf("We need %.2f leva more.%nClub income - %.2f leva.", neededWin - totalWin, totalWin);
        }



    }
}
