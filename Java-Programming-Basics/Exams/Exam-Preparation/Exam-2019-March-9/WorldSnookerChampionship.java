import java.util.Scanner;

public class WorldSnookerChampionship {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stageOfChampionship, typeOfTicket, photoWithTrophy;
        int numberOfTickets;
        double price = 0.00;

        stageOfChampionship = scanner.nextLine();
        typeOfTicket = scanner.nextLine();
        numberOfTickets = Integer.parseInt(scanner.nextLine());
        photoWithTrophy = scanner.nextLine();

        if(stageOfChampionship.equals("Quarter final")){
            switch (typeOfTicket) {
                case "Standard":
                    price = numberOfTickets * 55.50;
                    break;
                case "Premium":
                    price = numberOfTickets * 105.20;
                    break;
                case "VIP":
                    price = numberOfTickets * 118.90;
                    break;
            }
        }

        if(stageOfChampionship.equals("Semi final")){
            switch (typeOfTicket) {
                case "Standard":
                    price = numberOfTickets * 75.88;
                    break;
                case "Premium":
                    price = numberOfTickets * 125.22;
                    break;
                case "VIP":
                    price = numberOfTickets * 300.40;
                    break;
            }
        }

        if(stageOfChampionship.equals("Final")){
            switch (typeOfTicket) {
                case "Standard":
                    price = numberOfTickets * 110.10;
                    break;
                case "Premium":
                    price = numberOfTickets * 160.66;
                    break;
                case "VIP":
                    price = numberOfTickets * 400;
                    break;
            }
        }


        if(price > 4000 && photoWithTrophy.equals("Y")){
            price *= 0.75;
        }else if(price > 4000 && photoWithTrophy.equals("N")){
            price *= 0.75;
            price += numberOfTickets * 40;
        }else if(price > 2500){
            price *= 0.9;
            price += numberOfTickets * 40;
        }

        System.out.printf("%.2f", price);
    }
}
