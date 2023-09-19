import java.util.Scanner;

public class FamilyTrip {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget, priceForOneNight, totalPriceForNights, otherMoneys, totalPrice;
        int numberOfNights, percentForAddedExpense;

        budget = Double.parseDouble(scanner.nextLine());
        numberOfNights = Integer.parseInt(scanner.nextLine());
        priceForOneNight = Double.parseDouble(scanner.nextLine());
        percentForAddedExpense = Integer.parseInt(scanner.nextLine());

        if(numberOfNights > 7){
            priceForOneNight *= 0.95;
        }

        totalPriceForNights = numberOfNights * priceForOneNight;
        otherMoneys = (budget * percentForAddedExpense) / 100;
        totalPrice = totalPriceForNights + otherMoneys;

        if(budget >= totalPrice){
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", budget - totalPrice);
        }else{
            System.out.printf("%.2f leva needed.", totalPrice - budget);
        }

    }
}
