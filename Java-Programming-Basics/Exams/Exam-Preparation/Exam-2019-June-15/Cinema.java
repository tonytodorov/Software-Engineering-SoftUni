import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;
        int capacityOfHall, numberOfPeople, sum = 0, countNumberOfSeats = 0;
        boolean isCinemaFull = false;
        capacityOfHall = Integer.parseInt(scanner.nextLine());
        command = scanner.nextLine();

        while (!command.equals("Movie time!")){
            numberOfPeople = Integer.parseInt(command);

            countNumberOfSeats += numberOfPeople;

            if(countNumberOfSeats > capacityOfHall){
                isCinemaFull = true;
                break;
            }

            sum += numberOfPeople * 5;

            if(numberOfPeople % 3 == 0){
                sum -= 5;
            }

            command = scanner.nextLine();
        }

        if(isCinemaFull){
            System.out.printf("The cinema is full.%nCinema income - %d lv.", sum);
        }else{
            System.out.printf("There are %d seats left in the cinema.%nCinema income - %d lv.",
                    capacityOfHall - countNumberOfSeats, sum);
        }
    }
}
