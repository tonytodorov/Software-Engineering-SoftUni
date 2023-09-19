import java.util.Scanner;

public class EasterTrip {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination, dateOfReservation;
        int numberOfNights;
        double price = 0.00;

        destination = scanner.nextLine();
        dateOfReservation = scanner.nextLine();
        numberOfNights = Integer.parseInt(scanner.nextLine());

        if(dateOfReservation.equals("21-23")){
            switch (destination) {
                case "France":  price = numberOfNights * 30; break;
                case "Italy":   price = numberOfNights * 28; break;
                case "Germany": price = numberOfNights * 32; break;
            }
        }

        if(dateOfReservation.equals("24-27")){
            switch (destination) {
                case "France":  price = numberOfNights * 35; break;
                case "Italy":   price = numberOfNights * 32; break;
                case "Germany": price = numberOfNights * 37; break;
            }
        }

        if(dateOfReservation.equals("28-31")){
            switch (destination) {
                case "France":  price = numberOfNights * 40; break;
                case "Italy":   price = numberOfNights * 39; break;
                case "Germany": price = numberOfNights * 43; break;
            }
        }

        System.out.printf("Easter trip to %s : %.2f leva.", destination, price);

    }
}
