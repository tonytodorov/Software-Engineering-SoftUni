import java.util.Scanner;

public class Travelling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination, input;
        double price, savedMoney, sum;

        input = scanner.nextLine();

        while (!input.equals("End")){
            destination = input;
            price = Double.parseDouble(scanner.nextLine());

            sum = 0;
            while (sum < price){
                savedMoney = Double.parseDouble(scanner.nextLine());
                sum += savedMoney;
            }
            System.out.printf("Going to %s!%n", destination);
            input = scanner.nextLine();
        }
    }
}
