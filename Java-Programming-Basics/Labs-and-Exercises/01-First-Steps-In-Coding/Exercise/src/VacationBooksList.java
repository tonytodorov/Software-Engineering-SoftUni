import java.util.Scanner;

public class VacationBooksList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPages, pages, numberOfDays, totalTimeForReading, neededHours;
        numberOfPages = Integer.parseInt(scanner.nextLine());
        pages = Integer.parseInt(scanner.nextLine());
        numberOfDays = scanner.nextInt();

        totalTimeForReading = numberOfPages / pages;
        neededHours = totalTimeForReading / numberOfDays;

        System.out.println(neededHours);



    }
}
