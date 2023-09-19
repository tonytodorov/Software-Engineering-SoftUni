import java.util.Scanner;

public class EasterParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfGuests;
        double priceForCouvertForOnePerson ,budget, priceForCake, totalPrice;

        numberOfGuests = Integer.parseInt(scanner.nextLine());
        priceForCouvertForOnePerson = Double.parseDouble(scanner.nextLine());
        budget = Double.parseDouble(scanner.nextLine());

        if(numberOfGuests >= 10 && numberOfGuests <= 15) {
            priceForCouvertForOnePerson *= 0.85;
        }else if(numberOfGuests > 15 && numberOfGuests <= 20) {
            priceForCouvertForOnePerson *= 0.80;
        }else if (numberOfGuests > 20){
            priceForCouvertForOnePerson *= 0.75;
        }

        priceForCake = budget * 0.1;
        totalPrice = (numberOfGuests * priceForCouvertForOnePerson) + priceForCake;

        if(totalPrice > budget){
            System.out.printf("No party! %.2f leva needed.", totalPrice - budget);
        }else{
            System.out.printf("It is party time! %.2f leva left.", budget - totalPrice);
        }
    }
}
