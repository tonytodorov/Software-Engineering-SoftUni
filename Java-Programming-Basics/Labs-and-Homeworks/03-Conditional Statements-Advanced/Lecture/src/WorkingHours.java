import java.util.Scanner;

public class WorkingHours {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hoursOfNight;
        String dayOfWeek;

        hoursOfNight = Integer.parseInt(scanner.nextLine());
        dayOfWeek = scanner.nextLine();

        boolean isWorkDay = dayOfWeek.equals("Monday")
                || dayOfWeek.equals("Tuesday")
                || dayOfWeek.equals("Wednesday")
                || dayOfWeek.equals("Thursday")
                || dayOfWeek.equals("Friday")
                || dayOfWeek.equals("Saturday");

        if(hoursOfNight >= 10 && hoursOfNight <= 18 && isWorkDay){
            System.out.println("open");
        }else{
            System.out.println("closed");
        }
    }
}
