import java.util.Scanner;

public class FilmPremiere {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String film, packetForFilm;
        int numberOfTickets;
        double price = 0.00;

        film = scanner.nextLine();
        packetForFilm = scanner.nextLine();
        numberOfTickets = Integer.parseInt(scanner.nextLine());

        if(film.equals("John Wick")){
            switch (packetForFilm) {
                case "Drink":
                    price = numberOfTickets * 12;
                    break;
                case "Popcorn":
                    price = numberOfTickets * 15;
                    break;
                case "Menu":
                    price = numberOfTickets * 19;
                    break;
            }
        }


        if(film.equals("Star Wars")){
            switch (packetForFilm) {
                case "Drink":
                    price = numberOfTickets * 18;
                    break;
                case "Popcorn":
                    price = numberOfTickets * 25;
                    break;
                case "Menu":
                    price = numberOfTickets * 30;
                    break;
            }
            if(numberOfTickets >= 4){
                price *= 0.7;
            }

        }


        if(film.equals("Jumanji")){
            switch (packetForFilm) {
                case "Drink":
                    price = numberOfTickets * 9;
                    break;
                case "Popcorn":
                    price = numberOfTickets * 11;
                    break;
                case "Menu":
                    price = numberOfTickets * 14;
                    break;
            }
            if(numberOfTickets == 2){
                price *= 0.85;
            }
        }
        System.out.printf("Your bill is %.2f leva.", price);
    }
}
