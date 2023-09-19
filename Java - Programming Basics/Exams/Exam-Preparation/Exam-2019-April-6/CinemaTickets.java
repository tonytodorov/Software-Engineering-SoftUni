import java.util.Scanner;

public class CinemaTickets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfFilm, command;
        int freeSeats, totalSeats, totalTickets = 0,
                countStandard, countStudent, countKid, sumTickets,
                standardTickets = 0, studentTickets = 0, kidTickets = 0;

        nameOfFilm = scanner.nextLine();

        while (!nameOfFilm.equals("Finish")){
            countStandard = 0;
            countStudent = 0;
            countKid = 0;
            sumTickets = 0;
            freeSeats = Integer.parseInt(scanner.nextLine());
            totalSeats = freeSeats;
            command = scanner.nextLine();

            while (!command.equals("End") && !command.equals("Finish") && freeSeats > 0){

                switch (command) {
                    case "standard": countStandard++; break;
                    case "student": countStudent++; break;
                    case "kid": countKid++; break;
                }

                freeSeats--;

                sumTickets = countStandard + countStudent + countKid;
                command = scanner.nextLine();
            }

            standardTickets += countStandard;
            studentTickets += countStudent;
            kidTickets += countKid;
            totalTickets += sumTickets;

            System.out.printf("%s - %.2f%% full.%n", nameOfFilm, (double)sumTickets / totalSeats * 100);

            if(command.equals("Finish")){
                break;
            }
            nameOfFilm = scanner.nextLine();
        }

        System.out.printf("Total tickets: %d%n", totalTickets);
        System.out.printf("%.2f%% student tickets.%n", (double)studentTickets / totalTickets * 100);
        System.out.printf("%.2f%% standard tickets.%n", (double)standardTickets / totalTickets * 100);
        System.out.printf("%.2f%% kids tickets.", (double)kidTickets / totalTickets * 100);

    }
}
