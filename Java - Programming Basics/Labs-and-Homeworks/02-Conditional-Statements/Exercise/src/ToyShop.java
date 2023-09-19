import java.util.Scanner;

public class ToyShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceForHoliday, priceForPuzzles, priceForDolls, priceForBears, priceForMinions, priceForTrucks,
                totalPriceForToys, rentForShop, clearWin;
        int numberOfPuzzles, numberOfDolls, numberOfBears, numberOfMinions, numberOfTrucks, totalNumberOfToys;

        priceForHoliday = Double.parseDouble(scanner.nextLine());
        numberOfPuzzles = Integer.parseInt(scanner.nextLine());
        numberOfDolls = Integer.parseInt(scanner.nextLine());
        numberOfBears = Integer.parseInt(scanner.nextLine());
        numberOfMinions = Integer.parseInt(scanner.nextLine());
        numberOfTrucks = scanner.nextInt();

        totalNumberOfToys = numberOfPuzzles + numberOfDolls + numberOfBears + numberOfMinions + numberOfTrucks;

        priceForPuzzles = numberOfPuzzles * 2.6;
        priceForDolls = numberOfDolls * 3;
        priceForBears = numberOfBears * 4.10;
        priceForMinions = numberOfMinions * 8.20;
        priceForTrucks = numberOfTrucks * 2;

        totalPriceForToys = priceForPuzzles + priceForDolls + priceForBears + priceForMinions + priceForTrucks;

        if(totalNumberOfToys >= 50){
            totalPriceForToys *= 0.75;
        }

        rentForShop = totalPriceForToys * 0.1;

        clearWin = totalPriceForToys - rentForShop;

        if(clearWin >= priceForHoliday){
            System.out.printf("Yes! %.2f lv left.", clearWin - priceForHoliday);
        }else{
            System.out.printf("Not enough money! %.2f lv needed.", Math.abs(clearWin - priceForHoliday));
        }


    }
}
