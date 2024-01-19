import java.util.Scanner;

public class Safari {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget, neededGas;
        String dayOfWeek;
        budget = Double.parseDouble(scanner.nextLine());
        neededGas = Double.parseDouble(scanner.nextLine());
        dayOfWeek = scanner.nextLine();

        if(dayOfWeek.equals("Saturday")){
            neededGas = ((neededGas * 2.10) + 100) * 0.9;
        }else{
            neededGas = ((neededGas * 2.10) + 100) * 0.8;
        }

        if(budget > neededGas){
            System.out.printf("Safari time! Money left: %.2f lv.", budget - neededGas);
        }else{
            System.out.printf("Not enough money! Money needed: %.2f lv.", neededGas - budget);
        }
    }
}
