import java.util.Scanner;

public class OscarWeekInCinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfFilm, typeOfHall;
        int numberOfTickets;
        double price = 0.00;

        nameOfFilm = scanner.nextLine();
        typeOfHall = scanner.nextLine();
        numberOfTickets = Integer.parseInt(scanner.nextLine());

        if(typeOfHall.equals("normal")){
            switch (nameOfFilm) {
                case "A Star Is Born":
                    price = numberOfTickets * 7.5;
                    break;
                case "Bohemian Rhapsody":
                    price = numberOfTickets * 7.35;
                    break;
                case "Green Book":
                    price = numberOfTickets * 8.15;
                    break;
                case "The Favourite":
                    price = numberOfTickets * 8.75;
                    break;
            }
        }

        if(typeOfHall.equals("luxury")){
            switch (nameOfFilm) {
                case "A Star Is Born":
                    price = numberOfTickets * 10.5;
                    break;
                case "Bohemian Rhapsody":
                    price = numberOfTickets * 9.45;
                    break;
                case "Green Book":
                    price = numberOfTickets * 10.25;
                    break;
                case "The Favourite":
                    price = numberOfTickets * 11.55;
                    break;
            }
        }

        if(typeOfHall.equals("ultra luxury")){
            switch (nameOfFilm) {
                case "A Star Is Born":
                    price = numberOfTickets * 13.5;
                    break;
                case "Bohemian Rhapsody":
                    price = numberOfTickets * 12.75;
                    break;
                case "Green Book":
                    price = numberOfTickets * 13.25;
                    break;
                case "The Favourite":
                    price = numberOfTickets * 13.95;
                    break;
            }
        }


        System.out.printf("%s -> %.2f lv.", nameOfFilm, price);

    }
}
