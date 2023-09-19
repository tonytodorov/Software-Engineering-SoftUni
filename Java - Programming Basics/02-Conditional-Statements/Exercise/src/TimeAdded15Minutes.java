import java.util.Scanner;

public class TimeAdded15Minutes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int hours, minutes, totalMinutes;
        hours = Integer.parseInt(scanner.nextLine());
        minutes = scanner.nextInt();

        totalMinutes = minutes + 15;

        if (totalMinutes > 59) {
            hours += 1;
            totalMinutes %= 60;
        }
        if(hours > 23){
            hours = 0;
        }
        if(totalMinutes < 10) {
            System.out.printf("%d:0%d", hours, totalMinutes);
        }
        else{
            System.out.printf("%d:%d", hours, totalMinutes);
        }
    }
}