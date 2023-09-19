import java.util.Scanner;

public class Dishwasher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;
        int numberOfBottles, numberOfDishes, countDishes = 0, countPots = 0, countPlates = 0;
        boolean isBottleFinish = false;
        numberOfBottles = Integer.parseInt(scanner.nextLine());
        numberOfBottles *= 750;

        command = scanner.nextLine();

        while (!command.equals("End")){
            numberOfDishes = Integer.parseInt(command);
            countDishes++;

            if(countDishes % 3 == 0){
                numberOfBottles -= (numberOfDishes * 15);
                countPots += numberOfDishes;
            }else{
                numberOfBottles -= (numberOfDishes * 5);
                countPlates += numberOfDishes;
            }

            if(numberOfBottles < 0){
                isBottleFinish = true;
                break;
            }

            command = scanner.nextLine();
        }

        if (isBottleFinish){
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(numberOfBottles));
        }else{
            System.out.printf("Detergent was enough!%n" +
                    "%d dishes and %d pots were washed.%n" +
                    "Leftover detergent %d ml.",countPlates, countPots, numberOfBottles);
        }
    }
}
