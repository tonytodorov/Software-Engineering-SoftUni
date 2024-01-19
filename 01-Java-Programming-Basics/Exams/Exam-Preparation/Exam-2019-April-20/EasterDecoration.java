import java.util.Scanner;

public class EasterDecoration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;
        int numberOfClients, countProducts;
        double sum = 0.00, averageBill = 0.00;
        numberOfClients = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfClients; i++) {
            sum = 0;
            countProducts = 0;
            command = scanner.nextLine();

            while (!command.equals("Finish")){
                switch (command) {
                    case "basket":          sum += 1.50; break;
                    case "wreath":          sum += 3.80; break;
                    case "chocolate bunny": sum += 7.00; break;
                }

                countProducts++;
                command = scanner.nextLine();
            }

            if(countProducts % 2 == 0){
                sum *= 0.8;
            }
            averageBill += sum;
            System.out.printf("You purchased %d items for %.2f leva.%n", countProducts, sum);
        }
        System.out.printf("Average bill per client is: %.2f leva.", averageBill / numberOfClients);
    }
}
