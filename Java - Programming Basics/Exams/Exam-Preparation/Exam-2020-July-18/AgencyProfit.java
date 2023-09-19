import java.util.Scanner;

public class AgencyProfit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfAviocompany;
        int numberOfTicketsForOld, numberOfTicketsForKids;
        double priceForTicketForOld, priceForTax, priceForKidsTicket, totalPrice;

        nameOfAviocompany = scanner.nextLine();
        numberOfTicketsForOld = Integer.parseInt(scanner.nextLine());
        numberOfTicketsForKids = Integer.parseInt(scanner.nextLine());
        priceForTicketForOld = Double.parseDouble(scanner.nextLine());
        priceForTax = Double.parseDouble(scanner.nextLine());

        priceForKidsTicket = priceForTicketForOld * 0.3;
        priceForTicketForOld += priceForTax;
        priceForKidsTicket += priceForTax;

        totalPrice = (numberOfTicketsForOld * priceForTicketForOld) + (numberOfTicketsForKids * priceForKidsTicket);
        totalPrice *= 0.2;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", nameOfAviocompany, totalPrice);

    }
}
