import java.util.Scanner;

public class CinemaTickets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfFilm, command, ticketsCommand, typeTicket;
        int freeSeats, totalTickets = 0,
                countStandard, countStudent, countKid, sumTickets,
                standardTickets = 0, studentTickets = 0, kidTickets = 0;


       command = scanner.nextLine();

        while (!command.equals("Finish")){
            nameOfFilm = command;
            freeSeats = Integer.parseInt(scanner.nextLine());

            countStandard = 0;
            countStudent = 0;
            countKid = 0;
            sumTickets = 0;

            ticketsCommand = scanner.nextLine();

            while (!ticketsCommand.equals("End")){
                typeTicket = ticketsCommand;
                sumTickets++;

                switch (typeTicket) {
                    case "standard": countStandard++; break;
                    case "student": countStudent++; break;
                    case "kid": countKid++; break;
                }

                if(sumTickets == freeSeats){
                    break;
                }
                ticketsCommand = scanner.nextLine();
            }

            standardTickets += countStandard;
            studentTickets += countStudent;
            kidTickets += countKid;
            totalTickets += sumTickets;

            System.out.printf("%s - %.2f%% full.%n", nameOfFilm, (double)sumTickets / freeSeats * 100);

            command = scanner.nextLine();
        }

        System.out.printf("Total tickets: %d%n", totalTickets);
        System.out.printf("%.2f%% student tickets.%n", (double)studentTickets / totalTickets * 100);
        System.out.printf("%.2f%% standard tickets.%n", (double)standardTickets / totalTickets * 100);
        System.out.printf("%.2f%% kids tickets.", (double)kidTickets / totalTickets * 100);

    }
}
