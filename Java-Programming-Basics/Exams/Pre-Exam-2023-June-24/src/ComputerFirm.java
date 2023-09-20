import java.util.Scanner;

public class ComputerFirm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfComputers, numberForSellAndRating, firstDigits, lastDigit, rating = 0;
        double numberOfSells = 0.00, totalSells = 0.00, averageSales;
        numberOfComputers = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfComputers; i++) {
            numberForSellAndRating = Integer.parseInt(scanner.nextLine());

            lastDigit = numberForSellAndRating % 10;
            firstDigits = numberForSellAndRating / 10;

            if(lastDigit == 2){
                numberOfSells = 0;
            }else if(lastDigit == 3){
                numberOfSells = firstDigits * 0.5;
            }else if(lastDigit == 4){
                numberOfSells = firstDigits * 0.7;
            }else if(lastDigit == 5){
                numberOfSells = firstDigits * 0.85;
            }else if(lastDigit == 6){
                numberOfSells = firstDigits;
            }

            rating += lastDigit;
            totalSells += numberOfSells;
        }

        averageSales = 1.0 * rating / numberOfComputers;
        System.out.printf("%.2f%n%.2f", totalSells, averageSales);
    }
}
