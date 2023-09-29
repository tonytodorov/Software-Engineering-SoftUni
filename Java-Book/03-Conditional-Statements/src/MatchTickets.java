import java.util.Scanner;

public class MatchTickets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget, moneyForTransport, priceForTicket, totalPrice;
        String typeOfTicket;
        int numberOfPeople;

        budget = Double.parseDouble(scanner.nextLine());
        typeOfTicket = scanner.nextLine();
        numberOfPeople = Integer.parseInt(scanner.nextLine());

        if(numberOfPeople <= 4){
            moneyForTransport = budget * 0.75;
        }else if(numberOfPeople <= 9){
            moneyForTransport = budget * 0.60;
        }else if(numberOfPeople <= 24){
            moneyForTransport = budget * 0.5;
        }else if(numberOfPeople <= 49){
            moneyForTransport = budget * 0.40;
        }else{
            moneyForTransport = budget * 0.25;
        }

        if(typeOfTicket.equals("VIP")){
            priceForTicket = numberOfPeople * 499.99;
        }else{
            priceForTicket = numberOfPeople * 249.99;
        }

        totalPrice = moneyForTransport + priceForTicket;

        if(budget >= totalPrice){
            System.out.printf("Yes! You have %.2f leva left.", budget - totalPrice);
        }else{
            System.out.printf("Not enough money! You need %.2f leva.", totalPrice - budget);
        }

    }
}
