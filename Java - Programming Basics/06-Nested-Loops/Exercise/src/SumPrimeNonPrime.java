import java.util.Scanner;

public class SumPrimeNonPrime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number, dividesCount, sumPrimeNumbers = 0, sumNonPrimeNumbers = 0;
        String command;

        command = scanner.nextLine();

        while (!command.equals("stop")){
            number = Integer.parseInt(command);
            dividesCount = 0;

            if(number < 0){
                System.out.println("Number is negative.");
                command = scanner.nextLine();
                continue;
            }

            for (int i = 1; i <= number; i++) {
                if(number % i == 0){
                    dividesCount++;
                }
            }
            if (dividesCount > 2){
                sumNonPrimeNumbers += number;
            }else{
                sumPrimeNumbers += number;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Sum of all prime numbers is: %d%n" +
                "Sum of all non prime numbers is: %d%n",
                sumPrimeNumbers, sumNonPrimeNumbers);
    }
}
