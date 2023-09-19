import java.util.Scanner;

public class MovieStars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;
        int countChar;
        double budget;
        budget = Double.parseDouble(scanner.nextLine());
        boolean isBudgetFinish = false;

        command = scanner.nextLine();

        while (!command.equals("ACTION")){
            countChar = command.length();
            if(countChar > 15){
                budget *= 0.8;
            }else {
                budget -= Double.parseDouble(scanner.nextLine());
            }
            if(budget < 0){
                isBudgetFinish = true;
                break;
            }

            command = scanner.nextLine();

        }

        if(isBudgetFinish){
            System.out.printf("We need %.2f leva for our actors.", Math.abs(budget));
        }else{
            System.out.printf("We are left with %.2f leva.", budget);
        }
    }
}
