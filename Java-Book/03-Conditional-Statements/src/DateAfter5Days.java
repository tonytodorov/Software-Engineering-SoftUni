import java.util.Scanner;

public class DateAfter5Days {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int day, month, dayInMonth = 31;
        day = Integer.parseInt(scanner.nextLine());
        month = Integer.parseInt(scanner.nextLine());

        if(month == 2){
            dayInMonth = 28;
        }

        if(month == 4 || month == 6 || month == 9 || month == 11) {
            dayInMonth = 30;
        }

        day += 5;

        if(day > dayInMonth){
            day -= dayInMonth;
            month++;
        }

        System.out.printf("%d.%02d", day, month);

    }
}
