import java.util.Scanner;

public class MovieProfit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfFilm;
        int numberOfDays, numberOfTickets, percentForCinema;
        double priceForOneTicket, totalPriceForTickets, totalIncome, moneyForCinema, totalMoney;

        nameOfFilm = scanner.nextLine();
        numberOfDays = Integer.parseInt(scanner.nextLine());
        numberOfTickets = Integer.parseInt(scanner.nextLine());
        priceForOneTicket = Double.parseDouble(scanner.nextLine());
        percentForCinema = Integer.parseInt(scanner.nextLine());

        totalPriceForTickets = numberOfTickets * priceForOneTicket;
        totalIncome = numberOfDays * totalPriceForTickets;
        moneyForCinema = totalIncome * percentForCinema / 100;

        totalMoney = totalIncome - moneyForCinema;

        System.out.printf("The profit from the movie %s is %.2f lv.", nameOfFilm, totalMoney);

    }
}
