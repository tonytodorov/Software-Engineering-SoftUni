import java.util.Scanner;

public class Logistics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTonnage, tons, sum = 0;
        double averageTons;

        numberOfTonnage = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfTonnage; i++) {
            tons = Integer.parseInt(scanner.nextLine());

            if(tons <= 3){
            }
            sum += tons;

        }

    }
}
