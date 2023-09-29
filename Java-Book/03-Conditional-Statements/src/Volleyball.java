import java.util.Scanner;

public class Volleyball {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String year = scanner.nextLine();
        double holidays, weekends, weekendSofia, holidaysPlay, playedDays;

        holidays = Double.parseDouble(scanner.nextLine());
        weekends = Double.parseDouble(scanner.nextLine());

        weekendSofia = (48 - weekends) * 0.75;
        holidaysPlay = holidays * 0.66;
        playedDays = weekendSofia + holidaysPlay + weekends;

        if (year.equals("leap")) {
            playedDays = (playedDays * 0.15) + playedDays;
            System.out.printf("%.0f",Math.floor(playedDays));
        }else {
            System.out.printf("%.0f", Math.floor(playedDays));
        }
    }
}
